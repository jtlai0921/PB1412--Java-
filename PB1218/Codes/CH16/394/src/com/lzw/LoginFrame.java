package com.lzw;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.lzw.login.LoginPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;

/**
 * @author 李鍾尉
 */
public class LoginFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private LoginPanel loginPanel = null;
    private JTextField textField;
    private JPasswordField passwordField;
    
    /**
     * 主類別的入口方法
     * 
     * @param args
     * @throws UnsupportedLookAndFeelException
     *             不支援的外觀
     */
    public static void main(String[] args)
            throws UnsupportedLookAndFeelException {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 設定窗體外觀
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // 建立登入窗體
                LoginFrame loginFrame = new LoginFrame();
                // 顯示登入窗體
                loginFrame.setVisible(true);
            }
        });
    }
    
    /**
     * 登入窗體的建構方法
     */
    public LoginFrame() {
        super();
        setTitle("使用圖片製作絢麗按鈕");
        // 設定窗體內容面板
        jContentPane = new JPanel();
        // 設定佈局管理器
        jContentPane.setLayout(new BorderLayout());
        loginPanel = new LoginPanel();
        loginPanel.setLayout(null);
        JButton loginButton = new JButton();
        loginButton.setBounds(266, 81, 68, 68);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        // 設定按鈕圖標
        loginButton.setIcon(new ImageIcon(getClass().getResource(
                "/com/lzw/logBut1.png")));
        loginButton.setContentAreaFilled(false);
        // 設定按鈕按下動作的圖標
        loginButton.setPressedIcon(new ImageIcon(getClass().getResource(
                "/com/lzw/logBut2.png")));
        // 設定鼠標經過按鈕的圖標
        loginButton.setRolloverIcon(new ImageIcon(getClass().getResource(
                "/com/lzw/logBut3.png")));
        // 增加按鈕事件監聽器
        loginPanel.add(loginButton);// 增加登入按鈕
        
        textField = new JTextField();// 建立文字框
        textField.setBounds(94, 81, 155, 30);
        loginPanel.add(textField);// 增加文字框到窗體
        
        passwordField = new JPasswordField();// 建立密碼框
        passwordField.setBounds(94, 113, 155, 30);
        loginPanel.add(passwordField);// 增加密碼框到窗體
        // 增加登入面板到內容面板
        jContentPane.add(loginPanel, BorderLayout.CENTER);
        this.setContentPane(jContentPane);
        // 設定窗體大小
        setSize(new Dimension(513, 248));// 呼叫初始化界面的方法
        setLocationRelativeTo(null);// 窗體居中
    }
}
