package com.mingrisoft.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadPriorityTest extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1127454227002083871L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    
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
                    ThreadPriorityTest frame = new ThreadPriorityTest();
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
    public ThreadPriorityTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("check and modify thread priority");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JLabel label = new JLabel("new priority(1-10)");
        label.setFont(new Font("�L�n����", Font.PLAIN, 16));
        panel.add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("�L�n����", Font.PLAIN, 16));
        panel.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("modify");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("�L�n����", Font.PLAIN, 16));
        panel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("�L�n����", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("�L�n����", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPane.setViewportView(table);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();// ��o�ثe�u�{�Ҧb�u�{��
        Thread[] threads = new Thread[group.activeCount()];// �ϥΰ}�C�x�s���ʪ��A���u�{
        group.enumerate(threads);// ��o�Ҧ��u�{
        DefaultTableModel model = (DefaultTableModel) table.getModel(); // ��o���ҫ�
        model.setRowCount(0); // �M�Ū��ҫ��������
        model.setColumnIdentifiers(new Object[] { "�u�{ID", "�u�{�W��", "�u����" }); // �w�q���Y
        for (Thread thread : threads) {// �W�[����
            model.addRow(new Object[] { thread.getId(), thread.getName(), thread.getPriority() });
        }
        table.setModel(model);// ��s���ҫ�
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();
        Integer priority = Integer.parseInt(text);
        int selectedRow = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setValueAt(priority, selectedRow, 2);
        repaint();
    }
}
