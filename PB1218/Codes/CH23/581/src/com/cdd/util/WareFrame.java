package com.cdd.util;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class WareFrame extends JFrame {
    
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
                    WareFrame frame = new WareFrame();
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
    public WareFrame() {
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
        
        JLabel messageLabel = new JLabel("查詢各商品所佔銷售額的百分比：");
        messageLabel.setBounds(62, 27, 209, 15);
        panel.add(messageLabel);
        
        JButton findButton = new JButton("查詢");
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_findButton_actionPerformed(arg0);
            }
        });
        findButton.setBounds(281, 23, 74, 23);
        panel.add(findButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(47, 77, 339, 155);
        panel.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
    }
    
    protected void do_findButton_actionPerformed(ActionEvent arg0) {
        model.setRowCount(0);
        WareUtil util = new WareUtil();
        List list = util.getWare();
        for(int i = 0;i<list.size();i++){
            Ware ware = (Ware)list.get(i);
            model.addRow(new Object[]{ware.getId(),ware.getwName(),ware.getPrice(),ware.getPercent()});
        }
    }
}
