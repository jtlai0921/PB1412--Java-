import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class DeleteBlank extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextField resultField;
    
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
                    DeleteBlank frame = new DeleteBlank();
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
    public DeleteBlank() {
        setTitle("�h���r�ꤤ���Ҧ��Ů�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 386, 128);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("��J�r��G");
        label.setBounds(21, 10, 75, 15);
        contentPane.add(label);
        
        JButton button = new JButton("�h�Ů�");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(10, 49, 82, 23);
        contentPane.add(button);
        
        textField = new JTextField();
        textField.setBounds(102, 2, 258, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        resultField = new JTextField();
        resultField.setBounds(102, 45, 258, 30);
        contentPane.add(resultField);
        resultField.setColumns(10);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = textField.getText();// ��o�ϥΪ̿�J��r
        StringBuilder strBuilder = new StringBuilder();// �إߦr��غc��
        for (int i = 0; i < text.length(); i++) {// �ˬd�r��
            char charAt = text.charAt(i);// ��o�C�Ӧr��
            if (charAt == ' ')// �L�o�Ů�r��
                continue;
            strBuilder.append(charAt);// �l�[�D�Ů�r�Ũ�r�ūغc��
        }
        resultField.setText(strBuilder.toString());// ��غc�������r����ܨ��r��
    }
}
