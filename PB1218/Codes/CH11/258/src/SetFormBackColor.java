import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class SetFormBackColor extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SetFormBackColor frame = new SetFormBackColor();
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
    public SetFormBackColor() {
        setTitle("設定窗體背景顏色為淡藍色");// 設定窗體標題欄
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 308, 238);// 設定窗體位置
        contentPane = new JPanel();// 建立內容面板
        // 設定內容面板的背景色
        contentPane.setBackground(new Color(102, 204, 255));
        setContentPane(contentPane);// 設定窗體內容面板
    }
    
}
