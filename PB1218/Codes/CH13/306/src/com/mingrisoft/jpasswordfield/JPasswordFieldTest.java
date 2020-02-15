package com.mingrisoft.jpasswordfield;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class JPasswordFieldTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8633179606754193326L;
    private JPanel contentPane;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    
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
                    JPasswordFieldTest frame = new JPasswordFieldTest();
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
    public JPasswordFieldTest() {
        setTitle("密碼域控件簡單應用");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 1, 5, 5));
        
        JPanel passwordPanel1 = new JPanel();
        contentPane.add(passwordPanel1);
        
        JLabel label1 = new JLabel("輸入密碼：");
        label1.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        passwordPanel1.add(label1);
        
        passwordField1 = new JPasswordField();
        passwordField1.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        passwordField1.setColumns(20);
        passwordPanel1.add(passwordField1);
        
        JPanel passwordPanel2 = new JPanel();
        contentPane.add(passwordPanel2);
        
        JLabel label2 = new JLabel("確認密碼：");
        label2.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        passwordPanel2.add(label2);
        
        passwordField2 = new JPasswordField();
        passwordField2.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        passwordField2.setColumns(20);
        passwordPanel2.add(passwordField2);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel);
        
        JButton submitButton = new JButton("提交");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_submitButton_actionPerformed(e);
            }
        });
        submitButton.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        buttonPanel.add(submitButton);
    }
    
    protected void do_submitButton_actionPerformed(ActionEvent e) {
        char[] password1 = passwordField1.getPassword();
        char[] password2 = passwordField2.getPassword();
        if (password1.length < 6) {
            JOptionPane.showMessageDialog(this, "密碼長度小於6位", "", JOptionPane.WARNING_MESSAGE);
        } else if (!Arrays.equals(password1, password2)) {
            JOptionPane.showMessageDialog(this, "兩次密碼不同", "", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "兩次密碼相同", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
