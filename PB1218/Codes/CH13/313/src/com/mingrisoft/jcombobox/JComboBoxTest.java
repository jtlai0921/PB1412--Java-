package com.mingrisoft.jcombobox;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class JComboBoxTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7359353924560627099L;
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
                    JComboBoxTest frame = new JComboBoxTest();
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
    public JComboBoxTest() {
        setTitle("顯示圖片的組合框");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        Map<String, ImageIcon> content = new LinkedHashMap<String, ImageIcon>();
        content.put("圖片1", new ImageIcon("src/images/1.png"));
        content.put("圖片2", new ImageIcon("src/images/2.png"));
        content.put("圖片3", new ImageIcon("src/images/3.png"));
        
        JComboBox comboBox = new JComboBox(content.keySet().toArray());
        ComboBoxRenderer renderer = new ComboBoxRenderer(content);
        comboBox.setRenderer(renderer);
        comboBox.setMaximumRowCount(3);
        comboBox.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        contentPane.add(comboBox, BorderLayout.CENTER);
    }
    
}
