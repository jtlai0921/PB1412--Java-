package com.cdd.transfer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnterFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField userTextField;
    private JTextField passwordTextField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EnterFrame frame = new EnterFrame();
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
    public EnterFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 382, 259);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("登入窗體");
        JPanel panel = new JPanel();
        panel.setBounds(427, 0, -423, 262);
        contentPane.add(panel);
        
        JLabel userLabel = new JLabel("使用者名稱：");
        userLabel.setBounds(71, 71, 54, 15);
        contentPane.add(userLabel);
        
        userTextField = new JTextField();
        userTextField.setBounds(135, 68, 137, 21);
        contentPane.add(userTextField);
        userTextField.setColumns(10);
        
        JLabel passWordLabel = new JLabel(" 密  碼：");
        passWordLabel.setBounds(76, 117, 60, 15);
        contentPane.add(passWordLabel);
        
        passwordTextField = new JTextField();
        passwordTextField.setBounds(135, 114, 137, 21);
        contentPane.add(passwordTextField);
        passwordTextField.setColumns(10);
        
        JButton enterButton = new JButton("登入");
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_enterButton_actionPerformed(arg0);
            }
        });
        enterButton.setBounds(89, 162, 67, 23);
        contentPane.add(enterButton);
        
        JButton closeButton = new JButton("關閉");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(191, 162, 67, 23);
        contentPane.add(closeButton);
    }
    
    // 登入按鈕的單擊事件
    protected void do_enterButton_actionPerformed(ActionEvent arg0) {
        String userName = userTextField.getText();
        String passWord = passwordTextField.getText();
        TransferProcure transferProcure = new TransferProcure();
        if (!userName.equals("") && (!passWord.equals(""))) {
            String message = transferProcure.executeQuery(userName, passWord);       
            JOptionPane.showMessageDialog(getContentPane(), message, "警告提示框",
                    JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    // 關閉按鈕的單擊事件
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
