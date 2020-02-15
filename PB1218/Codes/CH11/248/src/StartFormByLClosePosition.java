import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.prefs.Preferences;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StartFormByLClosePosition extends JFrame {
    
    private JPanel contentPane;
    private JLabel label;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StartFormByLClosePosition frame = new StartFormByLClosePosition();
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
    public StartFormByLClosePosition() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                do_this_componentMoved(e);
            }
        });
        setTitle("從上次關閉位置啟動窗體");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);
            }
            
            @Override
            public void windowClosing(WindowEvent e) {
                do_this_windowClosing(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 346, 237);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        Preferences root = Preferences.userRoot();// 獲得使用者首選項
        int x = root.getInt("locationX", 100);// 分析窗體X座標
        int y = root.getInt("locationY", 100);// 分析窗體Y座標
        setLocation(x, y);// 恢復窗體座標
    }
    
    protected void do_this_windowClosing(WindowEvent e) {
        Preferences root = Preferences.userRoot();// 獲得使用者首選項
        Point location = getLocation();// 獲得窗體位置
        root.putInt("locationX", location.x);// 儲存窗體X座標
        root.putInt("locationY", location.y);// 儲存窗體Y座標
    }
    
    protected void do_this_componentMoved(ComponentEvent e) {
        Point location = getLocation();// 獲得窗體座標
        int x = location.x;
        int y = location.y;
        // 把窗體目前座標顯示在標籤控制項中
        label.setText("窗體目前座標：X = " + x + "        Y = " + y);
    }
}
