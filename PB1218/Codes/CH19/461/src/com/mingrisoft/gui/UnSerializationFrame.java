package com.mingrisoft.gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Font;

public class UnSerializationFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8629232787425542633L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private File selectFile;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UnSerializationFrame frame = new UnSerializationFrame();
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
    public UnSerializationFrame() {
        setTitle("解壓縮Java對象");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(2, 1, 5, 5));
        
        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel);
        
        chooseTextField = new JTextField();
        chooseTextField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        choosePanel.add(chooseTextField);
        chooseTextField.setColumns(10);
        
        JButton chooseButton = new JButton("選擇序列化文件");
        chooseButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(chooseButton);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel);
        
        JButton unserializeButton = new JButton("反序列化");
        unserializeButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        unserializeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_unserializeButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(unserializeButton);
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("壓縮檔案", "zip"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectFile = fileChooser.getSelectedFile();
            chooseTextField.setText(selectFile.getAbsolutePath());
        }
    }
    
    protected void do_unserializeButton_actionPerformed(ActionEvent arg0) {
        if (selectFile == null) {
            JOptionPane.showMessageDialog(this, "請選擇壓縮檔案", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            unzipSerializationObject(selectFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    private static void unzipSerializationObject(File file) throws IOException, ClassNotFoundException {
        ZipFile zipFile = new ZipFile(file);// 建立ZipFile對像
        File currentFile = null;
        Enumeration e = zipFile.entries();
        while (e.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) e.nextElement();
            if (!entry.getName().endsWith(".dat")) {// 遇到副檔名是.dat的檔案就進行解壓縮
                continue;
            }
            currentFile = new File(file.getParent() + entry.getName());
            FileOutputStream out = new FileOutputStream(currentFile);
            InputStream in = zipFile.getInputStream(entry);
            int buffer = 0;
            while ((buffer = in.read()) != -1) {// 寫入檔案
                out.write(buffer);
            }
            in.close();// 釋放資源
            out.close();
        }
        FileInputStream in = new FileInputStream(currentFile);
        ObjectInputStream ois = new ObjectInputStream(in);// 讀入解壓縮後的檔案
        TestFrame frame = (TestFrame) ois.readObject();// 還原被序列化的對象
        frame.setVisible(true);// 顯示被序列化的對象
        currentFile.delete();// 刪除解壓縮產生的檔案
    }
    
}
