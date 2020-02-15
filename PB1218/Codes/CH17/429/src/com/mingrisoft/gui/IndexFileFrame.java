package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class IndexFileFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2008614713725440868L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JComboBox comboBox;
    private JProgressBar progressBar;
    private JTextArea textArea;
    private File chooseFile;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IndexFileFrame frame = new IndexFileFrame();
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
    public IndexFileFrame() {
        setTitle("創建磁盤索引文件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);
        
        chooseTextField = new JTextField();
        chooseTextField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        chooseTextField.setText("選擇保存磁盤索引的文件");
        choosePanel.add(chooseTextField);
        chooseTextField.setColumns(18);
        
        JButton chooseButton = new JButton("選擇文件");
        chooseButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(chooseButton);
        
        JPanel Panel = new JPanel();
        contentPane.add(Panel, BorderLayout.SOUTH);
        
        comboBox = new JComboBox();
        comboBox.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        comboBox.setMaximumRowCount(8);
        Panel.add(comboBox);
        
        File[] files = File.listRoots();
        for (File file : files) {
            comboBox.addItem(file);
        }
        comboBox.setSelectedIndex(0);
        
        JButton createButton = new JButton("創建索引");
        createButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_createButton_actionPerformed(arg0);
            }
        });
        Panel.add(createButton);
        
        progressBar = new JProgressBar();
        progressBar.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        Panel.add(progressBar);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("文字檔案", "txt"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            chooseFile = fileChooser.getSelectedFile();
            chooseTextField.setText(chooseFile.getAbsolutePath());
        }
    }
    
    protected void do_createButton_actionPerformed(ActionEvent arg0) {
        if (chooseFile == null) {
            JOptionPane.showMessageDialog(this, "請選擇儲存索引的檔案", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String disc = comboBox.getSelectedItem().toString();// 獲得使用者選擇的磁碟
        comboBox.setSelectedItem(disc);// 設定JComboBox顯示使用者選擇的磁碟
        final List<String> list = new ArrayList<String>();// 用list儲存索引
        final File rootFile = new File(disc);// 利用使用者選擇的磁碟建立File對像
        final StringBuilder sb = new StringBuilder();// 利用StringBuilder對像儲存寫入的索引
        progressBar.setIndeterminate(true);// 設定捲動條開始捲動
        new Thread() {// 在一個新的線程中處理建立索引和寫入索引的操作
            @Override
            public void run() {
                getFilePath(list, rootFile);// 獲得磁碟上所有檔案的路徑
                Iterator<String> iterator = list.iterator();// 建立迭代器
                while (iterator.hasNext()) {// 檢查list
                    sb.append(iterator.next());
                    sb.append("\r\n");
                    try {
                        Thread.sleep(100);// 線程休眠0.1秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    textArea.setText(sb.toString());// 在文字域中顯示檔案路徑
                }
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(chooseFile);
                    fileWriter.write(textArea.getText());// 向使用者選擇的文字檔案寫入資料
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 省略釋放資源的程式碼
                progressBar.setIndeterminate(false);// 停止進度條的捲動
                JOptionPane.showMessageDialog(null, "索引建立成功");// 提示使用者索引建立成功
            };
        }.start();
    }
    
    private static List<String> getFilePath(List<String> list, File rootFile) {
        File[] files = rootFile.listFiles();
        if (files == null)
            return list;
        for (File file : files) {
            if (file.isDirectory()) {
                getFilePath(list, file);
            } else {
                list.add(file.getAbsolutePath().replace("\\", "/"));
            }
        }
        return list;
    }
    
}
