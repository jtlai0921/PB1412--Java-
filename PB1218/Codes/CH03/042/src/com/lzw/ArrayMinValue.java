package com.lzw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class ArrayMinValue extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JLabel label;
    private JLabel label_1;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArrayMinValue frame = new ArrayMinValue();
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
    public ArrayMinValue() {
        setTitle("皚程");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 149);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(6, 36, 414, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("璸衡");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(16, 76, 90, 30);
        contentPane.add(button);
        
        label = new JLabel("\u6700\u5C0F\u503C\uFF1A");
        label.setBounds(116, 82, 304, 18);
        contentPane.add(label);
        
        label_1 = new JLabel(
                "叫块俱计だ秨3 5 2 562 125");
        label_1.setBounds(6, 6, 422, 18);
        contentPane.add(label_1);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String arrayStr = textField.getText().trim();
        for (int i = 0; i < arrayStr.length(); i++) {// 筁耾獶猭块
            char charAt = arrayStr.charAt(i);
            if (!Character.isDigit(charAt) && charAt != ' ') {
                JOptionPane.showMessageDialog(null, "块獶计ず甧");
                textField.setText("");
                return;
            }
        }
        String[] numStrs = arrayStr.split(" {1,}");// だ澄﹃
        int[] numArray = new int[numStrs.length];// ミ俱计皚
        // 锣传块俱计皚
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.valueOf(numStrs[i]);
        }
        int min = numArray[0];// ミ程计跑计
        for (int j = 0; j < numArray.length; j++) {
            if (min > numArray[j]) {// だ猂程俱计
                min = numArray[j];
            }
        }
        label.setText("皚い程计琌" + min);
    }
}
