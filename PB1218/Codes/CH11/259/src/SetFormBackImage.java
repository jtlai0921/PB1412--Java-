import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SetFormBackImage extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SetFormBackImage frame = new SetFormBackImage();
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
    public SetFormBackImage() {
        setTitle("實現帶背景定圖片的窗體");// 設定窗體標題
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);// 設定窗體位置
        contentPane = new JPanel();// 建立內容面板
        setContentPane(contentPane);// 設定窗體內容面板
        contentPane.setLayout(new BorderLayout(0, 0));
        BackgroundPanel backgroundPanel = new BackgroundPanel();// 建立背景面板
        backgroundPanel.setImage(getToolkit().getImage(
                getClass().getResource("Penguins.jpg")));// 設定面板背景圖片
        contentPane.add(backgroundPanel);// 把背景面板增加到窗體內容面板
    }
}
