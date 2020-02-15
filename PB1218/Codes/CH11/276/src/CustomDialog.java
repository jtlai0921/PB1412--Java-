import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CustomDialog extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomDialog frame = new CustomDialog();
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
    public CustomDialog() {
        setTitle("定製信息對話框");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 364, 179);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton button = new JButton("進入系統");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        button.setBounds(222, 98, 90, 30);
        contentPane.add(button);
        
        JLabel label = new JLabel(
                "節日慶典管理系統");
        label.setFont(new Font("SansSerif", Font.PLAIN, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(6, 6, 324, 34);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel(
                "正確回答問題，就可以進入本系統。");
        label_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label_1.setBounds(16, 52, 261, 34);
        contentPane.add(label_1);
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        // 交談視窗操作項的名稱
        String[] options = new String[] { "7月1日", "8月1日", "5月1日", "10月1日" };
        String message = "我國的建軍節是每年的幾月幾日？";// 交談視窗中的資訊
        int num = JOptionPane.showOptionDialog(this, message, "基礎考試",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, "8月1日");// 顯示自定義交談視窗
        if (options[num].equals("8月1日")) {
            JOptionPane.showMessageDialog(this, "恭喜您回答正確。");// 回答正確的提示
        } else {
            JOptionPane.showMessageDialog(this, "回答錯誤，再見。");// 回答錯誤的提示
        }
    }
}
