import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QQFrame extends JFrame {
    
    private JPanel contentPane;
    private boolean collection;
    private boolean over = false;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QQFrame frame = new QQFrame();
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
    public QQFrame() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                do_this_mouseEntered(e);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                do_this_mouseExited(e);
            }
        });
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                do_this_componentMoved(e);
            }
        });
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 412, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JLabel label = new JLabel("<html><body align=center>我是一個仿QQ隱藏窗體"
                + "<br><font color=green size=6>把我放到窗體頂端，"
                + "我會自動隱藏</font></body></html>");
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    protected void do_this_componentMoved(ComponentEvent e) {// 窗體移動事件處理方法
        if (over)// 如果鼠標在窗體中，就不做窗體隱藏操作
            return;
        Point point = getLocation();// 獲得窗體位置
        if (point.y < 10) {// 如果窗體接近屏幕頂端
            collection = true;// 確定隱藏窗體標誌
            Dimension size = getSize();// 獲得窗體大小
            setLocation(point.x, -size.height + 5);// 隱藏窗體
        } else {
            collection = false;// 如果窗體沒有接近屏幕頂端則取消隱藏標誌
        }
    }
    
    protected void do_this_mouseEntered(MouseEvent e) {// 鼠標進入窗體的事件處理方法
        Point point = getLocation();// 獲得窗體位置
        if (point.y > 0)// 如果窗體沒有被隱藏不做任何操作
            return;
        setLocation(point.x, 8);// 設定窗體顯示
        over = true;// 標誌鼠標在窗體內部
        try {
            Thread.sleep(1000);// 給窗體1秒鐘時間讓鼠標就位
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
    
    protected void do_this_mouseExited(MouseEvent e) {// 鼠標離開事件處理方法
        if (over) {// 如果鼠標標誌在窗體內部
            over = false;// 取消鼠標位置的標誌
            do_this_componentMoved(null);// 隱藏窗體
        }
    }
}
