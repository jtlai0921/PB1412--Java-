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
        setTitle("�]�t�ֱ��䪺�ﶵ�d");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font("�L�n����", Font.PLAIN, 14));
        tabbedPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        contentPane.add(tabbedPane, BorderLayout.CENTER);
        
        JLabel JavaLabel = new JLabel("�mJava�q�J�����q�]��2���^�n");
        JavaLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
        tabbedPane.addTab("Java", null, JavaLabel, null);
        
        JLabel phpLabel = new JLabel("�mPHP�q�J�����q�]��2���^�n");
        phpLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
        tabbedPane.addTab("PHP", null, phpLabel, null);
        
        JLabel VBLabel = new JLabel("�mVisual Basic�q�J�����q�]��2���^�n");
        VBLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
        tabbedPane.addTab("Visual Basic", null, VBLabel, null);
        
        JLabel VCLabel = new JLabel("�mVisual C++�q�J�����q�]��2���^�n");
        VCLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
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