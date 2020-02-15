package com.lzw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

/**
 * @author 李鍾尉
 */
public class LoginFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JTextField userName = null;
    private JPasswordField password = null;
    private JButton loginButton = null;
    
    /**
     * 建立使用者名稱文字框
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getUserName() {
        if (userName == null) {
            userName = new JTextField();// 建立文字框
            userName.setBackground(new Color(0, 0, 0, 0));// 設定文字框透明背景色
            // 設定文字框位置與大小
            userName.setBounds(new Rectangle(70, 26, 162, 21));// 設定文字框大小
            MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(0, 250,
                    154));// 建立邊框
            userName.setBorder(border);// 色繪製邊框
        }
        return userName;
    }
    
    /**
     * 建立密碼框
     * 
     * @return javax.swing.JPasswordField
     */
    private JPasswordField getPassword() {
        if (password == null) {
            password = new JPasswordField();// 建立密碼框
            // 設定密碼框位置和大小
            password.setBounds(new Rectangle(71, 57, 159, 22));
            password.setBackground(new Color(0, 0, 0, 0));// 設定透明顏色
            password.setOpaque(false);// 設定透明
            password.setBorder(new MatteBorder(0, 0, 2, 0, new Color(255, 215,
                    0)));// 設定邊框
            password.setEchoChar('★');// 設定密碼框字符
        }
        return password;
    }
    
    /**
     * 建立登入按鈕
     * 
     * @return javax.swing.JButton
     */
    private JButton getLoginButton() {
        if (loginButton == null) {
            loginButton = new JButton("登入");
            // 設定按鈕位置與大小
            loginButton.setBounds(new Rectangle(244, 22, 68, 68));
        }
        return loginButton;
    }
    
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("文字框的下劃線邊框");
        jContentPane = new JPanel();
        // 設定窗體內容面板
        this.setContentPane(jContentPane);
        // 設定佈局管理器
        jContentPane.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.add(getUserName(), null);// 增加文字框
        panel.add(getPassword(), null);// 增加密碼框
        panel.add(getLoginButton(), null);// 增加登入按鈕
        jContentPane.add(panel, BorderLayout.CENTER);
        
        JLabel label = new JLabel("使用者名稱：");
        label.setBounds(22, 26, 55, 18);
        panel.add(label);
        
        JLabel label_1 = new JLabel("密　碼：");
        label_1.setBounds(22, 59, 55, 18);
        panel.add(label_1);
        // 設定窗體大小
        setSize(new Dimension(375, 143));
        setLocationRelativeTo(null);// 窗體居中
    }
}
