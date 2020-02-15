import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZoomFrameContent extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ZoomFrameContent frame = new ZoomFrameContent();
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
    public ZoomFrameContent() {
        setTitle("窗體抖動");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton button = new JButton("窗體抖動");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(168, 107, 90, 30);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        int num = 15;// 抖動次數
        Point point = getLocation();// 窗體位置
        for (int i = 30; i > 0; i--) {// 抖動大小
            for (int j = num; j > 0; j--) {
                point.y += i;
                setLocation(point);// 窗體向下移動
                point.x += i;
                setLocation(point);// 窗體向右移動
                point.y -= i;
                setLocation(point);// 窗體向上移動
                point.x -= i;
                setLocation(point);// 窗體向左移動
            }
        }
    }
}
