package com.cdd.derive;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class FullMessage extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    private LocalTableModel model = new LocalTableModel();
    private DeriveTable dtable = new DeriveTable();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FullMessage frame = new FullMessage();
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
    public FullMessage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 355);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 317);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel meaagelabel = new JLabel("員工表中所有資訊：");
        meaagelabel.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
        meaagelabel.setBounds(140, 20, 165, 26);
        panel.add(meaagelabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(29, 56, 376, 184);
        panel.add(scrollPane);
        
        table = new JTable(model);
        List list = dtable.getFullMessage();
        for(int i = 0;i<list.size();i++){
            Emp emp = (Emp)list.get(i);
            model.addRow(new Object[] { emp.getId(), emp.getName(),
                    emp.getDept(), emp.getHeadship(),emp.getJoinDate(),emp.getLaborage()});
        }
        scrollPane.setViewportView(table);        
        JButton findButton = new JButton("查詢主要資訊");
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_findButton_actionPerformed(arg0);
            }
        });
        findButton.setBounds(140, 268, 142, 23);
        panel.add(findButton);
    }
    
    protected void do_findButton_actionPerformed(ActionEvent arg0) {
        MostlyFrame frame = new MostlyFrame();
        frame.setVisible(true);
    }
}
