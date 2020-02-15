package com.mingrisoft.jtextpane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ColorPaneTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5470252730830476560L;
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
                    ColorPaneTest frame = new ColorPaneTest();
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
    public ColorPaneTest() {
        setTitle("描紅顯示100內的質數");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        ColorPane textPane = new ColorPane();
        textPane.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        for (int i = 0; i < 10; i++) {
            if (isPrime(i)) {
                textPane.append(Color.RED, "0" + i + "  ");
            } else {
                textPane.append(Color.BLACK, "0" + i + "  ");
            }
        }
        for (int i = 10; i < 100; i++) {
            if (isPrime(i)) {
                textPane.append(Color.RED, "" + i + "  ");
            } else {
                textPane.append(Color.BLACK, "" + i + "  ");
            }
        }
        scrollPane.setViewportView(textPane);
    }
    
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else {
            int sqrt = (int) Math.sqrt(number);
            for (int i = 2; i <= sqrt; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
