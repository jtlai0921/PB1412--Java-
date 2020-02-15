package com.lzw;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import com.lzw.login.ProgressPanel;
import javax.swing.UIManager;

/**
 * @author 李鍾尉
 */
public class LoginFrame extends JFrame {
    
    /**
     * 登入按鈕的事件監聽器
     * 
     * @author 李鍾尉
     */
    private final class LoginActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // 顯示窗體的登入進度面板
            getGlassPane().setVisible(true);
        }
    }
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private ProgressPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton button;
    
    /**
     * 主類別的入口方法
     * 
     * @param args
     * @throws UnsupportedLookAndFeelException
     *             不支援的外觀
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
    }
    
    /**
     * 登入窗體的建構方法
     */
    public LoginFrame() {
        super();
        // 建立登入進度面板
        panel = new ProgressPanel();
        // 把登入進度面板設定為窗體頂層
        setGlassPane(panel);
        jContentPane = new JPanel();
        this.setContentPane(jContentPane);
        jContentPane.setLayout(null);
        
        JLabel label = new JLabel("XX登入窗體");
        label.setFont(new Font("SansSerif", Font.PLAIN, 28));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(6, 6, 386, 44);
        jContentPane.add(label);
        
        JLabel label_1 = new JLabel("使用者名稱：");
        label_1.setBounds(38, 75, 55, 18);
        jContentPane.add(label_1);
        
        JLabel label_2 = new JLabel("密　碼：");
        label_2.setBounds(38, 115, 55, 18);
        jContentPane.add(label_2);
        
        textField = new JTextField();
        textField.setBounds(105, 69, 168, 30);
        jContentPane.add(textField);
        textField.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(105, 109, 168, 30);
        jContentPane.add(passwordField);
        
        button = new JButton("登入");
        button.setBounds(287, 62, 90, 71);
        button.addActionListener(new LoginActionListener());
        jContentPane.add(button);
        // 設定窗體大小
        setSize(new Dimension(414, 243));
        setLocationRelativeTo(null);// 窗體居中
    }
}
