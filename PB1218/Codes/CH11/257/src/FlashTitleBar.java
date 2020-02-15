import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FlashTitleBar extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FlashTitleBar frame = new FlashTitleBar();
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
    public FlashTitleBar() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);
            }
        });
        setTitle("設置閃爍的標題欄");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 273, 130);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JLabel label = new JLabel(
                "系統內存緊缺，請立刻保存數據。");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        Timer timer = new Timer(500, new ActionListener() {// 建立timer控制項
                    String title = getTitle();// 獲得窗體標題
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {// 實現窗體閃爍
                        if (getTitle().isEmpty()) {// 如果標題為空
                            setTitle(title);// 恢復窗體標題
                        } else {
                            setTitle("");// 如果窗體標題不為空，則清空窗體標題
                        }
                    }
                });
        timer.start();// 啟動Timer控制項
    }
}
