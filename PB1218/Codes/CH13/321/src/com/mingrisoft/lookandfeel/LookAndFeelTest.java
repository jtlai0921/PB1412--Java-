package com.mingrisoft.lookandfeel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class LookAndFeelTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5073550486481259663L;
    private JPanel contentPane;
    private JComboBox comboBox;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LookAndFeelTest frame = new LookAndFeelTest();
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
    public LookAndFeelTest() {
        setTitle("查看系統支持的外觀");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        comboBox = new JComboBox();
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_comboBox_actionPerformed(e);
            }
        });
        contentPane.add(comboBox, BorderLayout.NORTH);
        UIManager.LookAndFeelInfo looks[] = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo lookAndFeelInfo : looks) {
            comboBox.addItem(lookAndFeelInfo.getClassName());
        }
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton button = new JButton("測試按鈕");
        panel.add(button);
    }
    
    protected void do_comboBox_actionPerformed(ActionEvent e) {
        final String lookAndFeel = (String) comboBox.getSelectedItem();
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(lookAndFeel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SwingUtilities.updateComponentTreeUI(contentPane);
            }
        });
    }
}
