package com.cdd.useView;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserViewFrame extends JFrame {
    
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
                    UserViewFrame frame = new UserViewFrame();
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
    public UserViewFrame() {
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
        
        JLabel messageLabel = new JLabel("©I¥sÀËµø¬d¸ß¸ê®Æ");
        messageLabel.setFont(new Font("·L³n¶®¶Â", Font.PLAIN, 14));
        messageLabel.setBounds(148, 28, 152, 15);
        panel.add(messageLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(44, 70, 325, 141);
        panel.add(scrollPane);
        
        table = new JTable(model);
        UserView userView = new UserView();
        List list = userView.selectView();
        for(int i = 0 ; i<list.size();i++){
            Laborage laborage = (Laborage)list.get(i);
            model.addRow(new Object[]{laborage.getId(),laborage.getName(),laborage.getDept(),laborage.getLaborage()});
        }
        scrollPane.setViewportView(table);
    }
}
