import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.UIManager;

public class LoginFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton button;
    
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
                    LoginFrame frame = new LoginFrame();
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
    public LoginFrame() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 329, 185);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("天雨系統登入界面"); // 建立標籤控制項
        label.setHorizontalAlignment(SwingConstants.CENTER);// 標籤文字居中對其
        label.setFont(new Font("SansSerif", Font.PLAIN, 24));// 設定標籤控制項字體
        label.setBounds(6, 6, 309, 51);
        contentPane.add(label);
        JLabel label_1 = new JLabel("使用者名稱："); // 建立標籤控制項
        label_1.setBounds(16, 69, 55, 18);
        contentPane.add(label_1);
        JLabel label_2 = new JLabel("密　碼："); // 建立標籤控制項
        label_2.setBounds(16, 103, 55, 18);
        contentPane.add(label_2);
        textField = new JTextField();// 建立文字框
        textField.setBounds(65, 63, 242, 30);
        contentPane.add(textField);
        textField.setColumns(10);// 設定文字框列數
        passwordField = new JPasswordField();// 建立密碼框
        passwordField.setBounds(65, 99, 143, 30);
        contentPane.add(passwordField);
        button = new JButton("登　錄");// 建立登入按鈕但沒有定位
        contentPane.add(button);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {// 建立啟動事件處理方法
        new Thread() {// 建立匿名線程
            @Override
            public void run() {
                for (int i = 0; i < 217; i++) {// 循環控制按鈕的移動
                    button.setBounds(i, i > 99 ? 99 : i, 90, 30);// 移動按鈕
                    getRootPane().setComponentZOrder(button, 0);// 把按鈕置頂顯示
                    try {
                        sleep(1);// 線程休眠
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();// 啟動線程
    }
}
