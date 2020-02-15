package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Font;
import javax.swing.UIManager;

public class FileFindFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8720909398161703242L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JTextField searchTextField;
    private File chooseFile;
    private JTextArea resultTextArea;
    
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
                    FileFindFrame frame = new FileFindFrame();
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
    public FileFindFrame() {
        setTitle("快速全盤查找文件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);
        
        JLabel chooseLabel = new JLabel("選擇索引文件：");
        chooseLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        choosePanel.add(chooseLabel);
        
        chooseTextField = new JTextField();
        chooseTextField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        choosePanel.add(chooseTextField);
        chooseTextField.setColumns(10);
        
        JButton chooseButton = new JButton("選擇文件");
        chooseButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(chooseButton);
        
        JPanel searchPanel = new JPanel();
        contentPane.add(searchPanel, BorderLayout.SOUTH);
        
        JLabel searchLabel = new JLabel("輸入關鍵字：");
        searchLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        searchPanel.add(searchLabel);
        
        searchTextField = new JTextField();
        searchTextField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        searchPanel.add(searchTextField);
        searchTextField.setColumns(10);
        
        JButton searchButton = new JButton("開始查找");
        searchButton.setFont(new Font("微軟雅黑", Font.PLAIN, 15));
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_searchButton_actionPerformed(arg0);
            }
        });
        searchPanel.add(searchButton);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        resultTextArea = new JTextArea();
        resultTextArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(resultTextArea);
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
    
    protected void do_searchButton_actionPerformed(ActionEvent arg0) {
        if (chooseFile == null) {
            JOptionPane.showMessageDialog(this, "請選擇索引檔案", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String keyword = searchTextField.getText();// 獲得使用者輸入的關鍵字
        if (keyword.length() == 0) {
            JOptionPane.showMessageDialog(this, "請輸入關鍵字", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(chooseFile);// 利用使用者選擇的檔案建立FileReader對像
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder builder = new StringBuilder();// 利用StringBuilder對像儲存索引
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null) {// 讀入文字檔案
                builder.append(temp);
                builder.append("\n");// 在每一行的尾端增加一個分隔符
            }
            String[] rows = builder.toString().split("\n");// 將索引按換行符分割
            resultTextArea.setText("");// 清空文字域
            for (String row : rows) {// 檢查讀入的文字檔案
                if (row.contains(keyword)) {// 判斷讀入的文字檔案是否包含指定的關鍵字
                    resultTextArea.append(row + "\n");// 傳回結果
                }
            }
            if (resultTextArea.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "沒有找到您需要的檔案", null, JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
