package com.cdd.gain;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewGainFrame extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewGainFrame frame = new ViewGainFrame();
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
    public ViewGainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("��o��ƨ�Ʈw���Ҧ��x�s�L�{");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel massageLabel = new JLabel("��odb_database24��ƨ�Ʈw�U���Ҧ��x�s�L�{�W�G");
        massageLabel.setFont(new Font("�ؤ�[��", Font.PLAIN, 13));
        massageLabel.setBounds(65, 20, 297, 27);
        panel.add(massageLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(54, 71, 316, 159);
        panel.add(scrollPane);
        
        JTextArea textArea = new JTextArea();        
        scrollPane.setViewportView(textArea);
        GainProcedure procedure = new GainProcedure(); // �إߤu�����O�ﹳ
        List list = procedure.executeGain(); // �I�s��o�Ҧ��x�s�L�{��k
        for (int i = 0; i < list.size(); i++) { // �`���ˬd�d�ߵ��G
            String name = list.get(i).toString(); // ��o���G�������
            textArea.append(name + "\n"); // �V��r�줤�W�[��T
        }
    }
}
