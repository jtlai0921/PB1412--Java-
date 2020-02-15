import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class AlwaysActiveWindows extends JFrame {
    
    private JPanel contentPane;
    
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
                    AlwaysActiveWindows frame = new AlwaysActiveWindows();
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
    public AlwaysActiveWindows() {
        setTitle("始終在桌面最頂層顯示的窗體");// 設定窗體標題
        setAlwaysOnTop(true);// 設定窗體顯示在最頂端。本實例的核心程式碼
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 319, 206);// 設定窗體位置
        contentPane = new JPanel();// 建立內容面板
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);// 設定內容面板
        JLabel label = new JLabel("我就在上面不下去了，咋滴。");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.CENTER);// 增加標籤控制項
    }
    
}
