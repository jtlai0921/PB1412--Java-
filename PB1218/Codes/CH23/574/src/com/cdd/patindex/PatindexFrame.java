package com.cdd.patindex;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.PathIterator;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PatindexFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    private LocalTableModel model = new LocalTableModel();
    private  JComboBox addressComboBox ;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PatindexFrame frame = new PatindexFrame();
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
    public PatindexFrame() {
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
        
        JLabel messageLabel = new JLabel("查詢");
        messageLabel.setBounds(56, 28, 33, 15);
        panel.add(messageLabel);
        String address[] = new String[]{"吉林","黑龍江","遼寧","內蒙古","河北","安徽"};
        addressComboBox = new JComboBox(address);
        addressComboBox.setBounds(99, 25, 68, 21);
        panel.add(addressComboBox);
        
        JLabel messageLabel2 = new JLabel("地區的客戶資訊");
        messageLabel2.setBounds(184, 28, 98, 15);
        panel.add(messageLabel2);
        
        JButton findButton = new JButton("查詢");
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_findButton_actionPerformed(arg0);
            }
        });
        findButton.setBounds(292, 24, 68, 23);
        panel.add(findButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(38, 79, 357, 159);
        panel.add(scrollPane);        
        table = new JTable(model);
        scrollPane.setViewportView(table);          
    }
    protected void do_findButton_actionPerformed(ActionEvent arg0) {
        CreatePatindex patindex = new CreatePatindex();        
        List list = patindex.getPatindex(addressComboBox.getSelectedItem().toString());
        model.setRowCount(0);
        for(int i = 0;i<list.size();i++){
        Order order = (Order)list.get(i);
         model.addRow(new Object[] {order.getId(), order.getName(),
                    order.getAddress(),order.getPhone()});
        }
    }
}
