package com.lzw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

public class IconList extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IconList frame = new IconList();
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
    public IconList() {
        setTitle("�䴩�ϼЪ��C���");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 323, 294);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        final String[] values = new String[] { "���", "�Y�Ѫ�ī�G", "����", "�ɦ�", "����",
                "����", "����U" };// �إߦC�O���}�C
        final ImageIcon[] icons = new ImageIcon[values.length];// �إ߹ϼа}�C
        for (int i = 0; i < icons.length; i++) {// �ˬd�ϼа}�C
            icons[i] = new ImageIcon(getClass().getResource(
                    "/res/" + i + ".png"));// ��l�ƨC�@�Ӱ}�C����
        }
        JList list = new JList(values);// �إߦC���
        list.setSelectedIndex(0);
        ListCellRenderer renderer = new ListCellRenderer() {// �إߵۦ⾹��{
            JLabel label = new JLabel();// �إ߼��ұ��
            Color background = new Color(0, 0, 0, 0);// �إ߳z�����I����
            
            @Override
            public Component getListCellRendererComponent(final JList list,
                    Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                label.setBackground(background);// �]�w���ұ�����I����
                label.setOpaque(true);// �ϼ��Ҥ��z��
                if (value.equals(values[index])) {
                    label.setText(value + "");// �]�w���Ҥ�r
                    label.setIcon(icons[index]);// �]�w���ҹϼ�
                }
                if (isSelected) {
                    label.setBackground(Color.PINK);// �]�w��ܮɪ��I����
                } else {
                    label.setBackground(background);// �]�w����ܮɪ��I����
                }
                return label;// �Ǧ^���ұ���@���ۦⱱ�
            }
        };
        list.setCellRenderer(renderer);// �]�w�C������ۦ⾹
        scrollPane.setViewportView(list);// ��C����W�[�챲�ʭ��O
    }
}
