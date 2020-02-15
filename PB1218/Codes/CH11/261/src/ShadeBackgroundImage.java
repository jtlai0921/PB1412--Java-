import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ShadeBackgroundImage extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShadeBackgroundImage frame = new ShadeBackgroundImage();
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
    public ShadeBackgroundImage() {
        setTitle("背景為漸層色的主界面");// 設定窗體標題
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();// 建立內容面板
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        ShadePanel shadePanel = new ShadePanel();// 建立漸層背景面板
        contentPane.add(shadePanel, BorderLayout.CENTER);// 增加面板到窗體內容面板
    }
}
