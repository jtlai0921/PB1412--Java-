package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7584852068430067696L;
    private JPanel contentPane;
    private JTextArea textArea1;
    private JTextArea textArea2;
    
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
                    ThreadTest frame = new ThreadTest();
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
    public ThreadTest() {
        setTitle("Thread Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JButton button1 = new JButton("Single Thread");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button1_actionPerformed(e);
            }
        });
        button1.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        buttonPanel.add(button1);
        
        JButton button2 = new JButton("Multi Thread");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button2_actionPerformed(e);
            }
        });
        button2.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        buttonPanel.add(button2);
        
        JPanel contentPanel = new JPanel();
        contentPane.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JScrollPane scrollPane1 = new JScrollPane();
        contentPanel.add(scrollPane1);
        
        textArea1 = new JTextArea();
        textArea1.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        scrollPane1.setViewportView(textArea1);
        
        JScrollPane scrollPane2 = new JScrollPane();
        contentPanel.add(scrollPane2);
        
        textArea2 = new JTextArea();
        textArea2.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        scrollPane2.setViewportView(textArea2);
    }
    
    protected void do_button1_actionPerformed(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append("¡mJava½sµ{µü¨å¡n\n");
        }
        for (int i = 0; i < 5; i++) {
            sb.append("¡mµø°T¾ÇJava¡n\n");
        }
        textArea1.setText(sb.toString());
        
    }
    
    protected void do_button2_actionPerformed(ActionEvent e) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    sb.append("¡mJava½sµ{µü¨å¡n\n");
                    textArea2.setText(sb.toString());
                };
            }.start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    sb.append("¡mµø°T¾ÇJava¡n\n");
                    textArea2.setText(sb.toString());
                };
            }.start();
        }
    }
    
}
