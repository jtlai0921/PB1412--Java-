import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JToolBar;

public class SetMDIForm extends JFrame {
    
    private JPanel contentPane;
    
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
                    SetMDIForm frame = new SetMDIForm();
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
    public SetMDIForm() {
        setTitle("創建內部子窗體");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 343);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        contentPane.add(desktopPane, BorderLayout.CENTER);
        
        button = new JButton("打開");
        button.setBounds(389, 259, 59, 30);
        desktopPane.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
    }
    
    private JDesktopPane desktopPane = new JDesktopPane();
    private int frameCount = 0;
    private JButton button;
    
    protected void do_button_actionPerformed(ActionEvent e) {
        frameCount++;// 窗體計數器累加
        // 建立內部子窗體
        JInternalFrame jif = new JInternalFrame("子窗體" + frameCount, true, true,
                true, true);
        jif.setBounds(frameCount * 20, frameCount * 20, 200, 200);// 設定窗體位置與大小
        desktopPane.add(jif);// 增加子窗體到桌面面板
        jif.setVisible(true);// 顯示子窗體
        desktopPane.setComponentZOrder(button, 0);// 把按鈕置頂
    }
}
