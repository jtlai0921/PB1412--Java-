import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class CheckBoxArray extends JFrame {
    
    private JPanel contentPane;
    private JPanel panel;
    
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
                    CheckBoxArray frame = new CheckBoxArray();
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
    public CheckBoxArray() {
        setTitle("核取方塊控制項陣列");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 409, 331);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JLabel label = new JLabel(
                "\u4F60\u7684\u7231\u597D\u6709\u54EA\u4E9B\uFF1A");
        contentPane.add(label, BorderLayout.NORTH);
        contentPane.add(getPanel(), BorderLayout.CENTER);
    }
    
    private JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();// 建立面板對像
            panel.setLayout(new GridLayout(0, 4));// 設定網格佈局管理器
            // 建立控制項文字陣列
            String[] labels = { "足球", "籃球", "魔術", "乒乓球", "看電影", "魔獸世界", "CS戰隊",
                    "羽毛球", "游泳", "旅遊", "爬山", "唱歌", "寫部落格", "動物世界", "拍照", "彈吉他",
                    "讀報紙", "飆車", "逛街", "逛商場", "麻將", "看書", "上網看資料", "新聞", "軍事",
                    "八卦", "養生", "飲茶" };
            JCheckBox[] boxs = new JCheckBox[labels.length];// 建立控制項陣列
            for (int i = 0; i < boxs.length; i++) {// 檢查控制項陣列
                boxs[i] = new JCheckBox(labels[i]);// 初始化陣列中的復選框元件
                panel.add(boxs[i]);// 把陣列元素（即每個復選框）增加到面板中
            }
        }
        return panel;
    }
}
