package com.lzw;

import static java.lang.Runtime.getRuntime;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SFXRAR extends JFrame {
    
    private JPanel contentPane;
    private JTextField rarFileField;
    private File rarFile;
    private JTextArea infoArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SFXRAR frame = new SFXRAR();
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
    public SFXRAR() {
        setTitle("從RAR壓縮包中刪除文件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 226);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(15, 10, 506, 33);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(5, 5));
        
        JLabel lblrar = new JLabel("　選擇RAR文檔：");
        panel.add(lblrar, BorderLayout.WEST);
        
        JButton browseButton = new JButton("瀏覽");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_renameButton_actionPerformed(e);
            }
        });
        panel.add(browseButton, BorderLayout.EAST);
        
        rarFileField = new JTextField();
        rarFileField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
                null, null));
        panel.add(rarFileField, BorderLayout.CENTER);
        rarFileField.setColumns(10);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(15, 147, 506, 33);
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setHgap(30);
        contentPane.add(panel_1);
        
        JButton createButton = new JButton("創建");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_createButton_actionPerformed(e);
            }
        });
        panel_1.add(createButton);
        
        JButton closeButton = new JButton("關閉");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_closeButton_actionPerformed(e);
            }
        });
        panel_1.add(closeButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(15, 51, 506, 86);
        contentPane.add(scrollPane);
        
        infoArea = new JTextArea();
        scrollPane.setViewportView(infoArea);
    }
    
    /**
     * 瀏覽按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_renameButton_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        chooser.setFileFilter(new FileNameExtensionFilter("RAR文件", "rar"));
        chooser.setAcceptAllFileFilterUsed(false);
        int option = chooser.showOpenDialog(this);// 顯示檔案開啟交談視窗
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        rarFile = chooser.getSelectedFile();// 獲得選擇的rar檔案
        rarFileField.setText(rarFile.toString());// 顯示rar檔案到文字框
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
    protected void do_createButton_actionPerformed(ActionEvent e) {
        if (rarFile == null)// 驗證使用者是否選擇了rar檔案
            return;
        try {
            // 執行rar指令
            Process process = getRuntime().exec("rar s -y -c- " + rarFile);
            Scanner scan = new Scanner(process.getInputStream());
            infoArea.setText("");// 情況文字域控制項的內容
            int count = 0;
            while (scan.hasNext()) {// 檢查處理程序執行結果
                String line = scan.nextLine();// 獲得單行資訊
                if (line.isEmpty())
                    count++;
                if (count < 2)// 過濾非查詢結果
                    continue;
                infoArea.append(line + "\n");// 查詢結果增加到文字域控制項
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
