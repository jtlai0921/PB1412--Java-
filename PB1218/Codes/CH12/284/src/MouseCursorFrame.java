import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MouseCursorFrame extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MouseCursorFrame frame = new MouseCursorFrame();
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
    public MouseCursorFrame() {
        setTitle("設定窗體的鼠標光標");// 設定窗體標題
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 318, 205);// 設定窗體位置
        contentPane = new JPanel();// 建立內容面板
        Toolkit toolkit = getToolkit();// 獲得窗體工具包
        // 建立鼠標光標圖片對像
        Image image = toolkit.getImage(getClass().getResource("1.png"));
        // 透過圖片建立光標對像
        Cursor cursor = toolkit.createCustomCursor(image, new Point(0, 0),
                "lzw");
        contentPane.setCursor(cursor);// 設定內容面板的鼠標光標
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 邊框
        contentPane.setLayout(new BorderLayout(0, 0));// 佈局
        setContentPane(contentPane);
    }
    
}
