import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class FrameIcon extends JFrame {
    
    private JPanel contentPane;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    
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
                    FrameIcon frame = new FrameIcon();
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
    public FrameIcon() {
        setResizable(false);
        setTitle("指定窗體標題欄圖標");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 535, 348);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        URL resource = getClass().getResource("background.jpg");
        Image image = new ImageIcon(resource).getImage();
        backgroundPanel.setImage(image);
        contentPane.add(backgroundPanel, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBounds(45, 212, 447, 54);
        backgroundPanel.add(panel);
        
        button1 = new JButton("圖標1");
        button1.setIcon(new ImageIcon(getClass().getResource("icon1.png")));
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button1);
        
        button2 = new JButton("圖標2");
        panel.add(button2);
        button2.setIcon(new ImageIcon(getClass().getResource("icon2.png")));
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        
        button3 = new JButton("圖標3");
        panel.add(button3);
        button3.setIcon(new ImageIcon(getClass().getResource("icon3.png")));
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        
        button4 = new JButton("圖標4");
        panel.add(button4);
        button4.setIcon(new ImageIcon(getClass().getResource("icon4.png")));
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String resource = "";// 定義圖標檔案名稱變數
        if (e.getSource() == button1)// 確定使用者單擊的按鈕
            resource = "icon1.png";// 確定按鈕對應的圖標檔案
        if (e.getSource() == button2)
            resource = "icon2.png";
        if (e.getSource() == button3)
            resource = "icon3.png";
        if (e.getSource() == button4)
            resource = "icon4.png";
        URL url = getClass().getResource(resource);// 獲得圖標檔案路徑
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));// 設定窗體的圖標
    }
}
