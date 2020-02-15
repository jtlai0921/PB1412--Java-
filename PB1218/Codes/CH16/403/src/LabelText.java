import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;

public class LabelText extends JFrame {
    
    private JPanel contentPane;
    private JLabel label;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LabelText frame = new LabelText();
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
    public LabelText() {
        addWindowListener(new WindowAdapter() {// 為窗體增加開啟事件處理器
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);// 呼叫窗體開啟事件處理方法
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 設定窗體預設關閉方式
        setBounds(100, 100, 450, 179);// 設定窗體大小
        contentPane = new JPanel();// 建立內容面板
        setContentPane(contentPane);// 設定內容面板
        contentPane.setLayout(new BorderLayout(0, 0));// 設定窗體佈局
        label = new JLabel("");// 建立標籤控制項
        label.setHorizontalAlignment(SwingConstants.RIGHT);// 文字右對齊
        contentPane.add(label);// 增加標籤到窗體
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        new Thread() {// 建立新的匿名線程對像
            @Override
            public void run() {// 重新定義run()方法
                int len = getWidth() / 12;// 獲得跑馬燈LED數量
                String info = "Java編程詞典";// 定義跑馬燈文字
                while (true) {// 建立無限循環
                    String space = "";// 建立空白字串
                    for (int i = 0; i < len - info.length() - 2; i++) {// 檢查LED數量
                        len = getWidth() / 12;// 獲得跑馬燈LED數量
                        space += "　";// 為空白字串增加空格字符
                        label.setText(info + space);// 設定標籤文字
                        try {
                            sleep(300);// 線程休眠
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();// 啟動線程
    }
}
