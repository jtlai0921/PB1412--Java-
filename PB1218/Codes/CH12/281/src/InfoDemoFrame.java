import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoDemoFrame extends JFrame {
    
    private JPanel contentPane;
    private InfoWindow window = new InfoWindow();
    private Timer timer;
    private Point location;
    private Dimension screenSize;
    private Dimension windowSize;;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InfoDemoFrame frame = new InfoDemoFrame();
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
    public InfoDemoFrame() {
        setTitle("右下角出現資訊窗體");// 設定窗體標題
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 337, 190);// 窗體大小
        contentPane = new JPanel();// 建立內容面板
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);// 取消佈局管理器
        JButton button = new JButton("獲得即時資訊");// 建立按鈕
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);// 呼叫按鈕事件處理方法
            }
        });
        button.setBounds(97, 59, 122, 30);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        // 建立Timer控制項
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                location.y -= 1;// 提升資訊窗體垂直座標
                // 在資訊窗體顯示而且沒有達到上升位置之前持續移動窗體
                if (window.isShowing()
                        && location.y > screenSize.height - windowSize.height)
                    window.setLocation(location);
                else {// 窗體未顯示或超出移動範圍是停止
                    Timer source = (Timer) e.getSource();
                    source.stop();
                }
            }
        });
        screenSize = getToolkit().getScreenSize();// 獲得屏幕大小
        window.setVisible(true);// 顯示資訊窗體
        window.setAlwaysOnTop(true);// 把資訊窗體置頂
        windowSize = window.getSize();// 獲得資訊窗體大小
        location = new Point();// 建立位置對像
        location.x = screenSize.width - windowSize.width;// 初始化窗體位置
        location.y = screenSize.height;
        timer.start();// 啟動Timer控制項
    }
}
