package com.lzw;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class MouseZoomButton extends JFrame {
    
    private JPanel contentPane;
    
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
                    MouseZoomButton frame = new MouseZoomButton();
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
    public MouseZoomButton() {
        setTitle("���иg�L�ɫ��s��j�ĪG");// �]�w������D
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 449, 241);// �]�w����j�p�M��m
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        // �إ߰��D���ұ��
        JLabel label = new JLabel("<html><body align=center>�A�O�_���w�ϥ�Java"
                + "�y����<br>���g���ε{���H</body></html>");
        label.setHorizontalAlignment(SwingConstants.CENTER);// ���Ҥ�r�~��
        label.setFont(new Font("SansSerif", Font.PLAIN, 32));
        label.setBounds(6, 6, 421, 106);
        contentPane.add(label);
        JButton button = new JButton("���w");// �إ߫��s���
        MouseAdapter mouseAdapter = new MouseAdapter() {// �إ߹��Шƥ��ť��
            private Rectangle sourceRec;// �إ߯x�ιﹳ
            
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton button = (JButton) e.getSource();// ��o�ƥ󷽫��s
                sourceRec = button.getBounds();// �x�s���s�j�p
                button.setBounds(sourceRec.x - 10, sourceRec.y - 10,
                        sourceRec.width + 20, sourceRec.height + 20);// ����s��j
                super.mouseEntered(e);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                JButton button = (JButton) e.getSource();// ��o�ƥ󷽫��s
                if (sourceRec != null) {// �p�G���ƥ��x�Ϋh�Υ���_���s�j�p
                    button.setBounds(sourceRec);// �]�w���s�j�p
                }
                super.mouseExited(e);
            }
            
        };
        button.addMouseListener(mouseAdapter);// �����s�W�[�ƥ��ť��
        button.setBounds(59, 145, 90, 30);// �]�w���s�j�p
        contentPane.add(button);
        JButton button_1 = new JButton("�����w");// �إ߫��s���
        button_1.setBounds(259, 145, 90, 30);// ��ø�s���s��l�j�p
        button_1.addMouseListener(mouseAdapter);// �����s�W�[�ƥ��ť��
        contentPane.add(button_1);
    }
}
