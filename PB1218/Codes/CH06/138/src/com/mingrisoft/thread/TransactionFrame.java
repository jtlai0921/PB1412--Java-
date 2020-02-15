package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;

public class TransactionFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4239009401384819805L;
    private JPanel contentPane;
    private JTextArea senderTextArea;
    private JTextArea receiverTextArea;
    
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
                    TransactionFrame frame = new TransactionFrame();
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
    public TransactionFrame() {
        setTitle("簡單的執行緒通訊");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button = new JButton("開始交易");
        button.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        buttonPanel.add(button);
        
        JPanel transactionPanel = new JPanel();
        contentPane.add(transactionPanel, BorderLayout.CENTER);
        transactionPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JPanel senderPanel = new JPanel();
        transactionPanel.add(senderPanel);
        senderPanel.setLayout(new BorderLayout(0, 0));
        
        JLabel senderLabel = new JLabel("賣家");
        senderLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        senderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        senderPanel.add(senderLabel, BorderLayout.NORTH);
        
        JScrollPane senderScrollPane = new JScrollPane();
        senderPanel.add(senderScrollPane, BorderLayout.CENTER);
        
        senderTextArea = new JTextArea();
        senderTextArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        senderScrollPane.setViewportView(senderTextArea);
        
        JPanel receiverPanel = new JPanel();
        transactionPanel.add(receiverPanel);
        receiverPanel.setLayout(new BorderLayout(0, 0));
        
        JLabel receiverLabel = new JLabel("買家");
        receiverLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        receiverLabel.setHorizontalAlignment(SwingConstants.CENTER);
        receiverPanel.add(receiverLabel, BorderLayout.NORTH);
        
        JScrollPane receiverScrollPane = new JScrollPane();
        receiverPanel.add(receiverScrollPane, BorderLayout.CENTER);
        
        receiverTextArea = new JTextArea();
        receiverTextArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        receiverScrollPane.setViewportView(receiverTextArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        Thread st = new Thread(sender);
        Thread rt = new Thread(receiver);
        st.start();
        rt.start();
    }
    
    private class Sender implements Runnable {
        private String[] products = { "《Java編程詞典》", "《Java範例大全》", "《視訊學Java編程》", "《細說Java》", "《Java開發實戰寶典》" };// 類比商品列表
        private volatile String product;// 儲存一個商品名稱
        private volatile boolean isValid;// 儲存賣家是否發送商品的狀態
        
        public boolean isIsValid() {// 讀取狀態
            return isValid;
        }
        
        public void setIsValid(boolean isValid) {// 設定狀態
            this.isValid = isValid;
        }
        
        public String getProduct() {// 獲得商品
            return product;
        }
        
        public void run() {
            for (int i = 0; i < 5; i++) {// 向買家發送5次商品
                while (isValid) {// 如果已經發送商品就進入等待狀態，等待買家接收
                    Thread.yield();
                }
                product = products[i];// 獲得一件商品
                String text = senderTextArea.getText();// 獲得賣家文字域資訊
                senderTextArea.setText(text + "發送：" + product + "\n");// 更新賣家文字域資訊
                try {
                    Thread.sleep(100);// 目前線程休眠0.1秒實現發送的效果
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isValid = true;// 將狀態設定為已經發送商品
            }
        }
    }
    
    private class Receiver implements Runnable {
        private Sender sender;// 建立一個對發送者的參考
        
        public Receiver(Sender sender) {// 利用建構方法初始化發送者參考
            this.sender = sender;
        }
        
        public void run() {
            for (int i = 0; i < 5; i++) {// 接收5次商品
                while (!sender.isIsValid()) {// 如果發送者沒有發送商品就進行等待
                    Thread.yield();
                }
                String text = receiverTextArea.getText();// 獲得賣家文字域資訊
                // 更新賣家文字域資訊
                receiverTextArea.setText(text + "收到：" + sender.getProduct() + "\n");
                try {
                    Thread.sleep(1000);// 線程休眠1秒實現動態發送的效果
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sender.setIsValid(false);// 設定賣家發送商品的狀態為未發送，這樣賣家就可以繼續發送商品
            }
        }
    }
    
}
