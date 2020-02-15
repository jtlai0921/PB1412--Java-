import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoDemoFrame extends JFrame {
    
    private JPanel contentPane;
    private InfoWindow window = new InfoWindow();
    private Timer timer;
    private Point location;
    private Dimension screenSize;
    private Dimension windowSize;;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InfoDemoFrame frame = new InfoDemoFrame();
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
    public InfoDemoFrame() {
        setTitle("�k�U���X�{��T����");// �]�w������D
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 337, 190);// ����j�p
        contentPane = new JPanel();// �إߤ��e���O
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);// �����G���޲z��
        JButton button = new JButton("��o�Y�ɸ�T");// �إ߫��s
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);// �I�s���s�ƥ�B�z��k
            }
        });
        button.setBounds(97, 59, 122, 30);
        contentPane.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        // �إ�Timer���
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                location.y -= 1;// ���ɸ�T���髫���y��
                // �b��T������ܦӥB�S���F��W�ɦ�m���e���򲾰ʵ���
                if (window.isShowing()
                        && location.y > screenSize.height - windowSize.height)
                    window.setLocation(location);
                else {// ���饼��ܩζW�X���ʽd��O����
                    Timer source = (Timer) e.getSource();
                    source.stop();
                }
            }
        });
        screenSize = getToolkit().getScreenSize();// ��o�̹��j�p
        window.setVisible(true);// ��ܸ�T����
        window.setAlwaysOnTop(true);// ���T����m��
        windowSize = window.getSize();// ��o��T����j�p
        location = new Point();// �إߦ�m�ﹳ
        location.x = screenSize.width - windowSize.width;// ��l�Ƶ����m
        location.y = screenSize.height;
        timer.start();// �Ұ�Timer���
    }
}
