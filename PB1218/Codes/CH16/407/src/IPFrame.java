import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.lzw.ip.IpField;
import javax.swing.UIManager;

public class IPFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    
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
                    IPFrame frame = new IPFrame();
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
    public IPFrame() {
        setTitle("IP��J��r�ر��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 355, 222);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel label = new JLabel("�]�w�A�Ⱦ��W�ٻPIP�a�}");// �إ߼��D����
        label.setHorizontalAlignment(SwingConstants.CENTER);// �~�����
        label.setFont(new Font("SansSerif", Font.PLAIN, 18));// �]�w�r��
        label.setBounds(6, 6, 298, 39);
        contentPane.add(label);
        JLabel label_1 = new JLabel("�A�Ⱦ��W�١G");// �إ߼���
        label_1.setBounds(6, 57, 83, 18);// �]�w���Ҥj�p
        contentPane.add(label_1);
        JLabel label_2 = new JLabel("�A�Ⱦ�����G");// �إ߼���
        label_2.setBounds(6, 95, 83, 18);// �]�w���Ҥj�p
        contentPane.add(label_2);
        textField = new JTextField();// �إ߿�J�A�Ⱦ��W�٪���r��
        textField.setBounds(82, 51, 251, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        JButton button = new JButton("�T�w");// �إ߽T�w���s
        button.setBounds(54, 132, 90, 30);
        contentPane.add(button);
        JButton button_1 = new JButton("����");// �إ��������s
        button_1.setBounds(177, 132, 90, 30);
        contentPane.add(button_1);
        IpField ipField = new IpField();// �إ�IP��r�ر��
        ipField.setBounds(82, 88, 251, 25);// �]�w����j�p
        contentPane.add(ipField);
    }
}
