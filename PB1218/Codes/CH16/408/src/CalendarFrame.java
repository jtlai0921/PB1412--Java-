import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.lzw.widget.CalendarPanel;
import javax.swing.JLabel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.Calendar;
import javax.swing.UIManager;
import java.awt.Color;

public class CalendarFrame extends JFrame {
    
    private JPanel contentPane;
    private JLabel label;
    private String InfoStr;
    private CalendarPanel calendarPanel;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalendarFrame frame = new CalendarFrame();
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
    public CalendarFrame() {
        setTitle("日曆控制項");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 367, 222);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 204, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);// 使用絕對定位佈局
        calendarPanel = new CalendarPanel();// 建立日曆控制項
        calendarPanel.addDateChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                do_calendarPanel_propertyChange(evt);// 呼叫事件處理方法
            }
        });
        calendarPanel.setBounds(6, 6, 162, 170);
        contentPane.add(calendarPanel);
        // 建立字串模板
        InfoStr = "<html>您選擇的日期是：<br><font size=6 color=red>%1s</font></html>";
        // 設定標籤控制項顯示日期
        label = new JLabel(String.format(InfoStr, calendarPanel.getDate()));
        label.setBounds(180, 6, 162, 170);
        contentPane.add(label);
    }
    
    protected void do_calendarPanel_propertyChange(PropertyChangeEvent evt) {
        // 透過事件跟新標籤控制項的日期
        label.setText(String.format(InfoStr, calendarPanel.getDate()));
    }
}
