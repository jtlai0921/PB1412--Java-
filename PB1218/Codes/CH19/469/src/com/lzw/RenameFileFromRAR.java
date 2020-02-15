package com.lzw;

import static java.lang.Runtime.getRuntime;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class RenameFileFromRAR extends JFrame {
    
    private JPanel contentPane;
    private JTextField rarFileField;
    private File rarFile;
    private JTable table;
    private JTextField newFileField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RenameFileFromRAR frame = new RenameFileFromRAR();
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
    public RenameFileFromRAR() {
        setTitle("從RAR壓縮包中刪除文件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 532, 373);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 5));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(5, 0));
        
        JLabel lblrar = new JLabel("　選擇RAR文檔：");
        panel.add(lblrar, BorderLayout.WEST);
        
        JButton browseButton = new JButton("瀏覽");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_browseButton_actionPerformed(e);
            }
        });
        panel.add(browseButton, BorderLayout.EAST);
        
        rarFileField = new JTextField();
        rarFileField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
                null, null));
        panel.add(rarFileField, BorderLayout.CENTER);
        rarFileField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(2, 200));
        panel.add(scrollPane, BorderLayout.SOUTH);
        scrollPane.setBorder(new TitledBorder(new BevelBorder(
                BevelBorder.LOWERED, null, null, null, null),
                "壓縮文件列表：",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(
                        0, 0, 0)));
        
        table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(450, 100));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
                "文件名稱", "大小",
                "壓縮後大小", "壓縮率",
                "時間" }));
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (e.getValueIsAdjusting())
                            return;
                        int row = table.getSelectedRow();
                        if (row < 0)
                            return;
                        String value = table.getValueAt(row, 0) + "";
                        newFileField.setText(value);
                    }
                });
        scrollPane.setViewportView(table);
        
        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setHgap(30);
        contentPane.add(panel_1, BorderLayout.SOUTH);
        
        JButton renameButton = new JButton("重命名");
        renameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_renameButton_actionPerformed(e);
            }
        });
        panel_1.add(renameButton);
        
        JButton closeButton = new JButton("關閉");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_closeButton_actionPerformed(e);
            }
        });
        panel_1.add(closeButton);
        
        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));
        
        JLabel label = new JLabel(
                "輸入新文件名稱（注意修改文件路徑會導致文件移動）:");
        label.setVerticalAlignment(SwingConstants.BOTTOM);
        panel_2.add(label, BorderLayout.WEST);
        
        newFileField = new JTextField();
        newFileField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
                null, null));
        panel_2.add(newFileField, BorderLayout.SOUTH);
        newFileField.setColumns(10);
    }
    
    /**
     * 瀏覽按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_browseButton_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        chooser.setFileFilter(new FileNameExtensionFilter("RAR文件", "rar"));
        chooser.setAcceptAllFileFilterUsed(false);
        int option = chooser.showOpenDialog(this);// 顯示檔案開啟交談視窗
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        rarFile = chooser.getSelectedFile();// 獲得選擇的rar檔案
        rarFileField.setText(rarFile.toString());// 顯示rar檔案到文字框
        resolveFileList();
    }
    
    /**
     * 解析檔案列表資訊到表格控制項
     */
    private void resolveFileList() {
        try {
            // 執行分析註釋指令，把註釋資訊儲存在臨時檔案中
            Process process = getRuntime()
                    .exec("rar v -c- \"" + rarFile + "\"");
            process.getOutputStream().close();// 關閉處理程序輸出流
            Scanner sc = new Scanner(process.getInputStream());
            int count = 0;// 建立行索引
            // 獲得表格控制項模型
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            Vector<String> row = new Vector<String>();// 建立行資料向量
            do {
                String line = sc.nextLine();// 獲得檔案列表資訊的一行
                // 標記起始結束索引
                if (line.contains("----------------------")) {
                    count = (count == 0 ? count + 1 : -1);
                    continue;
                }
                if (count == 0)// 跳過起始標記
                    continue;
                if (count == -1)// 在結束標記終止循環
                    break;
                if (++count % 2 == 0) {// 獲得檔案名稱
                    row.add(line);
                } else {// 獲得檔案詳細資訊
                    // 把檔案詳細資訊分割為陣列
                    String[] split = line.trim().split("\\s+");
                    for (String string : split) {// 檢查詳細資訊陣列
                        row.add(string);// 把每個詳細屬性增加為表格單元資料
                    }
                    // 把行資料增加到表格資料模型
                    model.addRow(row.toArray());
                    row.clear();// 清除行資料向量對象，為下一行解析做準備
                }
            } while (sc.hasNext());
            process.getInputStream().close();// 關閉輸入流
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    
    /**
     * 關閉按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_closeButton_actionPerformed(ActionEvent e) {
        dispose();
    }
    
    /**
     * 重命名按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_renameButton_actionPerformed(ActionEvent e) {
        // 獲得表格資料模型
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();// 獲得表格目前選擇行
        if (selectedRow < 0)
            return;
        // 獲得選擇行中的檔案名
        String path = model.getValueAt(selectedRow, 0).toString();
        String newFile = newFileField.getText();// 獲得新檔案名稱
        try {
            // 執行rar改名指令
            Process exec = getRuntime().exec(
                    "rar rn -c- \"" + rarFile + "\" " + path + " " + newFile);
            // 建立處理程序輸入流
            Scanner scan = new Scanner(exec.getInputStream());
            while (scan.hasNext()) {// 變數輸入流內容
                scan.nextLine();// 清空輸入流資料
            }
            scan.close();// 關閉輸入流
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        resolveFileList();// 多載表格中檔案列表資料
    }
}
