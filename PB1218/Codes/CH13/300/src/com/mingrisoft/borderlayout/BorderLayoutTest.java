package com.mingrisoft.borderlayout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;

public class BorderLayoutTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7407367246160801736L;
    private JPanel contentPane;
    
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
                    BorderLayoutTest frame = new BorderLayoutTest();
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
    public BorderLayoutTest() {
        setTitle("��اG���t��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JButton northButton = new JButton("�_��");
        contentPane.add(northButton, BorderLayout.NORTH);
        
        JButton westButton = new JButton("���");
        contentPane.add(westButton, BorderLayout.WEST);
        
        JButton southButton = new JButton("�n��");
        contentPane.add(southButton, BorderLayout.SOUTH);
        
        JButton eastButton = new JButton("�F��");
        contentPane.add(eastButton, BorderLayout.EAST);
        
        JButton centerButton = new JButton("����");
        contentPane.add(centerButton, BorderLayout.CENTER);
    }
    
}
