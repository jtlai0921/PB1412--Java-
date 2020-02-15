import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QQFrame extends JFrame {
    
    private JPanel contentPane;
    private boolean collection;
    private boolean over = false;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QQFrame frame = new QQFrame();
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
    public QQFrame() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                do_this_mouseEntered(e);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                do_this_mouseExited(e);
            }
        });
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                do_this_componentMoved(e);
            }
        });
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 412, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JLabel label = new JLabel("<html><body align=center>�ڬO�@�ӥ�QQ���õ���"
                + "<br><font color=green size=6>��ک�쵡�鳻�ݡA"
                + "�ڷ|�۰�����</font></body></html>");
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    protected void do_this_componentMoved(ComponentEvent e) {// ���鲾�ʨƥ�B�z��k
        if (over)// �p�G���Цb���餤�A�N�����������þާ@
            return;
        Point point = getLocation();// ��o�����m
        if (point.y < 10) {// �p�G���鱵��̹�����
            collection = true;// �T�w���õ���лx
            Dimension size = getSize();// ��o����j�p
            setLocation(point.x, -size.height + 5);// ���õ���
        } else {
            collection = false;// �p�G����S������̹����ݫh�������üлx
        }
    }
    
    protected void do_this_mouseEntered(MouseEvent e) {// ���жi�J���骺�ƥ�B�z��k
        Point point = getLocation();// ��o�����m
        if (point.y > 0)// �p�G����S���Q���ä�������ާ@
            return;
        setLocation(point.x, 8);// �]�w�������
        over = true;// �лx���Цb���餺��
        try {
            Thread.sleep(1000);// ������1�����ɶ������дN��
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
    
    protected void do_this_mouseExited(MouseEvent e) {// �������}�ƥ�B�z��k
        if (over) {// �p�G���млx�b���餺��
            over = false;// �������Ц�m���лx
            do_this_componentMoved(null);// ���õ���
        }
    }
}
