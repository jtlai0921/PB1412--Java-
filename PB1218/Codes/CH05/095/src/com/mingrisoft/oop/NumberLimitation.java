package com.mingrisoft.oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class NumberLimitation extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4171458686375833479L;
    private JPanel contentPane;
    private JLabel maxResult;
    private JLabel minResult;
    private JLabel maxLabel;
    private JLabel minLabel;
    
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
                    NumberLimitation frame = new NumberLimitation();
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
    public NumberLimitation() {
        setTitle("Number type select");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 1, 5, 5));
        
        JPanel maxPanel = new JPanel();
        maxPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(maxPanel);
        maxPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        maxLabel = new JLabel("\u6700\u5927\u503C\uFF1A");
        maxLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        maxPanel.add(maxLabel);
        
        maxResult = new JLabel("");
        maxResult.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        maxPanel.add(maxResult);
        
        JPanel minPanel = new JPanel();
        minPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(minPanel);
        minPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        minLabel = new JLabel("\u6700\u5C0F\u503C\uFF1A");
        minLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        minPanel.add(minLabel);
        
        minResult = new JLabel("");
        minResult.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        minPanel.add(minResult);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(2, 3, 5, 5));
        
        JRadioButton byteRadioButton = new JRadioButton("byte");
        byteRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_byteRadioButton_actionPerformed(e);
            }
        });
        byteRadioButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        buttonPanel.add(byteRadioButton);
        
        JRadioButton shortRadioButton = new JRadioButton("short");
        shortRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_shortRadioButton_actionPerformed(e);
            }
        });
        shortRadioButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        buttonPanel.add(shortRadioButton);
        
        JRadioButton intRadioButton = new JRadioButton("int");
        intRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_intRadioButton_actionPerformed(e);
            }
        });
        intRadioButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        buttonPanel.add(intRadioButton);
        
        JRadioButton longRadioButton = new JRadioButton("long");
        longRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_longRadioButton_actionPerformed(e);
            }
        });
        longRadioButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        buttonPanel.add(longRadioButton);
        
        JRadioButton floatRadioButton = new JRadioButton("float");
        floatRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_floatRadioButton_actionPerformed(e);
            }
        });
        floatRadioButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        buttonPanel.add(floatRadioButton);
        
        JRadioButton doubleRadioButton = new JRadioButton("double");
        doubleRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_doubleRadioButton_actionPerformed(e);
            }
        });
        doubleRadioButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        buttonPanel.add(doubleRadioButton);
        
        ButtonGroup group = new ButtonGroup();
        group.add(byteRadioButton);
        group.add(shortRadioButton);
        group.add(intRadioButton);
        group.add(longRadioButton);
        group.add(floatRadioButton);
        group.add(doubleRadioButton);
    }
    
    protected void do_byteRadioButton_actionPerformed(ActionEvent e) {
        maxLabel.setText("byte型態的最大值：");
        minLabel.setText("byte型態的最小值：");
        maxResult.setText(Byte.MAX_VALUE + "");
        minResult.setText(Byte.MIN_VALUE + "");
    }
    
    protected void do_shortRadioButton_actionPerformed(ActionEvent e) {
        maxLabel.setText("short型態的最大值：");
        minLabel.setText("short型態的最小值：");
        maxResult.setText(Short.MAX_VALUE + "");
        minResult.setText(Short.MIN_VALUE + "");
    }
    
    protected void do_intRadioButton_actionPerformed(ActionEvent e) {
        maxLabel.setText("int型態的最大值：");
        minLabel.setText("int型態的最小值：");
        maxResult.setText(Integer.MAX_VALUE + "");
        minResult.setText(Integer.MIN_VALUE + "");
    }
    
    protected void do_longRadioButton_actionPerformed(ActionEvent e) {
        maxLabel.setText("long型態的最大值：");
        minLabel.setText("long型態的最小值：");
        maxResult.setText(Long.MAX_VALUE + "");
        minResult.setText(Long.MIN_VALUE + "");
    }
    
    protected void do_floatRadioButton_actionPerformed(ActionEvent e) {
        maxLabel.setText("float型態的最大值：");
        minLabel.setText("float型態的最小值：");
        maxResult.setText(Float.MAX_VALUE + "");
        minResult.setText(Float.MIN_VALUE + "");
    }
    
    protected void do_doubleRadioButton_actionPerformed(ActionEvent e) {
        maxLabel.setText("double型態的最大值：");
        minLabel.setText("double型態的最小值：");
        maxResult.setText(Double.MAX_VALUE + "");
        minResult.setText(Double.MIN_VALUE + "");
    }
}
