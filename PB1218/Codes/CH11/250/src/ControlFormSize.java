import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ControlFormSize extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ControlFormSize frame = new ControlFormSize();
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
    public ControlFormSize() {
        setTitle("設定窗體大小");// 設定窗體標題
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 預設關閉方式
        setSize(400, 300);// 設定窗體大小
        contentPane = new JPanel();// 建立內容面板
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);// 設定內容面板
        JLabel label = new JLabel("寬度：400，高度：300");// 建立標籤控制項
        contentPane.add(label, BorderLayout.CENTER);// 增加標籤控制項到窗體
    }
    
}
