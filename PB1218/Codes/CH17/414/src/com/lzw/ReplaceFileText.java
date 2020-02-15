package com.lzw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class ReplaceFileText extends JFrame {
    
    private JPanel contentPane;
    private JTextField fileField;
    private JTextField searchTextField;
    private JTextField replaceTextField;
    private File file;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReplaceFileText frame = new ReplaceFileText();
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
    public ReplaceFileText() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 501, 184);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 91));
        contentPane.add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 81, 0, 0, 66, 0 };
        gbl_panel.rowHeights = new int[] { 23, 0, 0, 0, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0,
                Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
                Double.MIN_VALUE };
        panel.setLayout(gbl_panel);
        
        JButton button = new JButton("選擇文件");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.anchor = GridBagConstraints.NORTHWEST;
        gbc_button.insets = new Insets(0, 0, 5, 5);
        gbc_button.gridx = 0;
        gbc_button.gridy = 0;
        panel.add(button, gbc_button);
        
        fileField = new JTextField();
        fileField.setEditable(false);
        GridBagConstraints gbc_fileField = new GridBagConstraints();
        gbc_fileField.gridwidth = 3;
        gbc_fileField.insets = new Insets(0, 0, 5, 0);
        gbc_fileField.fill = GridBagConstraints.HORIZONTAL;
        gbc_fileField.gridx = 1;
        gbc_fileField.gridy = 0;
        panel.add(fileField, gbc_fileField);
        fileField.setColumns(10);
        
        JLabel label = new JLabel("搜索文本：");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.anchor = GridBagConstraints.EAST;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 1;
        panel.add(label, gbc_label);
        
        searchTextField = new JTextField();
        GridBagConstraints gbc_searchTextField = new GridBagConstraints();
        gbc_searchTextField.gridwidth = 3;
        gbc_searchTextField.insets = new Insets(0, 0, 5, 0);
        gbc_searchTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_searchTextField.gridx = 1;
        gbc_searchTextField.gridy = 1;
        panel.add(searchTextField, gbc_searchTextField);
        searchTextField.setColumns(10);
        
        JLabel label_1 = new JLabel("替換為：");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.EAST;
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 2;
        panel.add(label_1, gbc_label_1);
        
        replaceTextField = new JTextField();
        GridBagConstraints gbc_replaceTextField = new GridBagConstraints();
        gbc_replaceTextField.gridwidth = 3;
        gbc_replaceTextField.insets = new Insets(0, 0, 5, 0);
        gbc_replaceTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_replaceTextField.gridx = 1;
        gbc_replaceTextField.gridy = 2;
        panel.add(replaceTextField, gbc_replaceTextField);
        replaceTextField.setColumns(10);
        
        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.gridwidth = 4;
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 3;
        panel.add(panel_1, gbc_panel_1);
        
        JButton replaceButton = new JButton("替換");
        replaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_replaceButton_actionPerformed(e);
            }
        });
        panel_1.add(replaceButton);
        
        JButton openfileButton = new JButton("打開文件");
        openfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_2_actionPerformed(e);
            }
        });
        panel_1.add(openfileButton);
    }
    
    /**
     * 選擇檔案按鈕事件處理方法
     * 
     * @param e
     */
    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser("./");// 建立檔案選擇器
        // 設定檔案擴充名過濾器
        chooser.setFileFilter(new FileNameExtensionFilter("文字檔案", "txt",
                "java", "php", "html", "htm"));
        // 設定檔案選擇模式
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // 顯示檔案開啟交談視窗
        int option = chooser.showOpenDialog(this);
        // 確定使用者按下開啟按鈕，而非取消按鈕
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        // 獲得使用者選擇的檔案對像
        file = chooser.getSelectedFile();
        // 顯示檔案資訊到文字框
        fileField.setText(file.toString());
    }
    
    /**
     * 替換按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_replaceButton_actionPerformed(ActionEvent event) {
        String searchText = searchTextField.getText();// 獲得搜索文字
        String replaceText = replaceTextField.getText();// 獲得替換文字
        if (searchText.isEmpty())
            return;
        try {
            FileReader fis = new FileReader(file);// 建立檔案輸入流
            char[] data = new char[1024];// 建立緩衝字符陣列
            int rn = 0;
            StringBuilder sb = new StringBuilder();// 建立字串建構器
            while ((rn = fis.read(data)) > 0) {// 讀取檔案內容到字串建構器
                String str = String.valueOf(data, 0, rn);
                sb.append(str);
            }
            fis.close();// 關閉輸入流
            // 從建構器中產生字串，並替換搜索文字
            String str = sb.toString().replace(searchText, replaceText);
            FileWriter fout = new FileWriter(file);// 建立檔案輸出流
            fout.write(str.toCharArray());// 把替換完成的字串寫入檔案內
            fout.close();// 關閉輸出流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "替換完成");
    }
    
    /**
     * 開啟檔案按鈕的事件處理方法。
     * 
     * @param e
     */
    protected void do_button_2_actionPerformed(ActionEvent e) {
        try {
            if (file == null)
                return;
            Desktop.getDesktop().edit(file);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
