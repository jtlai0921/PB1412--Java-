package com.mingrisoft.gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.UIManager;

public class DownloadFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4265931991434336626L;
    private JPanel contentPane;
    private JTextField urlTextField;
    private JTextField pathTextField;
    
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
                    DownloadFrame frame = new DownloadFrame();
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
    public DownloadFrame() {
        setTitle("壓縮存儲網頁");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 1, 0, 0));
        
        JPanel urlPanel = new JPanel();
        contentPane.add(urlPanel);
        
        JLabel urlLabel = new JLabel("下載地址：");
        urlLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        urlPanel.add(urlLabel);
        
        urlTextField = new JTextField();
        urlTextField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        urlPanel.add(urlTextField);
        urlTextField.setColumns(15);
        
        JPanel pathPanel = new JPanel();
        contentPane.add(pathPanel);
        
        JLabel pathLabel = new JLabel("保存路徑：");
        pathLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        pathPanel.add(pathLabel);
        
        pathTextField = new JTextField();
        pathTextField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        pathPanel.add(pathTextField);
        pathTextField.setColumns(15);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel);
        
        JButton button = new JButton("開始下載");
        button.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        
        JButton chooseButton = new JButton("選擇路徑");
        chooseButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(chooseButton);
        buttonPanel.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        String url = urlTextField.getText();
        String savePath = pathTextField.getText();
        if (url.length() == 0) {
            JOptionPane.showMessageDialog(this, "請輸入下載地址", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (savePath.length() == 0) {
            JOptionPane.showMessageDialog(this, "請選擇儲存路徑", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            zipWebPage(url, savePath);
            JOptionPane.showMessageDialog(this, "下載完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            pathTextField.setText(path);
        }
    }
    
    private static void zipWebPage(String url, String savePath) throws IOException {
        URLConnection conn = new URL(url).openConnection();// 利用使用者輸入的網址建立URL連接對像
        InputStream in = conn.getInputStream();// 獲得輸入流
        FileOutputStream fos = new FileOutputStream(savePath + "download.zip");
        ZipOutputStream zos = new ZipOutputStream(fos);
        byte[] buffer = new byte[1024];
        ZipEntry entry = new ZipEntry("download.html");// 建立名為「download.html」的壓縮項目
        zos.putNextEntry(entry);
        int read = 0;
        while ((read = in.read(buffer)) != -1) {// 寫入資料
            zos.write(buffer, 0, read);
        }
        zos.closeEntry();
        in.close();// 釋放資源
        zos.close();
        fos.close();
    }
    
}
