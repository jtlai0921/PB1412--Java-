import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckUsername extends JFrame {
    
    private JPanel contentPane;
    private JTextField usernameField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckUsername frame = new CheckUsername();
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
    public CheckUsername() {
        setTitle("找密碼");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 312, 181);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("找密碼");
        label.setBounds(22, 54, 58, 17);
        contentPane.add(label);
        
        usernameField = new JTextField();
        usernameField.setBounds(77, 51, 180, 23);
        contentPane.add(usernameField);
        usernameField.setColumns(10);
        
        JButton button = new JButton("送出");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(67, 88, 71, 25);
        contentPane.add(button);
        
        JButton button_1 = new JButton("關閉");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(165, 88, 71, 25);
        contentPane.add(button_1);
        
        JLabel label_1 = new JLabel(
                "<html>找密碼</font>用戶名</html>");
        label_1.setBounds(12, 14, 343, 25);
        contentPane.add(label_1);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String name = usernameField.getText();// 獲得使用者輸入
        if (name.equals("admin")) {// 判斷是否管理員賬號
            JOptionPane.showMessageDialog(null, "對不起，這個使用者名稱是管理員的，不是你的");
        } else if (name.equals("mingri")) {// 判斷是否註冊使用者
            JOptionPane.showMessageDialog(null, "該使用者名稱對應的密碼已經發送到註冊時的電子郵件，請查收");
        } else {// 給錯誤使用者名稱的提示交談視窗
            JOptionPane.showMessageDialog(null, "你輸入的使用者名稱不存在，留意Caps Lock鍵是否按下。");
        }
    }
    protected void do_button_1_actionPerformed(ActionEvent e) {
        dispose();
    }
}
