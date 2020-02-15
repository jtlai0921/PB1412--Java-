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
import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class VolumeCompress extends JFrame {
    
    /**
     * 執行壓縮工作的西南側
     * 
     * @author 李鍾尉
     */
private final class CompressThread extends Thread {
    public void run() {
        try {
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
            int volumeSize = ((Number) volumetField.getValue()).intValue();
            // 建立壓縮指令字串
            final String command = "rar a -v"+volumeSize+"k " + rarFile.getPath() + " @"
                    + listFile.getPath();
            Runtime runtime = Runtime.getRuntime();// 獲得Runtime對像
            progress = runtime.exec(command.toString() + "\n");// 執行壓縮指令
            progress.getOutputStream().close();// 關閉處理程序輸出流
            progressBar.setString(null);// 初始化進度條控制項
            progressBar.setValue(0);
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
    private JLabel lblkb;
    private JFormattedTextField volumetField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VolumeCompress frame = new VolumeCompress();
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
    public VolumeCompress() {
        setTitle("文件分卷壓縮");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
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
        gbl_panel_1.rowHeights = new int[] { 0, 17, 0 };
        gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0,
                Double.MIN_VALUE };
        gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
        panel_1.setLayout(gbl_panel_1);
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        GridBagConstraints gbc_progressBar = new GridBagConstraints();
        gbc_progressBar.gridwidth = 3;
        gbc_progressBar.insets = new Insets(0, 0, 5, 5);
        gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
        gbc_progressBar.gridx = 0;
        gbc_progressBar.gridy = 0;
        panel_1.add(progressBar, gbc_progressBar);
        
        label = new JLabel("壓縮文檔：");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.HORIZONTAL;
        gbc_label.insets = new Insets(0, 0, 0, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 1;
        panel_1.add(label, gbc_label);
        
        compressFileField = new JTextField();
        compressFileField.setEditable(false);
        GridBagConstraints gbc_compressFileField = new GridBagConstraints();
        gbc_compressFileField.insets = new Insets(0, 0, 0, 5);
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
        gbc_browseButton.gridx = 2;
        gbc_browseButton.gridy = 1;
        panel_1.add(browseButton, gbc_browseButton);
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(120, 10));
        contentPane.add(panel, BorderLayout.WEST);
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{52, 0, 0};
        gbl_panel.rowHeights = new int[]{30, 30, 30, 30, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        addButton = new JButton("增加");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_addButton_actionPerformed(arg0);
            }
        });
        GridBagConstraints gbc_addButton = new GridBagConstraints();
        gbc_addButton.anchor = GridBagConstraints.WEST;
        gbc_addButton.insets = new Insets(0, 0, 5, 5);
        gbc_addButton.gridx = 0;
        gbc_addButton.gridy = 0;
        panel.add(addButton, gbc_addButton);
        
        removeButton = new JButton("移除");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_removeButton_actionPerformed(arg0);
            }
        });
        GridBagConstraints gbc_removeButton = new GridBagConstraints();
        gbc_removeButton.anchor = GridBagConstraints.WEST;
        gbc_removeButton.insets = new Insets(0, 0, 5, 0);
        gbc_removeButton.gridx = 1;
        gbc_removeButton.gridy = 0;
        panel.add(removeButton, gbc_removeButton);
        
        compressButton = new JButton("壓縮");
        compressButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_compressButton_actionPerformed(arg0);
            }
        });
        GridBagConstraints gbc_compressButton = new GridBagConstraints();
        gbc_compressButton.anchor = GridBagConstraints.WEST;
        gbc_compressButton.insets = new Insets(0, 0, 5, 5);
        gbc_compressButton.gridx = 0;
        gbc_compressButton.gridy = 1;
        panel.add(compressButton, gbc_compressButton);
        
        stopButton = new JButton("停止");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_stopButton_actionPerformed(arg0);
            }
        });
        GridBagConstraints gbc_stopButton = new GridBagConstraints();
        gbc_stopButton.insets = new Insets(0, 0, 5, 0);
        gbc_stopButton.anchor = GridBagConstraints.WEST;
        gbc_stopButton.gridx = 1;
        gbc_stopButton.gridy = 1;
        panel.add(stopButton, gbc_stopButton);
        
        lblkb = new JLabel("分卷：（KB）");
        GridBagConstraints gbc_lblkb = new GridBagConstraints();
        gbc_lblkb.anchor = GridBagConstraints.WEST;
        gbc_lblkb.gridwidth = 2;
        gbc_lblkb.insets = new Insets(0, 0, 5, 0);
        gbc_lblkb.gridx = 0;
        gbc_lblkb.gridy = 2;
        panel.add(lblkb, gbc_lblkb);
        
        volumetField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        volumetField.setValue(1024);
        GridBagConstraints gbc_volumetField = new GridBagConstraints();
        gbc_volumetField.insets = new Insets(0, 0, 5, 0);
        gbc_volumetField.gridwidth = 2;
        gbc_volumetField.fill = GridBagConstraints.HORIZONTAL;
        gbc_volumetField.gridx = 0;
        gbc_volumetField.gridy = 3;
        panel.add(volumetField, gbc_volumetField);
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