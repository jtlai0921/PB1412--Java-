import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.text.NumberFormat;

public class CharacterASCII extends JFrame {
    
    private JPanel contentPane;
    private JTextField charInputField;
    private JTextField codeOutputField;
    private JFormattedTextField codeInputField;
    private JTextField charOutputField;
    
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
                    CharacterASCII frame = new CharacterASCII();
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
    public CharacterASCII() {
        setTitle("�s�X�ഫ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 171);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null,
                "Unicode�ഫ",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
                        59)));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 3, 5, 20));
        
        charInputField = new JTextField();
        panel.add(charInputField);
        charInputField.setColumns(10);
        
        JButton codeButton = new JButton("ASCII");
        codeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_codeButton_actionPerformed(e);
            }
        });
        panel.add(codeButton);
        
        codeOutputField = new JTextField();
        codeOutputField.setEditable(false);
        panel.add(codeOutputField);
        codeOutputField.setColumns(10);
        
        codeInputField = new JFormattedTextField(NumberFormat
                .getIntegerInstance());
        panel.add(codeInputField);
        codeInputField.setColumns(10);
        
        JButton charButton = new JButton("��r��");
        charButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_charButton_actionPerformed(e);
            }
        });
        panel.add(charButton);
        
        charOutputField = new JTextField();
        charOutputField.setEditable(false);
        panel.add(charOutputField);
        charOutputField.setColumns(10);
    }
    
    protected void do_codeButton_actionPerformed(ActionEvent e) {
        String text = charInputField.getText();// ��o�ϥΪ̿�J���r��
        char[] charArray = text.toCharArray();// ��o�r�ꪺ�r�Ű}�C
        StringBuilder builder = new StringBuilder();// �إߦr��غc��
        for (char c : charArray) {// �ˬd�r�Ű}�C
            builder.append((int) c + " ");// �s���U�r�Ū��g�{��
        }
        codeOutputField.setText(builder.toString());// ���G��X���r��
    }
    
    protected void do_charButton_actionPerformed(ActionEvent e) {
        Number value = (Number) codeInputField.getValue();// ��o�ϥΪ̿�JUnicode�g�{��
        long code = value.longValue();// ����J�Ʀr��Long���A��
        charOutputField.setText(((char) code) + "");// ��X�g�{�����r��
    }
}
