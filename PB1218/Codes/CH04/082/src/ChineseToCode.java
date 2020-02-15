import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class ChineseToCode extends JFrame {
    
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
                    ChineseToCode frame = new ChineseToCode();
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
    public ChineseToCode() {
        setTitle("中文字與區位碼的轉換");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 321, 128);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("輸入一個中文字：");
        label.setBounds(21, 10, 103, 15);
        contentPane.add(label);
        
        JButton button = new JButton("轉換為區位碼");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(21, 48, 103, 23);
        contentPane.add(button);
        
        textField = new JTextField();
        textField.setBounds(134, 2, 161, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        resultField = new JTextField();
        resultField.setBounds(134, 45, 161, 30);
        contentPane.add(resultField);
        resultField.setColumns(10);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();// 獲得使用者輸入
        if (text.length() > 2) {// 禁止輸入多個中文字
            JOptionPane.showMessageDialog(null, "不要輸入過多中文字");
            return;
        }
        byte[] codeBit = text.getBytes();// 獲得中文字的字節陣列
        if (codeBit.length < 2) {// 禁止非中文字的區碼獲得
            JOptionPane.showMessageDialog(null, "您輸入的好像不是中文字");
            return;
        }
        codeBit[0] -= 160;// 分析字節對應的區碼
        codeBit[1] -= 160;
        // 組合最終區碼編號
        String code = formatNumber(codeBit[0]) + formatNumber(codeBit[1]);
        resultField.setText(code);// 在文字框顯示中文字的區碼
    }
    
    /**
     * 保留數字位數的字串格式
     * 
     * @param num
     * @return
     */
    private String formatNumber(int num) {
        String format = String.format("%02d", num);// 數字的補零格式
        return format;// 傳回格式化後的字串
    }
}
