package com.mingrisoft.time;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PermanentCalendar extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5939002611918837793L;
    private JPanel contentPane;
    private JTable table;
    private JLabel currentMonthLabel;
    private Calendar calendar = new GregorianCalendar();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PermanentCalendar frame = new PermanentCalendar();
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
    public PermanentCalendar() {
        setTitle("公曆萬年曆");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 282);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel YMPanel = new JPanel();
        contentPane.add(YMPanel, BorderLayout.NORTH);
        YMPanel.setLayout(new GridLayout(1, 3, 5, 10));
        
        JPanel lastMonthPanel = new JPanel();
        YMPanel.add(lastMonthPanel);
        
        JButton lastMonthButton = new JButton("上個月");
        lastMonthButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        lastMonthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_lastMonthButton_actionPerformed(e);
            }
        });
        lastMonthPanel.add(lastMonthButton);
        
        JPanel currentMonthPanel = new JPanel();
        YMPanel.add(currentMonthPanel);
        currentMonthPanel.setLayout(new BoxLayout(currentMonthPanel, BoxLayout.X_AXIS));
        
        currentMonthLabel = new JLabel("");
        currentMonthLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 20));
        currentMonthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        currentMonthPanel.add(currentMonthLabel);
        
        JPanel nextMonthPanel = new JPanel();
        YMPanel.add(nextMonthPanel);
        
        JButton nextMonthButton = new JButton("下個月");
        nextMonthButton.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        nextMonthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_nextMonthButton_actionPerformed(e);
            }
        });
        nextMonthPanel.add(nextMonthButton);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
        table.getTableHeader().setFont(new Font("微軟雅黑", Font.PLAIN, 20));
        table.setRowHeight(25);
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(table);
        
        currentMonthLabel.setText(updateLabel(0));
        updateTable(calendar);
    }
    
    private void updateTable(Calendar calendar) {
        String[] weeks = new DateFormatSymbols().getShortWeekdays();// 獲得表示星期的字串陣列
        String[] realWeeks = new String[7];// 新增一個陣列來儲存截取後的字串
        for (int i = 1; i < weeks.length; i++) {// weeks陣列第一個元素是空字串，因此從1開始循環
            realWeeks[i - 1] = weeks[i].substring(2, 3);// 獲得字串的最後一個字符
        }
        int today = calendar.get(Calendar.DATE);// 獲得目前日期
        int monthDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);// 獲得目前月的天數
        calendar.set(Calendar.DAY_OF_MONTH, 1); // 將時間設定為本月第一天
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);// 獲得本月第一天是星期幾
        int firstDay = calendar.getFirstDayOfWeek(); // 獲得目前地區星期的起始日
        int whiteDay = weekday - firstDay; // 這個月第一個星期有幾天被上個月佔用
        Object[][] days = new Object[6][7];// 新增一個二維陣列來儲存目前月的各天
        for (int i = 1; i <= monthDays; i++) {// 檢查目前月的所有天並將其增加的二維陣列中
            days[(i - 1 + whiteDay) / 7][(i - 1 + whiteDay) % 7] = i;
        }// 陣列的第一維表示一個月中各個星期，第二位表示一個星期中各個天
        DefaultTableModel model = (DefaultTableModel) table.getModel();// 獲得目前表格的模型
        model.setDataVector(days, realWeeks);// 給表格模型設定表頭和表體
        table.setModel(model);// 更新表格模型
        table.setRowSelectionInterval(0, (today - 1 + whiteDay) / 7);// 設定選擇的行
        table.setColumnSelectionInterval(0, (today - 1 + whiteDay) % 7);// 設定選擇的列
    }
    
    private String updateLabel(int increment) {
        calendar.add(Calendar.MONTH, increment);// 將目前月份增加increment月
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月");// 設定字串格式
        return formatter.format(calendar.getTime());// 獲得指定格式的字串
    }
    
    protected void do_lastMonthButton_actionPerformed(ActionEvent e) {
        currentMonthLabel.setText(updateLabel(-1));
        updateTable(calendar);
    }
    
    protected void do_nextMonthButton_actionPerformed(ActionEvent e) {
        currentMonthLabel.setText(updateLabel(1));
        updateTable(calendar);
    }
}
