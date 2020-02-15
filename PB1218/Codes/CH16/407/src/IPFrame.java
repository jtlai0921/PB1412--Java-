import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.lzw.ip.IpField;
import javax.swing.UIManager;

public class IPFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    
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
                    IPFrame frame = new IPFrame();
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
    public IPFrame() {
        setTitle("IP輸入文字框控制項");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 355, 222);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel label = new JLabel("設定服務器名稱與IP地址");// 建立標題標籤
        label.setHorizontalAlignment(SwingConstants.CENTER);// 居中對齊
        label.setFont(new Font("SansSerif", Font.PLAIN, 18));// 設定字體
        label.setBounds(6, 6, 298, 39);
        contentPane.add(label);
        JLabel label_1 = new JLabel("服務器名稱：");// 建立標籤
        label_1.setBounds(6, 57, 83, 18);// 設定標籤大小
        contentPane.add(label_1);
        JLabel label_2 = new JLabel("服務器ｉｐ：");// 建立標籤
        label_2.setBounds(6, 95, 83, 18);// 設定標籤大小
        contentPane.add(label_2);
        textField = new JTextField();// 建立輸入服務器名稱的文字框
        textField.setBounds(82, 51, 251, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        JButton button = new JButton("確定");// 建立確定按鈕
        button.setBounds(54, 132, 90, 30);
        contentPane.add(button);
        JButton button_1 = new JButton("關閉");// 建立關閉按鈕
        button_1.setBounds(177, 132, 90, 30);
        contentPane.add(button_1);
        IpField ipField = new IpField();// 建立IP文字框控制項
        ipField.setBounds(82, 88, 251, 25);// 設定控制項大小
        contentPane.add(ipField);
    }
}
