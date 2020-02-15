package com.mingrisoft.oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntegerConversion extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2999739427405567838L;
    private JPanel contentPane;
    private JTextField textField;
    private JLabel label3;
    
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
                    IntegerConversion frame = new IntegerConversion();
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
    public IntegerConversion() {
        setTitle("Square Number");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 1, 5, 5));
        
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(inputPanel);
        inputPanel.setLayout(new GridLayout(0, 2, 0, 0));
        
        JLabel label1 = new JLabel("Enter a Number");
        label1.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        inputPanel.add(label1);
        
        textField = new JTextField();
        textField.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        inputPanel.add(textField);
        textField.setColumns(10);
        
        JPanel resultPanel = new JPanel();
        resultPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(resultPanel);
        resultPanel.setLayout(new GridLayout(0, 2, 0, 0));
        
        JLabel label2 = new JLabel("Result is");
        label2.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        resultPanel.add(label2);
        
        label3 = new JLabel("");
        label3.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        resultPanel.add(label3);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(buttonPanel);
        
        JButton button = new JButton("go");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        buttonPanel.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String input = textField.getText();
        int number = Integer.parseInt(input);
        label3.setText(number * number + "");
    }
}
