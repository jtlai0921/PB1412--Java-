import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ButtonReadFont extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    
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
                    ButtonReadFont frame = new ButtonReadFont();
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
    public ButtonReadFont() {
        setTitle("��{���s����r�y��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 394, 156);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("�ϥΪ̦W�١G");// �إ߼���
        label.setBounds(20, 23, 55, 18);
        contentPane.add(label);
        
        textField = new JTextField();// �إߤ�r��
        textField.setBounds(75, 17, 122, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        JLabel label_1 = new JLabel("�K�@�X�G");// �إ߼���
        label_1.setBounds(20, 72, 55, 18);
        contentPane.add(label_1);
        passwordField = new JPasswordField();// �إ߱K�X��
        passwordField.setBounds(75, 66, 122, 30);
        contentPane.add(passwordField);
        JButton button = new JButton("<html>" + "<body align=center>"
                + "<Font size=6 color=red>�n�J</font><br>" + "�����޺޲z�t��"
                + "</body>" + "</html>");// �إ߫��s����ó]�whtml��r
        button.setBounds(209, 23, 141, 76);
        contentPane.add(button);
    }
}
