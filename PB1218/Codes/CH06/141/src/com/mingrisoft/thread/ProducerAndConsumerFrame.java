package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Font;

public class ProducerAndConsumerFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -1644485036183526329L;
    private JPanel contentPane;
    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
    private final int size = 10;
    private JTextArea producerTextArea;
    private JTextArea consumerTextArea;
    private JTextArea storageTextArea;
    
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
                    ProducerAndConsumerFrame frame = new ProducerAndConsumerFrame();
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
    public ProducerAndConsumerFrame() {
        setTitle("使用阻塞佇列實現執行緒同步");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton startButton = new JButton("開始生產");
        startButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_startButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(startButton);
        
        JPanel resultPanel = new JPanel();
        contentPane.add(resultPanel, BorderLayout.CENTER);
        resultPanel.setLayout(new GridLayout(1, 3, 5, 5));
        
        JPanel producerPanel = new JPanel();
        resultPanel.add(producerPanel);
        producerPanel.setLayout(new BorderLayout(0, 0));
        
        JLabel producerLabel = new JLabel("生產者");
        producerLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        producerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        producerPanel.add(producerLabel, BorderLayout.NORTH);
        
        JScrollPane producerScrollPane = new JScrollPane();
        producerPanel.add(producerScrollPane, BorderLayout.CENTER);
        
        producerTextArea = new JTextArea();
        producerTextArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        producerScrollPane.setViewportView(producerTextArea);
        
        JPanel consumerPanel = new JPanel();
        resultPanel.add(consumerPanel);
        consumerPanel.setLayout(new BorderLayout(0, 0));
        
        JLabel consumerLabel = new JLabel("消費者");
        consumerLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        consumerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        consumerPanel.add(consumerLabel, BorderLayout.NORTH);
        
        JScrollPane consumerScrollPane = new JScrollPane();
        consumerPanel.add(consumerScrollPane, BorderLayout.CENTER);
        
        consumerTextArea = new JTextArea();
        consumerTextArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        consumerScrollPane.setViewportView(consumerTextArea);
        
        JPanel storagePanel = new JPanel();
        resultPanel.add(storagePanel);
        storagePanel.setLayout(new BorderLayout(0, 0));
        
        JLabel storageLabel = new JLabel("倉庫");
        storageLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        storageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        storagePanel.add(storageLabel, BorderLayout.NORTH);
        
        JScrollPane storageScrollPane = new JScrollPane();
        storagePanel.add(storageScrollPane, BorderLayout.CENTER);
        
        storageTextArea = new JTextArea();
        storageTextArea.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        storageScrollPane.setViewportView(storageTextArea);
    }
    
    protected void do_startButton_actionPerformed(ActionEvent arg0) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
    
    private class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < size; i++) {// size是域變數，表示增加商品的次數
                int b = new Random().nextInt(255); // 產生一個隨機數
                String text = producerTextArea.getText();// 獲得生產者文字域資訊
                producerTextArea.setText(text + "生產商品：" + b + "\n");// 更新文字域資訊
                try {
                    queue.put(b);// 向隊列中增加元素
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String storage = storageTextArea.getText();// 獲得倉函數庫文字域資訊
                storageTextArea.setText(storage + "倉函數庫中還有" + queue.size() + "個商品\n");
                try {
                    Thread.sleep(100);// 休眠0.1秒實現動態效果
                } catch (InterruptedException ex) {
                }
            }
        }
    }
    
    private class Consumer implements Runnable {
        
        @Override
        public void run() {
            for (int i = 0; i < size; i++) {
                int b = 0;
                try {
                    b = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String text = consumerTextArea.getText();
                consumerTextArea.setText(text + "消費商品：" + b + "\n");
                String storage = storageTextArea.getText();
                storageTextArea.setText(storage + "倉函數庫中還有" + queue.size() + "個商品\n");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }
        
    }
}
