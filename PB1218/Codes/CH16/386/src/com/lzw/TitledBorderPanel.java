package com.lzw;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

public class TitledBorderPanel extends JFrame {
    
    private JPanel contentPane;
    private TitledBorder titledBorder;
    
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
                    TitledBorderPanel frame = new TitledBorderPanel();
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
    public TitledBorderPanel() {
        setTitle("實現帶標題邊框的面板容器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 448, 389);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 3, 0, 0));
        
        JPanel panel_1 = new JPanel();// 建立面板
        panel_1.setBorder(new TitledBorder(null, "水平居中的標題",
                TitledBorder.CENTER, TitledBorder.TOP));// 增加標題邊框
        contentPane.add(panel_1);
        
        JPanel panel_2 = new JPanel();// 建立置頂標題的邊框面板
        titledBorder = new TitledBorder("置頂標題");
        panel_2.setBorder(titledBorder);
        contentPane.add(panel_2);
        
        JPanel panel_3 = new JPanel();// 建立帶有邊框內建頂標題的面板
        titledBorder = new TitledBorder(null, "邊框內建頂標題", TitledBorder.LEADING,
                TitledBorder.BELOW_TOP);
        panel_3.setBorder(titledBorder);
        contentPane.add(panel_3);
        
        JPanel panel_4 = new JPanel();// 建立帶有邊框內底邊標題的面板
        titledBorder = new TitledBorder(null, "邊框內底邊標題", TitledBorder.LEADING,
                TitledBorder.ABOVE_BOTTOM);
        panel_4.setBorder(titledBorder);
        contentPane.add(panel_4);
        
        JPanel panel_5 = new JPanel();// 建立帶有底邊標題邊框的面板
        titledBorder = new TitledBorder(null, "底邊標題", TitledBorder.LEADING,
                TitledBorder.BOTTOM);
        panel_5.setBorder(titledBorder);
        contentPane.add(panel_5);
        
        JPanel panel_6 = new JPanel();// 建立帶有置底標題邊框的面板
        titledBorder = new TitledBorder(null, "置底標題", TitledBorder.LEADING,
                TitledBorder.BELOW_BOTTOM);
        panel_6.setBorder(titledBorder);
        contentPane.add(panel_6);
        
        JPanel panel_7 = new JPanel();// 建立帶有水平居中的白色標題的面板
        titledBorder = new TitledBorder(null, "", TitledBorder.CENTER,
                TitledBorder.TOP);
        panel_7.setBorder(titledBorder);
        contentPane.add(panel_7);
        
    }
    
}
