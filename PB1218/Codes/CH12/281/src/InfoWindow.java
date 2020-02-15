import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JWindow;

import com.lzw.panel.BGPanel;

public class InfoWindow extends JWindow {
    
    /**
     * Create the frame.
     */
    public InfoWindow() {
        addMouseListener(new MouseAdapter() {// 增加鼠標事件監聽器
            @Override
            public void mousePressed(MouseEvent e) {
                do_this_mousePressed(e);// 呼叫鼠標事件處理方法
            }
        });
        setBounds(100, 100, 359, 228);// 設定窗體大小
        BGPanel panel = new BGPanel();// 建立背景面板
        // 設定背景圖片
        panel.setImage(Toolkit.getDefaultToolkit().getImage(
                InfoWindow.class.getResource("/com/lzw/panel/back.jpg")));
        getContentPane().add(panel, BorderLayout.CENTER);
    }
    
    protected void do_this_mousePressed(MouseEvent e) {// 鼠標事件處理方法
        dispose();// 鼠標單擊，則銷毀這個窗體
    }
}
