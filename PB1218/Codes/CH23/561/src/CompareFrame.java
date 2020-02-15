import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CompareFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField nameTextField1;
    private JTextField nameTextField2;
    private JTable table;
    private LocalTableModel model = new LocalTableModel();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CompareFrame frame = new CompareFrame();
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
    public CompareFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 504, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 488, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("查詢語文成績大於");
        messageLabel.setBounds(25, 34, 113, 15);
        panel.add(messageLabel);
        
        nameTextField1 = new JTextField();
        nameTextField1.setBounds(141, 31, 66, 21);
        panel.add(nameTextField1);
        nameTextField1.setColumns(10);
        
        JLabel label = new JLabel("小於");
        label.setBounds(217, 34, 30, 15);
        panel.add(label);
        
        nameTextField2 = new JTextField();
        nameTextField2.setBounds(245, 31, 66, 21);
        panel.add(nameTextField2);
        nameTextField2.setColumns(10);
        
        JLabel label_1 = new JLabel("的語文成績");
        label_1.setBounds(321, 34, 79, 15);
        panel.add(label_1);
        
        JButton findButton = new JButton("查詢");
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_findButton_actionPerformed(arg0);
            }
        });
        findButton.setBounds(405, 30, 73, 23);
        panel.add(findButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 78, 418, 163);
        panel.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
    }
    
    protected void do_findButton_actionPerformed(ActionEvent arg0) {
        String name1 = nameTextField1.getText();
        String name2 = nameTextField2.getText();
        CreateCompare compare = new CreateCompare();
        if (!name1.equals("") && !(name2.equals(""))) {
            List list = compare.getCompare(name1, name2);
            for (int i = 0; i < list.size(); i++) {
                Grade grade = (Grade) list.get(i);
                model
                        .addRow(new Object[] { grade.getName(),
                                grade.getChinese() });
            }
        }
    }
}
