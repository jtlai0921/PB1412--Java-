import static javax.swing.JOptionPane.showMessageDialog;

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
import javax.swing.UIManager;

public class CheckPhoneNum extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckPhoneNum frame = new CheckPhoneNum();
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
    public CheckPhoneNum() {
        setTitle("判斷手機號的合法性");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 191);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel(
                "<html>手機投票抽獎活動，請將您的手機號碼輸入到系統中，我們會根據隨機抽取的手機號碼來確定中將人員。</html>");
        label.setBounds(12, 14, 410, 48);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel(
                "輸入手機號碼：");
        label_1.setBounds(12, 76, 100, 15);
        contentPane.add(label_1);
        
        textField = new JTextField();
        textField.setBounds(124, 76, 298, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(165, 111, 93, 23);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();// 獲得使用者輸入號碼
        String regex = "^13\\d{9}|15\\d{9}|18\\d{9}$";// 定義正則表達式
        if (text.matches(regex)) {// 測試比對結果
            showMessageDialog(null, text + " 是合法的手機號");// 提示合法手機號碼
        } else {
            showMessageDialog(null, text + " 不是合法的手機號");// 提示非法手機號碼
        }
    }
}
