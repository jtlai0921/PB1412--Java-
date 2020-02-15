package com.cdd.util;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class SelectTrendsFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField valueTextField;
    private JTable table;
    private LocalTableModel model = new LocalTableModel();
    private JComboBox subjectComboBox;
    private JComboBox connectionComboBox;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SelectTrendsFrame frame = new SelectTrendsFrame();
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
    public SelectTrendsFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 501, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 485, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        setTitle("動態指定查詢條件");
        JLabel subjectLabel = new JLabel("學科：");
        subjectLabel.setBounds(33, 32, 54, 15);
        panel.add(subjectLabel);
        String[] subject = { "數學", "語文", "英語" };
        subjectComboBox = new JComboBox(subject);
        subjectComboBox.setBounds(73, 29, 69, 21);
        panel.add(subjectComboBox);
        
        JLabel connectionLabel = new JLabel("關係：");
        connectionLabel.setBounds(152, 32, 41, 15);
        panel.add(connectionLabel);
        String[] connection = { "=", "<", ">" };
        connectionComboBox = new JComboBox(connection);
        connectionComboBox.setBounds(192, 29, 54, 21);
        panel.add(connectionComboBox);
        
        JLabel valueLabel = new JLabel("值：");
        valueLabel.setBounds(256, 32, 34, 15);
        panel.add(valueLabel);
        
        valueTextField = new JTextField();
        valueTextField.setBounds(290, 29, 66, 21);
        panel.add(valueTextField);
        valueTextField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(33, 90, 418, 144);
        panel.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
        
        JButton findButton = new JButton("查詢");
        findButton.setBounds(382, 28, 69, 23);
        panel.add(findButton);
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_findButton_actionPerformed(arg0);
            }
        });
    }
    
    protected void do_findButton_actionPerformed(ActionEvent arg0) {
        String subject = subjectComboBox.getSelectedItem().toString();
        String connection = connectionComboBox.getSelectedItem().toString();
        String value = valueTextField.getText();
        String subjectValue = "";
        if (subject.equals("數學")) {
            subjectValue = "math";
        }
        if (subject.equals("英語")) {
            subjectValue = "english";
        }
        if (subject.equals("語文")) {
            subjectValue = "chinese";
        }
        TrendsSelect selectT = new TrendsSelect();
        model.setRowCount(0);
        List list = selectT.getGrade(subjectValue, connection, Integer.parseInt(value));
        for (int i = 0; i < list.size(); i++) {
            Grade grade = (Grade) list.get(i);
            model.addRow(new Object[] { grade.getId(), grade.getName(),
                    grade.getSex(), grade.getEnglish(), grade.getChinese(),
                    grade.getMath() });
        }
    }
}
