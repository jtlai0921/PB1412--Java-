package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class UnZipDirectoryFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7178478435446172846L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JTable table;
    private File zipFile;
    
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
                    UnZipDirectoryFrame frame = new UnZipDirectoryFrame();
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
    public UnZipDirectoryFrame() {
        setTitle("深層文件夾壓縮包的釋放");
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
        choosePanel.add(chooseTextField);
        chooseTextField.setColumns(18);
        
        JButton chooseButton = new JButton("選擇壓縮文件");
        chooseButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(chooseButton);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton unzipButton = new JButton("開始解壓縮");
        unzipButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        unzipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_unzipButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(unzipButton);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPane.setViewportView(table);
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("文字檔案", "zip"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            zipFile = fileChooser.getSelectedFile();
            chooseTextField.setText(zipFile.getAbsolutePath());
        }
    }
    
    protected void do_unzipButton_actionPerformed(ActionEvent arg0) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new Object[] { "序號", "檔案名" });
        List<String> list = new ArrayList<String>();
        try {
            unzip(zipFile, list);
            for (int i = 0; i < list.size(); i++) {
                model.addRow(new Object[] { i + 1, list.get(i) });
            }
            table.setModel(model);
            JOptionPane.showMessageDialog(this, "解壓縮完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void unzip(File zipFile, List<String> list) throws IOException {
        // 利用使用者選擇的ZIP檔案建立ZipInputStream對像
        ZipInputStream in = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry entry;
        while ((entry = in.getNextEntry()) != null) {// 檢查所有ZipEntry對像
            if (!entry.isDirectory()) {// 如果是檔案則建立並寫入
                File tempFile = new File(zipFile.getParent() + File.separator + entry.getName());
                list.add(tempFile.getName());// 增加檔案名
                new File(tempFile.getParent()).mkdirs();// 建立檔案夾
                tempFile.createNewFile();// 建立新檔案
                FileOutputStream out = new FileOutputStream(tempFile);
                int b;
                while ((b = in.read()) != -1) {// 寫入資料
                    out.write(b);
                }
                out.close();// 釋放資源
            }
        }
        in.close();
    }
}
