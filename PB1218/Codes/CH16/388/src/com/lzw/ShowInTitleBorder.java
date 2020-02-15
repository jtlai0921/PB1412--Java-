package com.lzw;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class ShowInTitleBorder extends JFrame {
    
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
                    ShowInTitleBorder frame = new ShowInTitleBorder();
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
    public ShowInTitleBorder() {
        setTitle("���008  �O�M�����D���");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 176);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        GridLayout gl_contentPane = new GridLayout(0, 3);
        gl_contentPane.setHgap(10);
        contentPane.setLayout(gl_contentPane);
        setContentPane(contentPane);
        
        JPanel panel_9 = new JPanel();// �إ߭��O�e��
        titledBorder = new TitledBorder(new BevelBorder(BevelBorder.LOWERED,
                null, null, null, null), "�O�J������ت����D", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(59, 59, 59));// �إߴO�M����ĪG�����D���
        panel_9.setBorder(titledBorder);// �]�w���O�e�����
        contentPane.add(panel_9);
        
        JPanel panel_10 = new JPanel();// �إ߭��O�e��
        titledBorder = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,
                null, null), "�B�J�Ƽ��D���", TitledBorder.LEADING, TitledBorder.TOP,
                null, new Color(59, 59, 59));// �إߴO�M�B�J�ƮĪG�����D���
        panel_10.setBorder(titledBorder);// �]�w���O�e�����
        contentPane.add(panel_10);
        
        JPanel panel_11 = new JPanel();// �إ߭��O�e��
        titledBorder = new TitledBorder(new LineBorder(new Color(255, 0, 255),
                5, true), "���u�Ŧr���u�ʼ��D��", TitledBorder.LEADING, TitledBorder.TOP,
                null, Color.BLUE);// �إߴO�M���u�ĪG�����D���
        panel_11.setBorder(titledBorder);// �]�w���O�e�����
        contentPane.add(panel_11);
        
    }
    
}
