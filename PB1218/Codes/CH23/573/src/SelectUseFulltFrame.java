

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

public class SelectUseFulltFrame extends JFrame {
    
    private JPanel contentPane;

    private LocalTableModel model = new LocalTableModel();
    private JTable table_1;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SelectUseFulltFrame frame = new SelectUseFulltFrame();
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
    public SelectUseFulltFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 622, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("完全連接查詢資料");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 606, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("完全連接查詢員工資訊");
        messageLabel.setFont(new Font("華文中宋", Font.PLAIN, 15));
        messageLabel.setBounds(215, 26, 165, 27);
        panel.add(messageLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(43, 78, 512, 161);
        panel.add(scrollPane);       
        
        table_1 = new JTable(model);
        SelectUseFull useLeft = new SelectUseFull();
        List list = useLeft.getFull();
        for(int i = 0;i<list.size();i++){
            MrEmp mrEmp = (MrEmp)list.get(i);
            model.addRow(new Object[] { mrEmp.getId(), mrEmp.getdName(),
                    mrEmp.getPerson(),mrEmp.getName(),mrEmp.getSex(),mrEmp.getSchoolAge()});
        }
        scrollPane.setViewportView(table_1);           
    }
}
