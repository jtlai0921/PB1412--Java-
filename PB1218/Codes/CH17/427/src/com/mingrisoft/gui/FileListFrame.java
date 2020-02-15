package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class FileListFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -615665572894071265L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JButton chooseButton;
    private JScrollPane scrollPane;
    private JTable table;
    private JProgressBar progressBar;
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
                    FileListFrame frame = new FileListFrame();
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
    public FileListFrame() {
        setTitle("窗體動態加載磁盤文件");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent arg0) {
                do_this_windowActivated(arg0);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        
        chooseTextField = new JTextField();
        panel.add(chooseTextField);
        chooseTextField.setColumns(13);
        
        chooseButton = new JButton("選擇文件夾");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        panel.add(chooseButton);
        
        progressBar = new JProgressBar();
        panel.add(progressBar);
        
        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            chooseFile = fileChooser.getSelectedFile();// 獲得使用者選擇的檔案夾
            chooseTextField.setText(chooseFile.getAbsolutePath());// 顯示使用者選擇的檔案夾
            progressBar.setIndeterminate(true);// 設定捲動條開始捲動
            final File[] subFiles = chooseFile.listFiles();// 獲得使用者選擇的檔案夾中的所有檔案（夾）
            final DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);// 清空表格
            new Thread() {// 開始新的線程
                public void run() {
                    for (int i = 0; i < subFiles.length; i++) {// 檢查使用者選擇的檔案夾
                        if (subFiles[i].isFile()) {// 判斷是否是一個檔案
                            Object[] property = new Object[3];
                            property[0] = i + 1;// 儲存序號
                            property[1] = subFiles[i].getName();// 儲存檔案名
                            property[2] = "";
                            if (subFiles[i].isHidden()) {// 判斷是否是一個隱藏檔案
                                property[2] = "隱藏檔案";
                            }
                            model.addRow(property);// 向表格中增加記錄
                            table.setModel(model);// 更新表格
                        }
                        try {
                            Thread.sleep(100);// 線程休眠0.1秒實現動態載入
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    progressBar.setIndeterminate(false);// 停止進度條捲動
                };
            }.start();
            
        }
    }
    
    protected void do_this_windowActivated(WindowEvent arg0) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new Object[] { "序號", "檔案名", "屬性" });
    }
    
}
