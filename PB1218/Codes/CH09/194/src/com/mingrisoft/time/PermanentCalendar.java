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
        setTitle("����U�~��");
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
        
        JButton lastMonthButton = new JButton("�W�Ӥ�");
        lastMonthButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
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
        currentMonthLabel.setFont(new Font("�L�n����", Font.PLAIN, 20));
        currentMonthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        currentMonthPanel.add(currentMonthLabel);
        
        JPanel nextMonthPanel = new JPanel();
        YMPanel.add(nextMonthPanel);
        
        JButton nextMonthButton = new JButton("�U�Ӥ�");
        nextMonthButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        nextMonthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_nextMonthButton_actionPerformed(e);
            }
        });
        nextMonthPanel.add(nextMonthButton);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("�L�n����", Font.PLAIN, 18));
        table.getTableHeader().setFont(new Font("�L�n����", Font.PLAIN, 20));
        table.setRowHeight(25);
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(table);
        
        currentMonthLabel.setText(updateLabel(0));
        updateTable(calendar);
    }
    
    private void updateTable(Calendar calendar) {
        String[] weeks = new DateFormatSymbols().getShortWeekdays();// ��o��ܬP�����r��}�C
        String[] realWeeks = new String[7];// �s�W�@�Ӱ}�C���x�s�I���᪺�r��
        for (int i = 1; i < weeks.length; i++) {// weeks�}�C�Ĥ@�Ӥ����O�Ŧr��A�]���q1�}�l�`��
            realWeeks[i - 1] = weeks[i].substring(2, 3);// ��o�r�ꪺ�̫�@�Ӧr��
        }
        int today = calendar.get(Calendar.DATE);// ��o�ثe���
        int monthDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);// ��o�ثe�몺�Ѽ�
        calendar.set(Calendar.DAY_OF_MONTH, 1); // �N�ɶ��]�w������Ĥ@��
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);// ��o����Ĥ@�ѬO�P���X
        int firstDay = calendar.getFirstDayOfWeek(); // ��o�ثe�a�ϬP�����_�l��
        int whiteDay = weekday - firstDay; // �o�Ӥ�Ĥ@�ӬP�����X�ѳQ�W�Ӥ����
        Object[][] days = new Object[6][7];// �s�W�@�ӤG���}�C���x�s�ثe�몺�U��
        for (int i = 1; i <= monthDays; i++) {// �ˬd�ثe�몺�Ҧ��ѨñN��W�[���G���}�C��
            days[(i - 1 + whiteDay) / 7][(i - 1 + whiteDay) % 7] = i;
        }// �}�C���Ĥ@����ܤ@�Ӥ뤤�U�ӬP���A�ĤG���ܤ@�ӬP�����U�Ӥ�
        DefaultTableModel model = (DefaultTableModel) table.getModel();// ��o�ثe��檺�ҫ�
        model.setDataVector(days, realWeeks);// �����ҫ��]�w���Y�M����
        table.setModel(model);// ��s���ҫ�
        table.setRowSelectionInterval(0, (today - 1 + whiteDay) / 7);// �]�w��ܪ���
        table.setColumnSelectionInterval(0, (today - 1 + whiteDay) % 7);// �]�w��ܪ��C
    }
    
    private String updateLabel(int increment) {
        calendar.add(Calendar.MONTH, increment);// �N�ثe����W�[increment��
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy�~MM��");// �]�w�r��榡
        return formatter.format(calendar.getTime());// ��o���w�榡���r��
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