package com.mingrisoft.codec;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.apache.commons.codec.binary.Base64;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Base64DecodingFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2686990740589101209L;
    private JPanel contentPane;
    private JTextArea message1TextArea;
    private JTextArea message2TextArea;
    
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
                    Base64DecodingFrame frame = new Base64DecodingFrame();
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
    public Base64DecodingFrame() {
        setTitle("Base¸Ñ½X¤u¨ã");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button = new JButton("¸Ñ½X");
        button.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        buttonPanel.add(button);
        
        JPanel messagePanel = new JPanel();
        contentPane.add(messagePanel, BorderLayout.CENTER);
        messagePanel.setLayout(new GridLayout(1, 2, 10, 10));
        
        JPanel message1Panel = new JPanel();
        messagePanel.add(message1Panel);
        message1Panel.setLayout(new BorderLayout(0, 0));
        
        JLabel message1Label = new JLabel("¤w¥[±K¦r²Å¦ê");
        message1Label.setHorizontalAlignment(SwingConstants.CENTER);
        message1Label.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        message1Panel.add(message1Label, BorderLayout.NORTH);
        
        message1TextArea = new JTextArea();
        message1TextArea.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        message1Panel.add(message1TextArea, BorderLayout.CENTER);
        
        JPanel message2Panel = new JPanel();
        messagePanel.add(message2Panel);
        message2Panel.setLayout(new BorderLayout(0, 0));
        
        JLabel message2Label = new JLabel("¥¼¥[±K¦r²Å¦ê");
        message2Label.setHorizontalAlignment(SwingConstants.CENTER);
        message2Label.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        message2Panel.add(message2Label, BorderLayout.NORTH);
        
        message2TextArea = new JTextArea();
        message2TextArea.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 16));
        message2Panel.add(message2TextArea, BorderLayout.CENTER);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        String sourceString = message1TextArea.getText();
        if (sourceString.length() == 0) {
            JOptionPane.showConfirmDialog(this, "½Ð¿é¤J­n¸Ñ½Xªº¦r¦ê", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Base64 base64 = new Base64();
        byte[] encodeBytes = base64.decode(sourceString);
        message2TextArea.setText(new String(encodeBytes));
    }
}
