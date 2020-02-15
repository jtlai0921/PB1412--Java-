import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class RequestType extends JFrame {
    
    private JPanel contentPane;
    private JTextField requestField;
    
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
                    RequestType frame = new RequestType();
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
    public RequestType() {
        setTitle("判斷ftp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 423, 125);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("輸入網址");
        label.setBounds(10, 18, 84, 15);
        contentPane.add(label);
        
        requestField = new JTextField();
        requestField.setBounds(93, 10, 304, 30);
        contentPane.add(requestField);
        requestField.setColumns(10);
        
        JButton button = new JButton("驗證");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(93, 50, 90, 30);
        contentPane.add(button);
        
        JButton button_1 = new JButton("關閉");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(240, 50, 90, 30);
        contentPane.add(button_1);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String request = requestField.getText();// 獲得使用者輸入
        if (request.startsWith("http")) {// 判斷輸入是否以http開頭
            JOptionPane.showMessageDialog(null, "您輸入的是網頁地址，希望瀏覽某個網站。");
        } else if (request.startsWith("ftp")) {// 判斷輸入是否以ftp開頭
            JOptionPane.showMessageDialog(null, "您輸入的是FTP地址，希望存取FTP服務器。");
        } else {// 其他字串開頭認為資訊不完整
            JOptionPane.showMessageDialog(null, "您輸入的請求資訊不完整。");
        }
    }
    
    protected void do_button_1_actionPerformed(ActionEvent e) {
        dispose();
    }
}
