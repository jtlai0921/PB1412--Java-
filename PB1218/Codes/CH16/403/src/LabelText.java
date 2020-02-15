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
        addWindowListener(new WindowAdapter() {// ������W�[�}�Ҩƥ�B�z��
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);// �I�s����}�Ҩƥ�B�z��k
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �]�w����w�]�����覡
        setBounds(100, 100, 450, 179);// �]�w����j�p
        contentPane = new JPanel();// �إߤ��e���O
        setContentPane(contentPane);// �]�w���e���O
        contentPane.setLayout(new BorderLayout(0, 0));// �]�w����G��
        label = new JLabel("");// �إ߼��ұ��
        label.setHorizontalAlignment(SwingConstants.RIGHT);// ��r�k���
        contentPane.add(label);// �W�[���Ҩ쵡��
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        new Thread() {// �إ߷s���ΦW�u�{�ﹳ
            @Override
            public void run() {// ���s�w�qrun()��k
                int len = getWidth() / 12;// ��o�]���OLED�ƶq
                String info = "Java�s�{����";// �w�q�]���O��r
                while (true) {// �إߵL���`��
                    String space = "";// �إߪťզr��
                    for (int i = 0; i < len - info.length() - 2; i++) {// �ˬdLED�ƶq
                        len = getWidth() / 12;// ��o�]���OLED�ƶq
                        space += "�@";// ���ťզr��W�[�Ů�r��
                        label.setText(info + space);// �]�w���Ҥ�r
                        try {
                            sleep(300);// �u�{��v
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();// �Ұʽu�{
    }
}
