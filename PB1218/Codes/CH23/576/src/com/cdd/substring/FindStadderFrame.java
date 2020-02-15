package com.cdd.substring;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FindStadderFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    private LocalTableModel model = new LocalTableModel();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FindStadderFrame frame = new FindStadderFrame();
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
    public FindStadderFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messagelabel = new JLabel("根據身份證號碼獲得出生日期");
        messagelabel.setFont(new Font("隸書", Font.PLAIN, 16));
        messagelabel.setBounds(104, 29, 227, 15);
        panel.add(messagelabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 65, 357, 172);
        panel.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
        FindStaffer findStaffer = new FindStaffer();
        List list = findStaffer.getBirthday();
        for(int i = 0;i<list.size();i++){
            Staffer staffer = (Staffer)list.get(i);
            model.addRow(new Object[] {staffer.getId(),staffer.getsName(),
                    staffer.getCode(),staffer.getBirthday(),staffer.getDegree(),staffer.getJob()});
        }
    }
}

