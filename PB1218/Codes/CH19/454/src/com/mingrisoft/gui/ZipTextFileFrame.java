package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.UIManager;

public class ZipTextFileFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8885017327239429018L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JTable table;
    private File[] textFiles;
    
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
                    ZipTextFileFrame frame = new ZipTextFileFrame();
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
    public ZipTextFileFrame() {
        setTitle("壓縮所有文本文件");
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
        
        JButton chooseButton = new JButton("選擇文件夾");
        chooseButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(chooseButton);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton zipButton = new JButton("開始壓縮");
        zipButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        zipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_zipButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(zipButton);
        
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
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectFile = fileChooser.getSelectedFile();
            chooseTextField.setText(selectFile.getAbsolutePath());
            textFiles = selectFile.listFiles(new FileFilter() {
                
                @Override
                public boolean accept(File file) {
                    if (file.getPath().endsWith(".txt")) {
                        return true;
                    }
                    return false;
                }
            });
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setColumnIdentifiers(new Object[] { "序號", "檔案名" });
            for (int i = 0; i < textFiles.length; i++) {
                model.addRow(new Object[] { i + 1, textFiles[i].getName() });
            }
            table.setModel(model);
        }
    }
    
    protected void do_zipButton_actionPerformed(ActionEvent arg0) {
        if (chooseTextField.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "請選擇要壓縮的檔案夾", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String zipFilePath = new File(chooseTextField.getText()).getParent();
        try {
            zipFile(textFiles, new File(zipFilePath + File.separator + "java.zip"));
            JOptionPane.showMessageDialog(this, "完成壓縮");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void zipFile(File[] files, File targetZipFile) throws IOException {
        // 利用指定的targetZipFile對像建立檔案輸出流對像
        FileOutputStream fos = new FileOutputStream(targetZipFile);
        ZipOutputStream zos = new ZipOutputStream(fos);// 利用檔案輸出流建立壓縮輸出流
        byte[] buffer = new byte[1024];// 建立寫入壓縮檔案的陣列
        for (File file : files) {// 檢查全部檔案
            ZipEntry entry = new ZipEntry(file.getName());// 利用每個檔案的名字建立ZipEntry對像
            FileInputStream fis = new FileInputStream(file);// 利用每個檔案建立檔案輸入流對像
            zos.putNextEntry(entry);// 在壓縮檔案中增加一個ZipEntry對像
            int read = 0;
            while ((read = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, read);// 將輸入寫入到壓縮檔案
            }
            zos.closeEntry();// 關閉ZipEntry
            fis.close();// 釋放資源
        }
        zos.close();
        fos.close();
    }
    
}
