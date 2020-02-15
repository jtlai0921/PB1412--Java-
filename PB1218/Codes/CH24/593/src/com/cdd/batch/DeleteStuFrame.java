package com.cdd.batch;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteStuFrame extends JFrame {
    
    private JPanel contentPane;
    private LocalTableModel model = new LocalTableModel();
    private BatchDelete batchDelete = new BatchDelete();
    private JTable table;
   
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteStuFrame frame = new DeleteStuFrame();
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
    public DeleteStuFrame() {
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
        
        JLabel messageLabel = new JLabel("批次刪除學生表資料");
        messageLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
        messageLabel.setBounds(135, 26, 149, 15);
        panel.add(messageLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(36, 71, 352, 111);
        panel.add(scrollPane);
        
        table = new JTable(model);
        scrollPane.setViewportView(table);
        
        JButton deleteButton = new JButton("刪除");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_deleteButton_actionPerformed(arg0);
            }
        });
        deleteButton.setBounds(97, 214, 80, 23);
        panel.add(deleteButton);
        
        JButton closeButton = new JButton("關閉");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(232, 214, 80, 23);
        panel.add(closeButton);
        
       
        List list = batchDelete.executeStu();
        for(int i = 0;i<list.size();i++){
            Stu stu = (Stu)list.get(i);
            model.addRow(new Object[]{stu.getId(),stu.getName(),stu.getSex(),stu.getSpecialty()});
        }               
    }
    //刪除按鈕的單擊處理事件
protected void do_deleteButton_actionPerformed(ActionEvent arg0) {
    int [] ids = table.getSelectedRows();           //傳回選定行的索引
    Integer values[] = new Integer[ids.length];     
    for(int i = 0;i<ids.length;i++){    //檢查選定行的陣列
        values[i] = new Integer(table.getValueAt(ids[i], 0).toString());    //獲得使用者選擇某單元格的內容            
    }
    batchDelete.deleteBatch(values);        //呼叫批處理方法
    JOptionPane.showMessageDialog(getContentPane(), 
            "資料刪除成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
}
    //關閉按鈕的單擊處理事件
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
