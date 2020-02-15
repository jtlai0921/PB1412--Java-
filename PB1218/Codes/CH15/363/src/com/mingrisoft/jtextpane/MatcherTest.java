package com.mingrisoft.jtextpane;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class MatcherTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2190653167733357032L;
    private JPanel contentPane;
    private ParenthesisMatcher textPane;
    
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
                    MatcherTest frame = new MatcherTest();
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
    public MatcherTest() {
        setTitle("´ú¸Õ¬A¸¹ªº¤Ç°tª¬ºA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton button = new JButton("ÀË¬d");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        panel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textPane = new ParenthesisMatcher();
        textPane.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        scrollPane.setViewportView(textPane);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        textPane.validate();
    }
}
