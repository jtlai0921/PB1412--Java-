package com.mingrisoft.jformattedtextfield;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntegerOnlyTextField extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6338040209770877326L;
    private JPanel contentPane;
    private JTextField textField;
    private JFormattedTextField formattedTextField;
    
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
                    IntegerOnlyTextField frame = new IntegerOnlyTextField();
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
    public IntegerOnlyTextField() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("只能輸入整數的文本域");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 1, 5, 5));
        
        JPanel inputPanel = new JPanel();
        panel.add(inputPanel);
        
        JLabel label1 = new JLabel("輸入：");
        label1.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        inputPanel.add(label1);
        
        formattedTextField = new JFormattedTextField();
        formattedTextField.setColumns(15);
        formattedTextField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        inputPanel.add(formattedTextField);
        
        JPanel outputPanel = new JPanel();
        panel.add(outputPanel);
        
        JLabel label2 = new JLabel("輸出：");
        label2.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        outputPanel.add(label2);
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        outputPanel.add(textField);
        textField.setColumns(15);
        
        JPanel buttonPanel = new JPanel();
        panel.add(buttonPanel);
        
        JButton button = new JButton("顯示結果");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        buttonPanel.add(button);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        formattedTextField.setValue(new Integer(0));
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        textField.setText(formattedTextField.getValue().toString());
    }
}