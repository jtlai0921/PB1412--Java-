package com.mingrisoft.jtabbedpane;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VisitedCard extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3002233928005834299L;
    private JPanel contentPane;
    private JTabbedPane tabbedPane;
    
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
                    VisitedCard frame = new VisitedCard();
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
    public VisitedCard() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("記錄選擇狀態的選項卡");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                do_tabbedPane_stateChanged(e);
            }
        });
        contentPane.add(tabbedPane, BorderLayout.CENTER);
        
        JLabel imageLabel1 = new JLabel("");
        imageLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel1.setIcon(new ImageIcon(VisitedCard.class.getResource("/images/1.png")));
        imageLabel1.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        tabbedPane.addTab("圖片1", null, imageLabel1, null);
        
        JLabel imageLabel2 = new JLabel("");
        imageLabel2.setIcon(new ImageIcon(VisitedCard.class.getResource("/images/2.png")));
        imageLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel2.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        tabbedPane.addTab("圖片2", null, imageLabel2, null);
        
        JLabel imageLabel3 = new JLabel("");
        imageLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel3.setIcon(new ImageIcon(VisitedCard.class.getResource("/images/3.png")));
        imageLabel3.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        tabbedPane.addTab("圖片3", null, imageLabel3, null);
        
        JLabel imageLabel4 = new JLabel("");
        imageLabel4.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        imageLabel4.setIcon(new ImageIcon(VisitedCard.class.getResource("/images/4.png")));
        imageLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        tabbedPane.addTab("圖片4", null, imageLabel4, null);
        
        JLabel imageLabel5 = new JLabel("");
        imageLabel5.setIcon(new ImageIcon(VisitedCard.class.getResource("/images/5.png")));
        imageLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel5.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        tabbedPane.addTab("圖片5", null, imageLabel5, null);
        
        JLabel imageLabel6 = new JLabel("");
        imageLabel6.setIcon(new ImageIcon(VisitedCard.class.getResource("/images/6.png")));
        imageLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel6.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        tabbedPane.addTab("圖片6", null, imageLabel6, null);
    }
    
    protected void do_tabbedPane_stateChanged(ChangeEvent e) {
        if (tabbedPane.getSelectedComponent() != null) {
            int index = tabbedPane.getSelectedIndex();
            tabbedPane.setIconAt(index, new ImageIcon("src/images/yes.png"));
        }
        
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        for (int i = 0; i < 6; i++) {
            tabbedPane.setIconAt(i, new ImageIcon("src/images/no.png"));
        }
    }
}
