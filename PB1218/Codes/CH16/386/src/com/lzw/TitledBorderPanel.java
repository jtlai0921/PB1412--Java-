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
        setTitle("��{�a���D��ت����O�e��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 448, 389);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 3, 0, 0));
        
        JPanel panel_1 = new JPanel();// �إ߭��O
        panel_1.setBorder(new TitledBorder(null, "�����~�������D",
                TitledBorder.CENTER, TitledBorder.TOP));// �W�[���D���
        contentPane.add(panel_1);
        
        JPanel panel_2 = new JPanel();// �إ߸m�����D����ح��O
        titledBorder = new TitledBorder("�m�����D");
        panel_2.setBorder(titledBorder);
        contentPane.add(panel_2);
        
        JPanel panel_3 = new JPanel();// �إ߱a����ؤ��س����D�����O
        titledBorder = new TitledBorder(null, "��ؤ��س����D", TitledBorder.LEADING,
                TitledBorder.BELOW_TOP);
        panel_3.setBorder(titledBorder);
        contentPane.add(panel_3);
        
        JPanel panel_4 = new JPanel();// �إ߱a����ؤ�������D�����O
        titledBorder = new TitledBorder(null, "��ؤ�������D", TitledBorder.LEADING,
                TitledBorder.ABOVE_BOTTOM);
        panel_4.setBorder(titledBorder);
        contentPane.add(panel_4);
        
        JPanel panel_5 = new JPanel();// �إ߱a��������D��ت����O
        titledBorder = new TitledBorder(null, "������D", TitledBorder.LEADING,
                TitledBorder.BOTTOM);
        panel_5.setBorder(titledBorder);
        contentPane.add(panel_5);
        
        JPanel panel_6 = new JPanel();// �إ߱a���m�����D��ت����O
        titledBorder = new TitledBorder(null, "�m�����D", TitledBorder.LEADING,
                TitledBorder.BELOW_BOTTOM);
        panel_6.setBorder(titledBorder);
        contentPane.add(panel_6);
        
        JPanel panel_7 = new JPanel();// �إ߱a�������~�����զ���D�����O
        titledBorder = new TitledBorder(null, "", TitledBorder.CENTER,
                TitledBorder.TOP);
        panel_7.setBorder(titledBorder);
        contentPane.add(panel_7);
        
    }
    
}
