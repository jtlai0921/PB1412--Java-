import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class CalculagraphFrame extends JFrame {
    
    private JPanel contentPane;
    private long sourTime;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalculagraphFrame frame = new CalculagraphFrame();
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
    public CalculagraphFrame() {
        setTitle("窗體標題顯示計時器");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 138);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JLabel label = new JLabel(
                "<html><p>　　本窗體可以在標題欄顯示計時器，標誌目前窗體已經執行了多少秒鐘</p></html>");
        label.setFont(new Font("SansSerif", Font.PLAIN, 22));
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    protected void do_this_windowOpened(WindowEvent e) {// 窗體開啟事件處理方法
        sourTime = System.currentTimeMillis();// 記錄窗體開啟的初始時間
        // 建立Timer控制項
        Timer timer = new Timer(1000, new ActionListener() {
            String title = getTitle();// 分析原始標題文字
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 技術消耗時間
                long smTime = System.currentTimeMillis() - sourTime;
                // 顯示計時資訊到標題欄
                setTitle(title + "【窗體已經執行了" + (smTime / 1000) + "秒】");
            }
        });
        timer.start();// 啟動Timer控制項
    }
}
