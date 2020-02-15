package com.mingrisoft.jmenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FontChooser extends JFrame {
    
    private static final long serialVersionUID = -560821100423371891L;
    private JPanel contentPane;
    private JCheckBoxMenuItem bold;
    private JCheckBoxMenuItem italic;
    private JRadioButtonMenuItem radioButtonMenuItem1;
    private JRadioButtonMenuItem radioButtonMenuItem2;
    private JRadioButtonMenuItem radioButtonMenuItem3;
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
                    FontChooser frame = new FontChooser();
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
    public FontChooser() {
        setTitle("複選框與單選按鈕菜單項");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu1 = new JMenu("複選框按鈕項");
        menu1.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        menuBar.add(menu1);
        
        bold = new JCheckBoxMenuItem("加粗");
        bold.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        bold.addActionListener(listener);
        menu1.add(bold);
        
        italic = new JCheckBoxMenuItem("斜體");
        italic.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        italic.addActionListener(listener);
        menu1.add(italic);
        
        JMenu menu2 = new JMenu("單選按鈕菜單項");
        menu2.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        menuBar.add(menu2);
        
        radioButtonMenuItem1 = new JRadioButtonMenuItem("華文隸書");
        radioButtonMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButtonMenuItem1_actionPerformed(e);
            }
        });
        radioButtonMenuItem1.setFont(new Font("華文隸書", Font.PLAIN, 16));
        menu2.add(radioButtonMenuItem1);
        
        radioButtonMenuItem2 = new JRadioButtonMenuItem("微軟雅黑");
        radioButtonMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButtonMenuItem2_actionPerformed(e);
            }
        });
        radioButtonMenuItem2.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        menu2.add(radioButtonMenuItem2);
        
        radioButtonMenuItem3 = new JRadioButtonMenuItem("方正舒體");
        radioButtonMenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_radioButtonMenuItem3_actionPerformed(e);
            }
        });
        radioButtonMenuItem3.setFont(new Font("方正舒體", Font.PLAIN, 16));
        menu2.add(radioButtonMenuItem3);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonMenuItem1);
        group.add(radioButtonMenuItem2);
        group.add(radioButtonMenuItem3);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        label = new JLabel("《Java編程詞典》是每個Java愛好者的必備品！");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    private ActionListener listener = new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            int mode = 0;
            if (bold.isSelected()) {
                mode += Font.BOLD;
            }
            if (italic.isSelected()) {
                mode += Font.ITALIC;
            }
            Font font = label.getFont();
            label.setFont(new Font(font.getName(), mode, font.getSize()));
        }
    };
    
    protected void do_radioButtonMenuItem1_actionPerformed(ActionEvent e) {
        Font font = label.getFont();
        label.setFont(new Font("華文隸書", font.getStyle(), font.getSize()));
    }
    
    protected void do_radioButtonMenuItem2_actionPerformed(ActionEvent e) {
        Font font = label.getFont();
        label.setFont(new Font("微軟雅黑", font.getStyle(), font.getSize()));
    }
    
    protected void do_radioButtonMenuItem3_actionPerformed(ActionEvent e) {
        Font font = label.getFont();
        label.setFont(new Font("方正舒體", font.getStyle(), font.getSize()));
    }
}
