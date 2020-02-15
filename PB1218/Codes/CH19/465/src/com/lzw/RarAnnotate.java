package com.lzw;

import static java.lang.Runtime.getRuntime;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RarAnnotate extends JFrame {
    
    private JPanel contentPane;
    private JTextField rarFileField;
    private File rarFile;
    private JTextArea annotateArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RarAnnotate frame = new RarAnnotate();
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
    public RarAnnotate() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 5));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));
        
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
        
        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setHgap(25);
        contentPane.add(panel_1, BorderLayout.SOUTH);
        
        JButton annotateButton = new JButton("添加/修改");
        annotateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_annotateButton_actionPerformed(e);
            }
        });
        panel_1.add(annotateButton);
        
        JButton closeButton = new JButton("關閉");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_closeButton_actionPerformed(e);
            }
        });
        panel_1.add(closeButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(new BevelBorder(
                BevelBorder.LOWERED, null, null, null, null),
                "註釋文檔：", TitledBorder.LEADING,
                TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        annotateArea = new JTextArea();
        annotateArea.setLineWrap(true);
        scrollPane.setViewportView(annotateArea);
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
        try {
            // 建立臨時檔案
            File tempFile = File.createTempFile("rar", ".txt");
            // 執行分析註釋指令，把註釋資訊儲存在臨時檔案中
            Process process = getRuntime().exec(
                    "rar cw \"" + rarFile + "\" \"" + tempFile + "\" -y");
            process.getOutputStream().close();// 關閉處理程序輸出流
            Scanner sc = new Scanner(process.getInputStream());
            while (sc.hasNext()) {
                sc.nextLine();// 清空輸入流
            }
            process.getInputStream().close();// 關閉輸入流
            annotateArea.setText("");// 情況文字域內容
            Scanner scan = new Scanner(tempFile);// 建立讀取臨時檔案的掃瞄器
            while (scan.hasNext()) {
                // 把註釋資訊顯示到文字域控制項中
                annotateArea.append(scan.next() + "\n");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    
    /**
     * 關閉按鈕的事件監聽器
     * 
     * @param e
     */
    protected void do_closeButton_actionPerformed(ActionEvent e) {
        this.dispose();
    }
    
    /**
     * 增加修改按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_annotateButton_actionPerformed(ActionEvent e) {
        String annotateStr = annotateArea.getText();// 獲得註釋文字
        int length = annotateStr.getBytes().length;// 獲得註釋文字長度
        if (length > 32767) {// 限制文字長度
            JOptionPane.showMessageDialog(null, "註釋長度不能大於32767");
            return;
        }
        try {
            Process process = getRuntime().exec(// 執行增加註釋指令
                    "rar c \"" + rarFile + "\"");
            // 把註釋文字傳遞給註釋指令
            process.getOutputStream().write(annotateStr.getBytes());
            process.getOutputStream().close();// 關閉輸出流
            process.getInputStream().close();// 關閉輸入流
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
