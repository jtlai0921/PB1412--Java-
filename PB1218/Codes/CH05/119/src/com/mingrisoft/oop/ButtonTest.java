package com.mingrisoft.oop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5726190585100402900L;
    private JPanel contentPane;
    private JPanel panel;
    
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
                    ButtonTest frame = new ButtonTest();
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
    public ButtonTest() {
        setTitle("Change Background Color");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        panel.add(buttonPanel, BorderLayout.NORTH);
        
        JButton redButton = new JButton("red");
        redButton.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        redButton.addActionListener(new ColorAction(Color.RED));
        buttonPanel.add(redButton);
        
        JButton greenButton = new JButton("green");
        greenButton.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        greenButton.addActionListener(new ColorAction(Color.GREEN));
        buttonPanel.add(greenButton);
        
        JButton blueButton = new JButton("green");
        blueButton.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        blueButton.addActionListener(new ColorAction(Color.BLUE));
        buttonPanel.add(blueButton);
    }
    
    private class ColorAction implements ActionListener {
        
        private Color background;
        
        public ColorAction(Color background) {
            this.background = background;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(background);
            
        }
    }
}
