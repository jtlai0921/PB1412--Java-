package com.mingrisoft.flowlayout;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class FlowLayoutTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 197766755999871168L;
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
                    FlowLayoutTest frame = new FlowLayoutTest();
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
    public FlowLayoutTest() {
        setTitle("�y���G���t��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton button1 = new JButton("���s1");
        contentPane.add(button1);
        
        JButton button2 = new JButton("���s2");
        contentPane.add(button2);
        
        JButton button3 = new JButton("���s3");
        contentPane.add(button3);
        
        JButton button4 = new JButton("���s4");
        contentPane.add(button4);
        
        JButton button5 = new JButton("���s5");
        contentPane.add(button5);
        
        JButton button6 = new JButton("���s6");
        contentPane.add(button6);
        
        JButton button7 = new JButton("���s7");
        contentPane.add(button7);
        
        JButton button8 = new JButton("���s8");
        contentPane.add(button8);
    }
    
}
