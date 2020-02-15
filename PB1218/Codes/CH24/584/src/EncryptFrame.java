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


public class EncryptFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EncryptFrame frame = new EncryptFrame();
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
    public EncryptFrame() {
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
        
        JLabel messageLabel = new JLabel("呼叫加密儲存過程");
        messageLabel.setFont(new Font("華文新魏", Font.PLAIN, 16));
        messageLabel.setBounds(136, 29, 147, 29);
        panel.add(messageLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 76, 367, 164);
        panel.add(scrollPane);
        LocalTableModel model = new LocalTableModel();
        table = new JTable(model);
        UserUtil util = new UserUtil();
        List list = util.executeUpdate();
        for(int i = 0;i<list.size();i++){
            User user = (User)list.get(i);
            model.addRow(new Object[]{user.getId(),user.getUserName(),user.getPassword(),user.getSex(),user.getAge(),user.getJob()});
        }
        scrollPane.setViewportView(table);
    }
}
