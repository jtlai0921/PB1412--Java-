import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class IconTitledBorder extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IconTitledBorder frame = new IconTitledBorder();
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
    public IconTitledBorder() {
        setTitle("帶圖標邊框的標題邊框");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 398, 271);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 239, 213));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));// 建立圖標對像
        JPanel panel_12 = new JPanel();// 建立面板對像
        panel_12.setOpaque(false);// 面板透明
        MatteBorder matteBorder = new MatteBorder(16, 16, 16, 16, icon);// 建立MatteBorder邊框
        Font font = new Font("隸書", Font.ITALIC | Font.BOLD, 24);// 建立字體
        // 建立TitledBorder邊框並把MatteBorder邊框作為建構方法的參數進行嵌套
        TitledBorder titledBorder = new TitledBorder(matteBorder, "圖標邊框的標題",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, font, Color.BLACK);
        panel_12.setBorder(titledBorder);// 設定面板容器使用TitledBorder邊框
        contentPane.add(panel_12);
    }
}
