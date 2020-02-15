import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;

public class ShowBevelBorder extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowBevelBorder frame = new ShowBevelBorder();
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
    public ShowBevelBorder() {
        setTitle("實現標籤控制項的立體邊框");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 132);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("凹陷的立體邊框");
        label.setBounds(150, 18, 100, 22);// 設定標籤位置與大小
        contentPane.add(label);// 增加標籤到窗體面板
        label.setHorizontalAlignment(SwingConstants.CENTER);// 文字居中顯示
        label.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
                null));// 設定標籤的邊框
        
        JLabel label_1 = new JLabel("突起的立體邊框");
        label_1.setBounds(150, 52, 100, 22);// 設定標籤位置與大小
        contentPane.add(label_1);// 增加標籤到窗體面板
        label_1.setHorizontalAlignment(SwingConstants.CENTER);// 文字居中顯示
        label_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
                null));// 設定標籤的邊框
        
        JLabel label_2 = new JLabel("它們可不是按鈕，都是標籤");
        label_2.setBounds(262, 20, 166, 54);// 設定標籤位置與大小
        contentPane.add(label_2);// 增加標籤到窗體面板
        
        JLabel label_3 = new JLabel("指定邊框顏色");
        label_3.setHorizontalAlignment(SwingConstants.CENTER);// 文字居中顯示
        label_3.setBounds(6, 17, 124, 55);// 設定標籤位置與大小
        contentPane.add(label_3);// 增加標籤到窗體面板
        Color highlightOuter = new Color(255, 255, 0);// 邊框的反白顏色參數
        Color highlightInner = new Color(255, 175, 175);
        label_3.setBorder(new BevelBorder(BevelBorder.LOWERED, highlightOuter,
                highlightInner, Color.BLUE, Color.RED));// 設定標籤的邊框
    }
}
