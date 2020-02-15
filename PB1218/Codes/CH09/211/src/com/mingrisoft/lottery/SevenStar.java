package com.mingrisoft.lottery;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SevenStar extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6787592245621788484L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    
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
                    SevenStar frame = new SevenStar();
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
    public SevenStar() {
        setTitle("七星彩號碼生成器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JLabel label = new JLabel("請輸入號碼個數：");
        label.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        panel.add(textField);
        textField.setColumns(10);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button = new JButton("生成號碼");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        buttonPanel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        int times = Integer.parseInt(textField.getText());// 獲得使用者輸入的需要產生的中獎號碼個數
        // 省略提示購買數量太多的程式碼
        StringBuilder sb = new StringBuilder();// 利用StringBuilder類別儲存彩票中獎號碼
        for (int i = 0; i < times; i++) {
            int number = new Random().nextInt((int) Math.pow(10, 7));// 產生隨機數
            String luckNumber = "" + number;
            while (luckNumber.length() < 7) {
                luckNumber = "0" + luckNumber;// 如果隨機數長度不夠7位用0補齊
            }
            sb.append(luckNumber + "\n");
        }
        textArea.setText(sb.toString());// 顯示產生的中獎號碼
    }
}
