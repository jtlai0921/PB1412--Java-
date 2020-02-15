package com.lzw;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CheckIPAddress extends JFrame {
    
    private JPanel contentPane;
    private JTextField ipField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckIPAddress frame = new CheckIPAddress();
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
    public CheckIPAddress() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 280, 128);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblip = new JLabel("\u8BF7\u8F93\u5165IP\u5730\u5740\uFF1A");
        lblip.setBounds(12, 14, 92, 15);
        contentPane.add(lblip);
        
        ipField = new JTextField();
        ipField.setBounds(100, 10, 141, 25);
        contentPane.add(ipField);
        
        JButton button = new JButton("\u9A8C\u8BC1");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(66, 57, 93, 23);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = ipField.getText();// 獲得使用者輸入
        String info = matches(text);// 對輸入文字進行IP驗證
        JOptionPane.showMessageDialog(null, info);// 用交談視窗輸出驗證結果
    }
    
    /**
     * 驗證ip是否合法
     * 
     * @param text
     *            ip地址
     * @return 驗證資訊
     */
    public String matches(String text) {
        if (text != null && !text.isEmpty()) {
            // 定義正則表達式
            String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                    + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
            // 判斷ip地址是否與正則表達式比對
            if (text.matches(regex)) {
                // 傳回判斷資訊
                return text + "\n是一個合法的IP地址！";
            } else {
                // 傳回判斷資訊
                return text + "\n不是一個合法的IP地址！";
            }
        }
        // 傳回判斷資訊
        return "請輸入要驗證的IP地址！";
    }
}
