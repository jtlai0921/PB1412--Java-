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
        addMouseListener(new MouseAdapter() {// �W�[���Шƥ��ť��
            @Override
            public void mousePressed(MouseEvent e) {
                do_this_mousePressed(e);// �I�s���Шƥ�B�z��k
            }
        });
        setBounds(100, 100, 359, 228);// �]�w����j�p
        BGPanel panel = new BGPanel();// �إ߭I�����O
        // �]�w�I���Ϥ�
        panel.setImage(Toolkit.getDefaultToolkit().getImage(
                InfoWindow.class.getResource("/com/lzw/panel/back.jpg")));
        getContentPane().add(panel, BorderLayout.CENTER);
    }
    
    protected void do_this_mousePressed(MouseEvent e) {// ���Шƥ�B�z��k
        dispose();// ���г����A�h�P���o�ӵ���
    }
}
