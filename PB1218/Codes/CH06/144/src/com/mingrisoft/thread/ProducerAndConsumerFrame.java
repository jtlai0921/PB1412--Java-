package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.UIManager;

public class ProducerAndConsumerFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -1644485036183526329L;
    private JPanel contentPane;
    private final LinkedList<String> list = new LinkedList<String>();
    private static final int MAX = 10;
    private volatile int count;
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
        setTitle("�Ͳ��̩M���O�̰��D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton startButton = new JButton("�}�l�Ͳ�");
        startButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
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
        
        JLabel producerLabel = new JLabel("�Ͳ���");
        producerLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
        producerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        producerPanel.add(producerLabel, BorderLayout.NORTH);
        
        JScrollPane producerScrollPane = new JScrollPane();
        producerPanel.add(producerScrollPane, BorderLayout.CENTER);
        
        producerTextArea = new JTextArea();
        producerTextArea.setFont(new Font("�L�n����", Font.PLAIN, 16));
        producerScrollPane.setViewportView(producerTextArea);
        
        JPanel consumerPanel = new JPanel();
        resultPanel.add(consumerPanel);
        consumerPanel.setLayout(new BorderLayout(0, 0));
        
        JLabel consumerLabel = new JLabel("���O��");
        consumerLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
        consumerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        consumerPanel.add(consumerLabel, BorderLayout.NORTH);
        
        JScrollPane consumerScrollPane = new JScrollPane();
        consumerPanel.add(consumerScrollPane, BorderLayout.CENTER);
        
        consumerTextArea = new JTextArea();
        consumerTextArea.setFont(new Font("�L�n����", Font.PLAIN, 16));
        consumerScrollPane.setViewportView(consumerTextArea);
        
        JPanel storagePanel = new JPanel();
        resultPanel.add(storagePanel);
        storagePanel.setLayout(new BorderLayout(0, 0));
        
        JLabel storageLabel = new JLabel("�ܮw");
        storageLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
        storageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        storagePanel.add(storageLabel, BorderLayout.NORTH);
        
        JScrollPane storageScrollPane = new JScrollPane();
        storagePanel.add(storageScrollPane, BorderLayout.CENTER);
        
        storageTextArea = new JTextArea();
        storageTextArea.setFont(new Font("�L�n����", Font.PLAIN, 16));
        storageScrollPane.setViewportView(storageTextArea);
    }
    
    protected void do_startButton_actionPerformed(ActionEvent arg0) {
        
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        
    }
    
    private class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < MAX; i++) {// �V�ܨ�Ʈw���W�[�ӫ~�AMAX�O�ܨ�Ʈw���̤j�e�q
                synchronized (list) {// �ϥΦP�B���ӸѨM�P�B���D
                    String storage = storageTextArea.getText();// ��o��r�줺�e
                    String text = producerTextArea.getText(); // ��o��r�줺�e
                    if (list.size() == MAX) {// �p�G�ܨ�Ʈw�˺��N����
                        storageTextArea.setText(storage + "�ܨ�Ʈw�w��\n");
                        try {
                            list.wait();// �}�l����
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String product = "Java�s�{�_��";
                        list.add(product);// �V�ܨ�Ʈw���W�[�ӫ~
                        list.notify();// ������ݪ��u�{
                        producerTextArea.setText(text + "�Ͳ��G" + product + "\n");
                        count++;// �ܨ�Ʈw���ӫ~���ƶq�[�@
                        storageTextArea.setText(storage + "�ܨ�Ʈw���٦�" + count + "�Ӱӫ~\n");
                        try {
                            Thread.sleep(100);// �ثe�u�{��v0.1��
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    private class Consumer implements Runnable {
        
        public void run() {
            for (int i = 0; i < MAX; i++) {
                synchronized (list) {
                    String storage = storageTextArea.getText();
                    String text = consumerTextArea.getText();
                    if (list.size() == 0) {
                        storageTextArea.setText(storage + "�ܨ�Ʈw�w��\n");
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        consumerTextArea.setText(text + "���O�G" + list.removeLast() + "\n");
                        list.notify();
                        count--;
                        storageTextArea.setText(storage + "�ܨ�Ʈw���٦�" + count + "�Ӱӫ~\n");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    
                }
            }
        }
    }
}
