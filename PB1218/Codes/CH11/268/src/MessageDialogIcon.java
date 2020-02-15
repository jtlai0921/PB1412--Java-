import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;

public class MessageDialogIcon extends JFrame {
    
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
                    MessageDialogIcon frame = new MessageDialogIcon();
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
    public MessageDialogIcon() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 338, 171);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("個人銀行提款機");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 24));
        label.setBounds(6, 6, 310, 37);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel("提款金額：");
        label_1.setBounds(6, 55, 71, 18);
        contentPane.add(label_1);
        
        textField = new JTextField();
        textField.setBounds(67, 49, 236, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("提款");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        button.setBounds(124, 91, 90, 30);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        String text = textField.getText();// 獲得文字框輸入
        URL resource = getClass().getResource("money.png");// 獲得資源檔案路徑
        ImageIcon icon = new ImageIcon(resource);// 建立圖標對像
        // 顯示帶有自定義圖標的資訊提示交談視窗
        JOptionPane.showMessageDialog(this, "你在我這存「" + text + "」這些錢了嗎", "取錢啊？",
                JOptionPane.QUESTION_MESSAGE, icon);
    }
}
