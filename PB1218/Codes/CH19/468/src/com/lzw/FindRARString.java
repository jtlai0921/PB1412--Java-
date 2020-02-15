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

import javax.swing.ButtonGroup;
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
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

public class FindRARString extends JFrame {
    
    private JPanel contentPane;
    private JTextField rarFileField;
    private File rarFile;
    private JTextField searchStringField;
    private JTextField extNameField;
    private ButtonGroup group;
    private JTextArea infoArea;
    
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
                    FindRARString frame = new FindRARString();
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
    public FindRARString() {
        setTitle("在壓縮文件中查找字符串");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 508, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 5));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(5, 5));
        
        JLabel lblrar = new JLabel("選擇RAR文檔：");
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
        
        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.SOUTH);
        panel_2.setLayout(new BorderLayout(5, 0));
        
        JLabel label = new JLabel("輸入搜索文本：");
        panel_2.add(label, BorderLayout.WEST);
        
        searchStringField = new JTextField();
        panel_2.add(searchStringField, BorderLayout.CENTER);
        searchStringField.setColumns(10);
        
        JButton searchButton = new JButton("搜索");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_searchButton_actionPerformed(e);
            }
        });
        panel_2.add(searchButton, BorderLayout.EAST);
        
        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_2.add(panel_1, BorderLayout.SOUTH);
        
        JLabel label_1 = new JLabel("指定擴展名：");
        panel_1.add(label_1);
        
        extNameField = new JTextField();
        extNameField.setText("*.txt");
        panel_1.add(extNameField);
        extNameField.setColumns(10);
        
        JRadioButton radioButton1 = new JRadioButton(
                "區分大小寫");
        radioButton1.setActionCommand("c");
        panel_1.add(radioButton1);
        
        JRadioButton radioButton2 = new JRadioButton(
                "不區分大小寫");
        radioButton2.setActionCommand("i");
        radioButton2.setSelected(true);
        panel_1.add(radioButton2);
        group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(new BevelBorder(
                BevelBorder.LOWERED, null, null, null, null),
                "壓縮文件列表：",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(
                        0, 0, 0)));
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        infoArea = new JTextArea();
        scrollPane.setViewportView(infoArea);
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
    }
    
    /**
     * 搜索按鈕的事件處理方法
     * 
     * @param e
     */
protected void do_searchButton_actionPerformed(ActionEvent e) {
    String searchText = searchStringField.getText();
    if (searchText.isEmpty() || rarFile == null) {
        getToolkit().beep();// 發出提示聲音
        return;
    }
    // 獲得區分大小寫的標記
    String arg = group.getSelection().getActionCommand();
    int count = 0;
    try {
        System.out.println(
                "rar i" + arg + "=\"" + searchText + "\" -c- \"" + rarFile
                        + "\" " + extNameField.getText());
        // 執行rar指令
        Process process = getRuntime().exec(
                "rar i" + arg + "=\"" + searchText + "\" -c- \"" + rarFile
                        + "\" " + extNameField.getText());
        // 獲得處理程序的輸入流掃瞄器
        Scanner scan = new Scanner(process.getInputStream());
        infoArea.setText("");
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