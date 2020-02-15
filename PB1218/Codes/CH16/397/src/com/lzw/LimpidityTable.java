package com.lzw;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class LimpidityTable extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    
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
                    LimpidityTable frame = new LimpidityTable();
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
    public LimpidityTable() {
        setTitle("��{�z���ĪG����汱�");// �]�w������D
        setResizable(false);// �T��վ�j�p
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 549);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        ImgPanel imgPanel = new ImgPanel();// �إ߹Ϥ����O
        contentPane.add(imgPanel, BorderLayout.CENTER);
        imgPanel.setLayout(null);// �����G���޲z��
        table = new JTable() {// �إߦ۩w�q���
            {
                setOpaque(false);// ��l�ƪ�欰�z��
                setGridColor(Color.MAGENTA);// �]�w�������C��
                setShowVerticalLines(true);// ��ܺ���ݽu
                setShowHorizontalLines(true);// ��ܺ����u
                setRowHeight(20);// �]�w���氪
                setBorder(new LineBorder(Color.PINK));// �]�w���
                setForeground(Color.BLACK);// �]�w����r�C��
                setFont(new Font("SansSerif", Font.PLAIN, 18));// �]�w���椸��r��
            }
            
            @Override
            public Component prepareRenderer(TableCellRenderer renderer,
                    int row, int column) {// ���s�w�q�ۦ��k
                // ��o�ۦ�᪺���
                Component component = super.prepareRenderer(renderer, row,
                        column);
                ((JComponent) component).setOpaque(false);// �]�w����z��
                return component;// �Ǧ^���
            }
        };
        table.setModel(new DefaultTableModel(
                new Object[][] {// ��l�ƪ�椺�e�P�C�W
                { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" },
                        { "Java", "Java", "Java", "Java", "Java" } },
                new String[] { "�C�W1", "�C�W2", "�C�W3", "�C�W4", "�C�W5" }));
        table.setBounds(40, 161, 421, 254);// �]�w���j�p
        imgPanel.add(table);
        JPanel panel = new JPanel();// �إߪ��Y���O
        panel.setLayout(new BorderLayout(0, 0));
        panel.add(table.getTableHeader(), BorderLayout.CENTER);// �W�[���Y
        panel.setBounds(40, 126, 421, 34);
        imgPanel.add(panel);
    }
}
