import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AutoImageSizeByForm extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AutoImageSizeByForm frame = new AutoImageSizeByForm();
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
    public AutoImageSizeByForm() {
        setTitle("使背景圖片自動適應窗體的大小");// 設定窗體標題
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);// 設定窗體位置
        contentPane = new JPanel();// 建立內容面板
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        // 建立自定義背景面板
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setImage(getToolkit().getImage(
                getClass().getResource("Penguins.jpg")));// 設定背景面板的圖片
        contentPane.add(backgroundPanel, BorderLayout.CENTER);// 增加背景面板到內容面板
    }
    
}
