import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class CancelFrameTitleBorder extends JFrame {
    
    private JPanel contentPane;
    private JTextArea textArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CancelFrameTitleBorder frame = new CancelFrameTitleBorder();
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
public CancelFrameTitleBorder() {
    // 設定背景色
    getContentPane().setBackground(new Color(240, 255, 255));
    setUndecorated(true);// 取消窗體修飾效果************
    setTitle("關於進銷存管理系統");// 設定標題欄
    getContentPane().setLayout(null);
    setBounds(100, 100, 354, 206);
    setLocationRelativeTo(null);// 窗體居中
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JLabel label = new JLabel();// 用標籤顯示logo
    label.setIcon(new ImageIcon(getClass().getResource("logo.png")));
    label.setBounds(10, 27, 112, 98);
    getContentPane().add(label);
    textArea = new JTextArea();// 用文字域顯示系統資訊
    textArea.setOpaque(false);// 控制項透明
    textArea.setText("系統：\n  Microsoft Windows Server 2003\n" +
            "  Standard Editon\n  Service Pack 2\n\n\n" +
            "軟件：進銷存管理系統\n版權：明日科技");
    textArea.setBounds(154, 6, 187, 154);
    getContentPane().add(textArea);// 增加控制項到窗體
    JButton button = new JButton("關閉");// 建立「關閉」按鈕
    button.addActionListener(new ActionListener() {// 增加按鈕的事件監聽器
        public void actionPerformed(ActionEvent e) {
            do_button_actionPerformed(e);// 呼叫按鈕事件處理方法
        }
    });
    button.setBounds(230, 172, 90, 30);
    getContentPane().add(button);// 增加按鈕到窗體
}
    
protected void do_button_actionPerformed(ActionEvent e) {
    dispose();// 銷毀窗體
}
}
