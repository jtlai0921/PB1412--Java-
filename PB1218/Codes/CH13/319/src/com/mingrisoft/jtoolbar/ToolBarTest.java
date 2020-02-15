package com.mingrisoft.jtoolbar;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ToolBarTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3983765787849972310L;
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
                    ToolBarTest frame = new ToolBarTest();
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
    public ToolBarTest() {
        setTitle("工具欄的應用");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 230);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JToolBar toolBar = new JToolBar();
        contentPane.add(toolBar, BorderLayout.NORTH);
        
        JButton cutButton = new JButton("");
        cutButton.setToolTipText("剪切");
        cutButton.setIcon(new ImageIcon(ToolBarTest.class.getResource("/images/cut.png")));
        toolBar.add(cutButton);
        
        JButton findButton = new JButton("");
        findButton.setToolTipText("查找");
        findButton.setIcon(new ImageIcon(ToolBarTest.class.getResource("/images/find.png")));
        toolBar.add(findButton);
        
        JButton openButton = new JButton("");
        openButton.setToolTipText("打開");
        openButton.setIcon(new ImageIcon(ToolBarTest.class.getResource("/images/open.png")));
        toolBar.add(openButton);
        
        JButton saveButton = new JButton("");
        saveButton.setToolTipText("保存");
        saveButton.setIcon(new ImageIcon(ToolBarTest.class.getResource("/images/save.png")));
        toolBar.add(saveButton);
        
        JLabel label = new JLabel("可以任意拖拽的工具欄");
        label.setFont(new Font("微軟雅黑", Font.PLAIN, 20));
        contentPane.add(label, BorderLayout.CENTER);
    }
}
