package com.lzw;

import static java.lang.Runtime.getRuntime;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;

public class DeleteFileFromRAR extends JFrame {
    
    private JPanel contentPane;
    private JTextField rarFileField;
    private File rarFile;
    private JTable table;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteFileFromRAR frame = new DeleteFileFromRAR();
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
    public DeleteFileFromRAR() {
        setTitle("從RAR壓縮包中刪除文件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 508, 300);
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
        panel.add(rarFileField, BorderLayout.CENTER);
        rarFileField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(new BevelBorder(
                BevelBorder.LOWERED, null, null, null, null),
                "壓縮文件列表：",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(
                        0, 0, 0)));
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
                "文件名稱", "大小",
                "壓縮後大小", "壓縮率",
                "時間" }));
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        scrollPane.setViewportView(table);
        
        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setHgap(30);
        contentPane.add(panel_1, BorderLayout.SOUTH);
        
        JButton delButton = new JButton("刪除");
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_delButton_actionPerformed(e);
            }
        });
        panel_1.add(delButton);
        
        JButton closeButton = new JButton("關閉");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_closeButton_actionPerformed(e);
            }
        });
        panel_1.add(closeButton);
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
     * 刪除按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_delButton_actionPerformed(ActionEvent e) {
        // 獲得表格資料模型
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();// 獲得表格目前選擇行
        if(selectedRow<0)return;
        // 獲得選擇行中的檔案名
        String path = model.getValueAt(selectedRow, 0).toString();
        try {
            // 執行rar刪除指令
            Process exec = getRuntime().exec(
                    "rar d -c- \"" + rarFile + "\" " + path);
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