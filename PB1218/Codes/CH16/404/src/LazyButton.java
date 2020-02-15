import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class LazyButton extends JFrame {
    
    private JPanel contentPane;
    private JButton button;
    private Timer timer;
    
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
                    LazyButton frame = new LazyButton();
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
    public LazyButton() {
        setTitle("延遲生效的按鈕");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 372, 395);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(18, 50, 318, 224);
        contentPane.add(scrollPane);
        
        JTextArea textArea = new JTextArea();// 建立文字域控制項
        textArea.setLineWrap(true);// 自動折行
        StringBuilder sb = new StringBuilder();// 建立字串建構器
        // 建立文字掃瞄器
        Scanner scan = new Scanner(getClass().getResourceAsStream("lzw.txt"));
        while (scan.hasNext()) {// 檢查文字掃瞄器
            String string = (String) scan.nextLine();// 逐行獲得資料
            sb.append(string + "\n");// 把所有行資料增加到字串建構器
        }
        textArea.setText(sb.toString());// 釋放字串建構器中的字串到文字域
        textArea.setSelectionStart(0);// 把文字域在捲動面板中滾至首行
        textArea.setSelectionEnd(0);
        scrollPane.setViewportView(textArea);
        // 建立標籤控制項
        JLabel lblJava = new JLabel("Java編程詞典許可協定");
        lblJava.setFont(new Font("SansSerif", Font.PLAIN, 24));// 指定標籤字體
        lblJava.setHorizontalAlignment(SwingConstants.CENTER);// 標籤文字居中
        lblJava.setBounds(18, 6, 318, 32);
        contentPane.add(lblJava);
        // 建立接收按鈕
        button = new JButton("接受（10秒）");
        button.setEnabled(false);// 取消按鈕的可用狀態
        button.setBounds(59, 286, 124, 30);
        contentPane.add(button);
        // 建立拒絕按鈕
        JButton button_1 = new JButton("拒絕");
        button_1.setBounds(195, 286, 90, 30);
        contentPane.add(button_1);
    }
    
    protected void do_this_windowOpened(WindowEvent e) {// 窗體開啟事件處理方法
        timer = new Timer(1000, new ActionListener() {// 建立timer對象並實現事件處理監聽器
                    int tNum = 10;// 定義倒計時描述
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.setText("接受（" + --tNum + "秒）");// 更新按鈕的計時文字
                        if (tNum <= 0) {// 計時結束後，啟動按鈕可用狀態並停止timer控制項
                            button.setEnabled(true);
                            timer.stop();
                        }
                    }
                });
        timer.start();// 啟動timer控制項
    }
}
