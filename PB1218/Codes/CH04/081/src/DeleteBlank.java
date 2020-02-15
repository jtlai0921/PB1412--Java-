import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class DeleteBlank extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextField resultField;
    
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
                    DeleteBlank frame = new DeleteBlank();
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
    public DeleteBlank() {
        setTitle("去掉字串中的所有空格");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 386, 128);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("輸入字串：");
        label.setBounds(21, 10, 75, 15);
        contentPane.add(label);
        
        JButton button = new JButton("去空格");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(10, 49, 82, 23);
        contentPane.add(button);
        
        textField = new JTextField();
        textField.setBounds(102, 2, 258, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        resultField = new JTextField();
        resultField.setBounds(102, 45, 258, 30);
        contentPane.add(resultField);
        resultField.setColumns(10);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();// 獲得使用者輸入文字
        StringBuilder strBuilder = new StringBuilder();// 建立字串建構器
        for (int i = 0; i < text.length(); i++) {// 檢查字串
            char charAt = text.charAt(i);// 獲得每個字符
            if (charAt == ' ')// 過濾空格字符
                continue;
            strBuilder.append(charAt);// 追加非空格字符到字符建構器
        }
        resultField.setText(strBuilder.toString());// 把建構器中的字串顯示到文字框
    }
}
