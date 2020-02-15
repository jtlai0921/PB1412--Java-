package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;

public class SynchronizedBankFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2671056183299397274L;
    private JPanel contentPane;
    private JTextArea thread1TextArea;
    private JTextArea thread2TextArea;
    
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
                    SynchronizedBankFrame frame = new SynchronizedBankFrame();
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
    public SynchronizedBankFrame() {
        setTitle("使用重入鎖實現執行緒同步");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton startButton = new JButton("開始存錢");
        startButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        buttonPanel.add(startButton);
        
        JPanel processPanel = new JPanel();
        contentPane.add(processPanel, BorderLayout.CENTER);
        processPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JPanel thread1Panel = new JPanel();
        processPanel.add(thread1Panel);
        thread1Panel.setLayout(new BorderLayout(0, 0));
        
        JLabel thread1Label = new JLabel("執行緒1");
        thread1Label.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        thread1Label.setHorizontalAlignment(SwingConstants.CENTER);
        thread1Panel.add(thread1Label, BorderLayout.NORTH);
        
        JScrollPane thread1ScrollPane = new JScrollPane();
        thread1Panel.add(thread1ScrollPane, BorderLayout.CENTER);
        
        thread1TextArea = new JTextArea();
        thread1TextArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        thread1ScrollPane.setViewportView(thread1TextArea);
        
        JPanel thread2Panel = new JPanel();
        processPanel.add(thread2Panel);
        thread2Panel.setLayout(new BorderLayout(0, 0));
        
        JLabel thread2Label = new JLabel("執行緒2");
        thread2Label.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        thread2Label.setHorizontalAlignment(SwingConstants.CENTER);
        thread2Panel.add(thread2Label, BorderLayout.NORTH);
        
        JScrollPane thread2ScrollPane = new JScrollPane();
        thread2Panel.add(thread2ScrollPane, BorderLayout.CENTER);
        
        thread2TextArea = new JTextArea();
        thread2TextArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        thread2ScrollPane.setViewportView(thread2TextArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        Bank bank = new Bank();
        Thread thread1 = new Thread(new Transfer(bank, thread1TextArea));
        thread1.start();
        Thread thread2 = new Thread(new Transfer(bank, thread2TextArea));
        thread2.start();
    }
    
    private class Transfer implements Runnable {
        
        private Bank bank;
        private JTextArea textArea;
        
        public Transfer(Bank bank, JTextArea textArea) {
            this.bank = bank;
            this.textArea = textArea;
        }
        
        public void run() {
            for (int i = 0; i < 10; i++) {
                bank.deposit(10);
                String text = textArea.getText();
                textArea.setText(text + "賬戶的餘額是：" + bank.getAccount() + "\n");
            }
        }
    }
    
    private class Bank {
        private int account = 100;// 賬戶的初始金額是100
        private Lock lock = new ReentrantLock();// 建立重入鎖對像
        
        public void deposit(int money) {
            lock.lock();// 開啟鎖
            try {
                account += money;
            } finally {
                lock.unlock();// 關閉鎖
            }
        }
        
        public int getAccount() {// 檢視餘額
            return account;
        }
    }
    
}
