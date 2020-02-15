package com.cdd.deleteProcedure;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteProcddureFrame extends JFrame {
    
    private JPanel contentPane;
    
    private LocalTableModel model = new LocalTableModel();
    private JTable table;
    Map map = new HashMap();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteProcddureFrame frame = new DeleteProcddureFrame();
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
    public DeleteProcddureFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 316);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("刪除儲存過程");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 278);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("刪除資料函數庫中的儲存過程：");
        messageLabel.setFont(new Font("華文中宋", Font.PLAIN, 13));
        messageLabel.setBounds(138, 29, 167, 15);
        panel.add(messageLabel);
        
        JButton deleteButton = new JButton("刪除");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_deleteButton_actionPerformed(arg0);
            }
        });
        deleteButton.setBounds(117, 245, 63, 23);
        panel.add(deleteButton);
        
        JButton closeButton = new JButton("關閉");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(238, 245, 63, 23);
        panel.add(closeButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(59, 75, 310, 146);
        panel.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
        
        DeleteProcedure deleteProcedure = new DeleteProcedure();
        List list = deleteProcedure.executeGain();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).toString();
            map.put(i, name);
            model.addRow(new Object[] { i + 1, name });
        }
    }
    
    // 刪除按鈕的單擊事件
    protected void do_deleteButton_actionPerformed(ActionEvent arg0) {
        int [] ids = table.getSelectedRows();
        DeleteProcedure deleteProcedure = new DeleteProcedure();
        String[] sql = new String[ids.length];
        for(int i = 0 ;i<ids.length;i++ ){
            sql[i] = map.get(ids[i]).toString();
        }
        deleteProcedure.executeUpdate(sql);
        JOptionPane.showMessageDialog(getContentPane(), 
                "儲存過程刪除成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
        repaint();

    }
    
    // 關閉按鈕的單擊事件
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
