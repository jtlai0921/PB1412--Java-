package com.mingrisoft.jcheckbox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class JCheckBoxTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -510595213739280006L;
    private JPanel contentPane;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JLabel label;
    
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
                    JCheckBoxTest frame = new JCheckBoxTest();
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
    public JCheckBoxTest() {
        setTitle("能預覽圖片的複選框");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(1, 2, 5, 5));
        
        JPanel checkboxPanel = new JPanel();
        contentPane.add(checkboxPanel);
        checkboxPanel.setLayout(new GridLayout(0, 1, 0, 0));
        
        checkBox1 = new JCheckBox("圖片1");
        checkBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_checkBox1_actionPerformed(e);
            }
        });
        checkboxPanel.add(checkBox1);
        
        checkBox2 = new JCheckBox("圖片2");
        checkBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_checkBox2_actionPerformed(e);
            }
        });
        checkboxPanel.add(checkBox2);
        
        checkBox3 = new JCheckBox("圖片3");
        checkBox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_checkBox3_actionPerformed(e);
            }
        });
        checkboxPanel.add(checkBox3);
        
        checkBox4 = new JCheckBox("圖片4");
        checkBox4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_checkBox4_actionPerformed(e);
            }
        });
        checkboxPanel.add(checkBox4);
        
        JPanel imagePanel = new JPanel();
        contentPane.add(imagePanel);
        imagePanel.setLayout(new BorderLayout(0, 0));
        
        label = new JLabel("");
        imagePanel.add(label, BorderLayout.CENTER);
    }
    
    protected void do_checkBox1_actionPerformed(ActionEvent e) {
        if(checkBox1.isSelected()) {
            ImageIcon icon = new ImageIcon("src/images/1.png");
            label.setIcon(icon);
        }
    }
    protected void do_checkBox2_actionPerformed(ActionEvent e) {
        if(checkBox2.isSelected()) {
            ImageIcon icon = new ImageIcon("src/images/2.png");
            label.setIcon(icon);
        }
    }
    protected void do_checkBox3_actionPerformed(ActionEvent e) {
        if(checkBox3.isSelected()) {
            ImageIcon icon = new ImageIcon("src/images/3.png");
            label.setIcon(icon);
        }
    }
    protected void do_checkBox4_actionPerformed(ActionEvent e) {
        if(checkBox4.isSelected()) {
            ImageIcon icon = new ImageIcon("src/images/4.png");
            label.setIcon(icon);
        }
    }
}
