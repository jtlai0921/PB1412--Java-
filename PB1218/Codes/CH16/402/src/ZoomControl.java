import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.UIManager;

public class ZoomControl extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JTextField textField_1;
    private FocusAdapter focusAdapter;
    
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
                    ZoomControl frame = new ZoomControl();
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
    public ZoomControl() {
        setTitle("�J�I���s���Y��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 298, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("���U�ɭ�");
        label.setFont(new Font("SansSerif", Font.PLAIN, 38));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(6, 6, 270, 45);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel("�ϥΪ̦W�١G");
        label_1.setBounds(18, 69, 55, 18);
        contentPane.add(label_1);
        
        JLabel label_2 = new JLabel("�K�@�X�G");
        label_2.setBounds(18, 111, 55, 18);
        contentPane.add(label_2);
        
        JLabel label_3 = new JLabel("�T�{�K�X�G");
        label_3.setBounds(6, 153, 65, 18);
        contentPane.add(label_3);
        
        JLabel label_4 = new JLabel("�l�@�c�G");
        label_4.setBounds(18, 195, 55, 18);
        contentPane.add(label_4);
        
        textField = new JTextField();// �إߤ�r��
        textField.setBounds(69, 63, 198, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(69, 105, 198, 30);
        contentPane.add(passwordField);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(69, 147, 198, 30);
        contentPane.add(passwordField_1);
        
        textField_1 = new JTextField();
        textField_1.setBounds(69, 189, 198, 30);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JButton button = new JButton("���U");
        button.setBounds(64, 225, 65, 30);
        contentPane.add(button);
        
        JButton button_1 = new JButton("����");
        button_1.setBounds(177, 225, 65, 30);
        contentPane.add(button_1);
        
        focusAdapter = new FocusAdapter() {// �إߵJ�I�����d
            private Rectangle sourceRec;// �إ߯x�ιﹳ
            
            @Override
            public void focusGained(FocusEvent e) {
                JComponent component = (JComponent) e.getSource();// ��o�ƥ󷽫��s
                sourceRec = component.getBounds();// �x�s���s�j�p
                component.setBounds(sourceRec.x - 5, sourceRec.y - 5,
                        sourceRec.width + 10, sourceRec.height + 10);// ����s��j
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                JComponent component = (JComponent) e.getSource();// ��o�ƥ󷽫��s
                if (sourceRec != null) {// �p�G���ƥ��x�Ϋh�Υ���_���s�j�p
                    component.setBounds(sourceRec);// �]�w���s�j�p
                }
            }
        };
        // ��o����Ҧ����
        Component[] components = getContentPane().getComponents();
        for (Component component : components) {// �ˬd�Ҧ����
            component.addFocusListener(focusAdapter);// ���Ҧ�����W�[�J�I�ƥ��ť��
        }
        
    }
}
