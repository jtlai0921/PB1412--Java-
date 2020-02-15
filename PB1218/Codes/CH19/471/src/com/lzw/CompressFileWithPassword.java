package com.lzw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class CompressFileWithPassword extends JFrame {
    
    /**
     * 執行壓縮工作的西南側
     * 
     * @author 李鍾尉
     */
private final class CompressThread extends Thread {
    public void run() {
        try {
            progressBar.setString(null);// 初始化進度條控制項
            progressBar.setValue(0);
            // 獲得密碼
            String pass1 = String.valueOf(passwordField1.getPassword());
            // 獲得確認密碼
            String pass2 = String.valueOf(passwordField2.getPassword());
            String passCommand = "";// 設定密碼指令字串
            if (pass1 != null) {
                if (pass1.equals(pass2)) {// 判斷兩次密碼是否相同
                    passCommand = "-p\"" + pass1 + "\" ";// 完成密碼指令
                }else{// 如果兩次密碼不一樣則終止目前指令
                    JOptionPane.showMessageDialog(null, "兩次輸入密碼不一致");
                    return;
                }
            }
            // 獲得表格控制項的資料模型
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int rowCount = model.getRowCount();// 獲得資料模型中表格行數
            StringBuilder fileList = new StringBuilder();
            for (int i = 0; i < rowCount; i++) {// 檢查資料表格模型中的檔案對像
                File file = (File) model.getValueAt(i, 2);
                fileList.append(file.getPath() + "\n");// 把檔案路徑存到字串建構器中
            }
            // 建立臨時檔案，用於儲存壓縮檔案列表
            File listFile = File.createTempFile("fileList", ".tmp");
            FileOutputStream fout = new FileOutputStream(listFile);
            fout.write(fileList.toString().getBytes());// 儲存字串建構器資料到臨時檔案
            fout.close();
            
            // 建立壓縮指令字串
            final String command = "rar a " + passCommand
                    + rarFile.getPath() + " @" + listFile.getPath();
            Runtime runtime = Runtime.getRuntime();// 獲得Runtime對像
            progress = runtime.exec(command.toString() + "\n");// 執行壓縮指令
            progress.getOutputStream().close();// 關閉處理程序輸出流
            // 獲得處理程序輸入流
            Scanner scan = new Scanner(progress.getInputStream());
            while (scan.hasNext()) {
                String line = scan.nextLine();// 獲得處理程序提示單行資訊
                // 獲得提示資訊的進度百分比的索引位置
                int index = line.lastIndexOf("%") - 3;
                if (index <= 0)
                    continue;
                // 獲得進度百分比字串
                String substring = line.substring(index, index + 3);
                // 獲得整數的百分比數值
                int percent = Integer.parseInt(substring.trim());
                progressBar.setValue(percent);// 在進度條控制項顯示百分比
            }
            progressBar.setString("完成");
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    
    private JPanel contentPane;
    private JTable table;
    private JPanel panel;
    private JButton addButton;
    private JButton removeButton;
    private JPanel panel_1;
    private JLabel label;
    private JTextField compressFileField;
    private JButton browseButton;
    private File rarFile;
    private JButton compressButton;
    private JProgressBar progressBar;
    private JButton stopButton;
    private Process progress;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CompressFileWithPassword frame = new CompressFileWithPassword();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public CompressFileWithPassword() {
        setTitle("文件壓縮為RAR文檔");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 332);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
                "文件名稱", "文件大小",
                "文件路徑" }));
        table.getColumnModel().getColumn(0).setPreferredWidth(125);
        table.getColumnModel().getColumn(2).setPreferredWidth(250);
        table.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(table);
        scrollPane.getViewport().setBackground(Color.WHITE);
        
        panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.SOUTH);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[] { 0, 60, 0, 0 };
        gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0 };
        gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0,
                Double.MIN_VALUE };
        gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
                Double.MIN_VALUE };
        panel_1.setLayout(gbl_panel_1);
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        GridBagConstraints gbc_progressBar = new GridBagConstraints();
        gbc_progressBar.gridwidth = 3;
        gbc_progressBar.insets = new Insets(0, 0, 5, 0);
        gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
        gbc_progressBar.gridx = 0;
        gbc_progressBar.gridy = 0;
        panel_1.add(progressBar, gbc_progressBar);
        
        label = new JLabel("壓縮文檔：");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.HORIZONTAL;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 1;
        panel_1.add(label, gbc_label);
        
        compressFileField = new JTextField();
        compressFileField.setEditable(false);
        GridBagConstraints gbc_compressFileField = new GridBagConstraints();
        gbc_compressFileField.insets = new Insets(0, 0, 5, 5);
        gbc_compressFileField.fill = GridBagConstraints.HORIZONTAL;
        gbc_compressFileField.gridx = 1;
        gbc_compressFileField.gridy = 1;
        panel_1.add(compressFileField, gbc_compressFileField);
        compressFileField.setColumns(10);
        
        browseButton = new JButton("瀏覽");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_browseButton_actionPerformed(arg0);
            }
        });
        GridBagConstraints gbc_browseButton = new GridBagConstraints();
        gbc_browseButton.insets = new Insets(0, 0, 5, 0);
        gbc_browseButton.gridx = 2;
        gbc_browseButton.gridy = 1;
        panel_1.add(browseButton, gbc_browseButton);
        
        label_2 = new JLabel("輸入密碼：");
        GridBagConstraints gbc_label_2 = new GridBagConstraints();
        gbc_label_2.anchor = GridBagConstraints.EAST;
        gbc_label_2.insets = new Insets(0, 0, 5, 5);
        gbc_label_2.gridx = 0;
        gbc_label_2.gridy = 2;
        panel_1.add(label_2, gbc_label_2);
        
        passwordField1 = new JPasswordField();
        passwordField1.setEchoChar('★');
        GridBagConstraints gbc_passwordField1 = new GridBagConstraints();
        gbc_passwordField1.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField1.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField1.gridx = 1;
        gbc_passwordField1.gridy = 2;
        panel_1.add(passwordField1, gbc_passwordField1);
        
        label_3 = new JLabel("");
        label_3.setIcon(new ImageIcon(CompressFileWithPassword.class
                .getResource("/com/lzw/key.png")));
        GridBagConstraints gbc_label_3 = new GridBagConstraints();
        gbc_label_3.gridheight = 2;
        gbc_label_3.insets = new Insets(0, 0, 5, 0);
        gbc_label_3.gridx = 2;
        gbc_label_3.gridy = 2;
        panel_1.add(label_3, gbc_label_3);
        
        label_1 = new JLabel("確認密碼：");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.EAST;
        gbc_label_1.insets = new Insets(0, 0, 0, 5);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 3;
        panel_1.add(label_1, gbc_label_1);
        
        passwordField2 = new JPasswordField();
        passwordField2.setEchoChar('★');
        GridBagConstraints gbc_passwordField2 = new GridBagConstraints();
        gbc_passwordField2.insets = new Insets(0, 0, 0, 5);
        gbc_passwordField2.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField2.gridx = 1;
        gbc_passwordField2.gridy = 3;
        panel_1.add(passwordField2, gbc_passwordField2);
        
        panel = new JPanel();
        contentPane.add(panel, BorderLayout.WEST);
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        addButton = new JButton("增加");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_addButton_actionPerformed(arg0);
            }
        });
        panel.add(addButton);
        
        removeButton = new JButton("移除");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_removeButton_actionPerformed(arg0);
            }
        });
        panel.add(removeButton);
        
        compressButton = new JButton("壓縮");
        compressButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_compressButton_actionPerformed(arg0);
            }
        });
        panel.add(compressButton);
        
        stopButton = new JButton("停止");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_stopButton_actionPerformed(arg0);
            }
        });
        panel.add(stopButton);
    }
    
    /**
     * 增加按鈕的事件處理方法
     * 
     * @param arg0
     */
    protected void do_addButton_actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setMultiSelectionEnabled(true);// 設定允許檔案多選
        int option = chooser.showOpenDialog(this);// 顯示檔案開啟交談視窗
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        File[] files = chooser.getSelectedFiles();// 獲得使用者選擇檔案陣列
        // 獲得表格控制項的資料模型
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (File file : files) {// 檢查使用者選擇的檔案陣列
            // 把檔案資訊增加到表格控制項的模型中
            model.addRow(new Object[] { file.getName(), file.length(), file });
        }
    }
    
    /**
     * 移除按鈕的事件處理方法
     * 
     * @param arg0
     */
    protected void do_removeButton_actionPerformed(ActionEvent arg0) {
        int[] rows = table.getSelectedRows();// 獲得表格中勾選的行索引的陣列
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = rows.length - 1; i >= 0; i--) {
            model.removeRow(rows[i]);// 檢查並移除所有勾選行
        }
    }
    
    /**
     * 選擇壓縮RAR文件的瀏覽按鈕的事件處理方法
     * 
     * @param arg0
     */
    protected void do_browseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        // 設定選擇檔案型態為Rar
        chooser.setFileFilter(new FileNameExtensionFilter("RAR壓縮文件", "rar"));
        chooser.setAcceptAllFileFilterUsed(false);
        int option = chooser.showSaveDialog(this);// 顯示儲存交談視窗
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        rarFile = chooser.getSelectedFile();// 獲得使用者定製的RAR檔案
        compressFileField.setText(rarFile.getPath());// 顯示RAR檔案路徑資訊
    }
    
    /**
     * 壓縮按鈕的事件處理方法
     * 
     * @param arg0
     */
    protected void do_compressButton_actionPerformed(ActionEvent arg0) {
        if (rarFile == null) {
            browseButton.doClick();
            if (rarFile == null)
                return;
        }
        progressBar.setVisible(true);
        CompressThread compressThread = new CompressThread(); // 建立壓縮線程
        compressThread.start();// 啟動線程
    }
    
    /**
     * 停止按鈕的事件處理方法
     * 
     * @param arg0
     */
    protected void do_stopButton_actionPerformed(ActionEvent arg0) {
        if (progress != null) {
            progress.destroy();
            progressBar.setValue(0);
            progressBar.setVisible(false);
        }
    }
}
