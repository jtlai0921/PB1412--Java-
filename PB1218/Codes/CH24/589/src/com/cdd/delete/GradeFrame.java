package com.cdd.delete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class GradeFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    private LocalTableModel model = new LocalTableModel();
    private DeleteGrade deleteGrade = new DeleteGrade();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GradeFrame frame = new GradeFrame();
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
    public GradeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 337);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 299);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("學產生績表資訊：");
        messageLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 15));
        messageLabel.setBounds(144, 24, 127, 25);
        panel.add(messageLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(41, 86, 356, 152);
        panel.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
        List list = deleteGrade.executeGrade();
        for(int i = 0;i<list.size();i++){
            Grade grade = (Grade)list.get(i);
            model.addRow(new Object[]{grade.getId(),grade.getName(),grade.getEnglist(),grade.getChinese(),grade.getMath()});
        }
        JButton watchButton = new JButton("檢視學生表");
        watchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_deleteButton_actionPerformed(arg0);
            }
        });
        watchButton.setBounds(68, 255, 101, 23);
        panel.add(watchButton);
        
        JButton deleteButton = new JButton("刪除");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        deleteButton.setBounds(189, 255, 82, 23);
        panel.add(deleteButton);
        
        JButton closeButton = new JButton("關閉");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_1_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(295, 255, 85, 23);
        panel.add(closeButton);
    }
    protected void do_deleteButton_actionPerformed(ActionEvent arg0) {
        FindStuFrame findStuFrame = new FindStuFrame();
        findStuFrame.setVisible(true);
    }
    protected void do_button_actionPerformed(ActionEvent arg0) {
        int selectedRow = table.getSelectedRow();
        String id = model.getValueAt(selectedRow, 0).toString();
        deleteGrade.deleteGrade(Integer.parseInt(id));
        JOptionPane.showMessageDialog(getContentPane(), 
                "學生資訊刪除成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
        repaint();
    }
    protected void do_button_1_actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
