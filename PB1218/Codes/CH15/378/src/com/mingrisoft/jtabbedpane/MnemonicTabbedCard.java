package com.mingrisoft.jtabbedpane;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class MnemonicTabbedCard extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1694329659062938654L;
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
                    MnemonicTabbedCard frame = new MnemonicTabbedCard();
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
    public MnemonicTabbedCard() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("包含快捷鍵的選項卡");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
        tabbedPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        contentPane.add(tabbedPane, BorderLayout.CENTER);
        
        JLabel JavaLabel = new JLabel("《Java從入門到精通（第2版）》");
        JavaLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        tabbedPane.addTab("Java", null, JavaLabel, null);
        
        JLabel phpLabel = new JLabel("《PHP從入門到精通（第2版）》");
        phpLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        tabbedPane.addTab("PHP", null, phpLabel, null);
        
        JLabel VBLabel = new JLabel("《Visual Basic從入門到精通（第2版）》");
        VBLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        tabbedPane.addTab("Visual Basic", null, VBLabel, null);
        
        JLabel VCLabel = new JLabel("《Visual C++從入門到精通（第2版）》");
        VCLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        tabbedPane.addTab("Visual C++", null, VCLabel, null);
    }
    
protected void do_this_windowActivated(WindowEvent e) {
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_J);
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_P);
    tabbedPane.setMnemonicAt(2, KeyEvent.VK_B);
    tabbedPane.setMnemonicAt(3, KeyEvent.VK_C);
}
}
