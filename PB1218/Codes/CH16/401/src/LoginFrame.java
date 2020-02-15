import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.UIManager;

public class LoginFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton button;
    
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
                    LoginFrame frame = new LoginFrame();
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
    public LoginFrame() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 329, 185);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("�ѫB�t�εn�J�ɭ�"); // �إ߼��ұ��
        label.setHorizontalAlignment(SwingConstants.CENTER);// ���Ҥ�r�~�����
        label.setFont(new Font("SansSerif", Font.PLAIN, 24));// �]�w���ұ���r��
        label.setBounds(6, 6, 309, 51);
        contentPane.add(label);
        JLabel label_1 = new JLabel("�ϥΪ̦W�١G"); // �إ߼��ұ��
        label_1.setBounds(16, 69, 55, 18);
        contentPane.add(label_1);
        JLabel label_2 = new JLabel("�K�@�X�G"); // �إ߼��ұ��
        label_2.setBounds(16, 103, 55, 18);
        contentPane.add(label_2);
        textField = new JTextField();// �إߤ�r��
        textField.setBounds(65, 63, 242, 30);
        contentPane.add(textField);
        textField.setColumns(10);// �]�w��r�ئC��
        passwordField = new JPasswordField();// �إ߱K�X��
        passwordField.setBounds(65, 99, 143, 30);
        contentPane.add(passwordField);
        button = new JButton("�n�@��");// �إߵn�J���s���S���w��
        contentPane.add(button);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {// �إ߱Ұʨƥ�B�z��k
        new Thread() {// �إ߰ΦW�u�{
            @Override
            public void run() {
                for (int i = 0; i < 217; i++) {// �`��������s������
                    button.setBounds(i, i > 99 ? 99 : i, 90, 30);// ���ʫ��s
                    getRootPane().setComponentZOrder(button, 0);// ����s�m�����
                    try {
                        sleep(1);// �u�{��v
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();// �Ұʽu�{
    }
}
