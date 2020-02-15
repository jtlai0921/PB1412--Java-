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
        setTitle("提取技術網站數據到文件夾");
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
        String address = urlTextField.getText();// 獲得使用者輸入的網址
        String path = pathTextField.getText();// 獲得使用者選擇的儲存下載檔案的地址
        if (address.length() == 0) {
            JOptionPane.showMessageDialog(this, "請輸入下載地址", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (path.length() == 0) {
            JOptionPane.showMessageDialog(this, "請選擇儲存路徑", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        InputStream in = null;
        FileOutputStream out = null;
        try {
            URL url = new URL(address);// 利用使用者輸入的網址建立URL對像
            URLConnection conn = url.openConnection();// 利用URL對像獲得URLConnection對像
            in = conn.getInputStream();// 獲得InputStream對像
            out = new FileOutputStream(path + "download.html");// 建立下載的檔案及輸出流
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);// 寫入要下載的檔案的資料
            }
            JOptionPane.showMessageDialog(this, "下載完成");// 提示使用者下載完成
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
}
