package com.lzw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.ListSelectionModel;

import com.sun.awt.AWTUtilities;

public class RadioList extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RadioList frame = new RadioList();
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
    public RadioList() {
        setTitle("�C��������ܦC�O��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 323, 294);
        contentPane = new JPanel();
        contentPane.setOpaque(false);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        final String[] values = new String[15];// �إߦC�O���}�C
        for (int i = 0; i < values.length; i++) {
            values[i] = "�ﶵ" + (i + 1);
        }
        JList list = new JList(values);// �إߦC���
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// �C�O�����
        list.setSelectedIndex(0);// �]�w�w�]��ܪ��A���ﶵ
        list.setFixedCellHeight(30);// �]�w�C�O�����T�w����
        ListCellRenderer renderer = new ListCellRenderer() {// �إߵۦ⾹��{
            JRadioButton radio = new JRadioButton();// �إ߳����s���
            Color background = new Color(0, 0, 0, 0);// �إ߳z�����I����
            
            @Override
            public Component getListCellRendererComponent(final JList list,
                    Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                radio.setBackground(background);// �]�w�����s������I����
                radio.setOpaque(true);// �ϳ����s���z��
                if (value.equals(values[index])) {
                    radio.setText(value + "");// �]�w�����s��r
                }
                radio.setSelected(isSelected);
                return radio;// �Ǧ^�����s����@���ۦⱱ�
            }
        };
        list.setCellRenderer(renderer);// �]�w�C������ۦ⾹
        scrollPane.setViewportView(list);// ��C����W�[�챲�ʭ��O
    }
}
