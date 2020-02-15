package com.cdd.util;

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

public class UpperAndLowerFrame extends JFrame {
    
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
                    UpperAndLowerFrame frame = new UpperAndLowerFrame();
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
    public UpperAndLowerFrame() {
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
        
        JLabel messageLabel = new JLabel("以大寫顯示姓以小寫顯示名");
        messageLabel.setFont(new Font("方正姚體", Font.PLAIN, 14));
        messageLabel.setBounds(127, 22, 188, 15);
        panel.add(messageLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(38, 69, 357, 166);
        panel.add(scrollPane);
        
        table = new JTable(model);
        UpperAndLower upperAndLower = new UpperAndLower();
        List list = upperAndLower.getUpperAndLower();
        for(int i = 0;i<list.size();i++){
            Abord abord = (Abord)list.get(i);
            model.addRow(new Object[]{abord.getFristName(),abord.getLastName(),abord.getNationality(),abord.getSpeciality()});
        }
        scrollPane.setViewportView(table);
    }
    
}
