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

public class DeCompressRAR extends JFrame {
    
    /**
     * 解壓縮的線程類別
     * 
     * @author 李鍾尉
     */
    private final class DeCompressThread extends Thread {
        private final String command;
        
        private DeCompressThread(String command) {
            this.command = command;
        }
        
        public void run() {
            try {
                final Process process = Runtime.getRuntime().exec(command);
                process.getOutputStream().close();
                final Scanner scan = new Scanner(process.getInputStream());
                progressBar.setString(null);// 初始化進度條控制項
                progressBar.setValue(0);
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
                    progressBar.setValue(percent + 1);// 在進度條控制項顯示百分比
                }
                progressBar.setString("完成");
                process.getInputStream().close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    
    private JPanel contentPane;
    private JButton pathButton;
    private JPanel panel_1;
    private JLabel label;
    private JTextField compressFileField;
    private JButton browseButton;
    private File rarFile;
    private JProgressBar progressBar;
    private JTextField pathField;
    private JLabel label_1;
    private JButton deCompressButton;
    private JLabel label_2;
    private File dir;
    
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
                    DeCompressRAR frame = new DeCompressRAR();
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
    public DeCompressRAR() {
        setTitle("文件壓縮為RAR文檔");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 154);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[] { 0, 60, 0, 0 };
        gbl_panel_1.rowHeights = new int[] { 17, 0, 0, 0 };
        gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0,
                Double.MIN_VALUE };
        gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel_1.setLayout(gbl_panel_1);
        
        label = new JLabel("壓縮文檔：");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.HORIZONTAL;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 0;
        panel_1.add(label, gbc_label);
        
        compressFileField = new JTextField();
        compressFileField.setEditable(false);
        GridBagConstraints gbc_compressFileField = new GridBagConstraints();
        gbc_compressFileField.insets = new Insets(0, 0, 5, 5);
        gbc_compressFileField.fill = GridBagConstraints.HORIZONTAL;
        gbc_compressFileField.gridx = 1;
        gbc_compressFileField.gridy = 0;
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
        gbc_browseButton.gridy = 0;
        panel_1.add(browseButton, gbc_browseButton);
        
        label_1 = new JLabel("解壓路徑：");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 1;
        panel_1.add(label_1, gbc_label_1);
        
        pathField = new JTextField();
        GridBagConstraints gbc_pathField = new GridBagConstraints();
        gbc_pathField.insets = new Insets(0, 0, 5, 5);
        gbc_pathField.fill = GridBagConstraints.HORIZONTAL;
        gbc_pathField.gridx = 1;
        gbc_pathField.gridy = 1;
        panel_1.add(pathField, gbc_pathField);
        pathField.setColumns(10);
        
        pathButton = new JButton("路徑");
        GridBagConstraints gbc_pathButton = new GridBagConstraints();
        gbc_pathButton.insets = new Insets(0, 0, 5, 0);
        gbc_pathButton.gridx = 2;
        gbc_pathButton.gridy = 1;
        panel_1.add(pathButton, gbc_pathButton);
        pathButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_pathButton_actionPerformed(arg0);
            }
        });
        
        label_2 = new JLabel("進度：");
        GridBagConstraints gbc_label_2 = new GridBagConstraints();
        gbc_label_2.insets = new Insets(0, 0, 0, 5);
        gbc_label_2.gridx = 0;
        gbc_label_2.gridy = 2;
        panel_1.add(label_2, gbc_label_2);
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        GridBagConstraints gbc_progressBar = new GridBagConstraints();
        gbc_progressBar.insets = new Insets(0, 0, 0, 5);
        gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
        gbc_progressBar.gridx = 1;
        gbc_progressBar.gridy = 2;
        panel_1.add(progressBar, gbc_progressBar);
        
        deCompressButton = new JButton("解壓");
        deCompressButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_deCompressButton_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_deCompressButton = new GridBagConstraints();
        gbc_deCompressButton.gridx = 2;
        gbc_deCompressButton.gridy = 2;
        panel_1.add(deCompressButton, gbc_deCompressButton);
    }
    
    /**
     * 路徑按鈕的事件處理方法
     * 
     * @param arg0
     */
    protected void do_pathButton_actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        chooser.setDialogTitle("選擇解壓縮檔案夾");// 設定交談視窗標題
        chooser.setAcceptAllFileFilterUsed(false);
        // 選擇解壓縮檔案夾
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = chooser.showOpenDialog(this);// 顯示檔案開啟交談視窗
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        dir = chooser.getSelectedFile();// 獲得選擇的檔案夾
        pathField.setText(dir.toString());// 把檔案夾路徑跟新到文字框
    }
    
    /**
     * 選擇RAR壓縮文件的瀏覽按鈕的事件處理方法
     * 
     * @param arg0
     */
    protected void do_browseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        // 設定選擇檔案型態為Rar
        chooser.setFileFilter(new FileNameExtensionFilter("RAR壓縮文件", "rar"));
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setDialogTitle("選擇RAR壓縮檔案");// 設定交談視窗標題
        int option = chooser.showOpenDialog(this);// 顯示儲存交談視窗
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        rarFile = chooser.getSelectedFile();// 獲得使用者定製的RAR檔案
        compressFileField.setText(rarFile.getPath());// 顯示RAR檔案路徑資訊
    }
    
    /**
     * 解壓按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_deCompressButton_actionPerformed(ActionEvent e) {
        if (rarFile == null)// 如果未選擇壓縮文件
            browseButton.doClick();// 執行選擇壓縮檔案按鈕的單擊操作
        if (dir == null)// 如果未選擇解壓縮檔案夾
            pathButton.doClick();// 執行選擇解壓縮檔案夾的路徑按鈕的單擊操作
        if (rarFile == null || dir == null)// 如果參數不全，則終止本方法
            return;
        // 建立指令字串
        final String command = "rar x " + rarFile + " " + dir + " /y";
        // 讓使用者確認是否覆蓋目標檔案夾同名檔案
        int option = JOptionPane
                .showConfirmDialog(null, "此操作會覆蓋目標檔案夾同名檔案，是否繼續");
        if (option != JOptionPane.YES_OPTION)
            return;// 不覆蓋目標檔案夾內容則不執行解壓縮
        new DeCompressThread(command).start();// 建立並啟動解壓縮線程
    }
}
