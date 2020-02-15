import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrameShowException extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrameShowException frame = new FrameShowException();
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
    public FrameShowException() {
        setTitle("��ܨҥ~��T");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 253);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel(
                "�п�J�D�Ʀ�r��A�˵��ର�Ʀr�ɵo�ͪ��ҥ~�C");
        label.setBounds(10, 10, 414, 15);
        contentPane.add(label);
        
        textField = new JTextField();
        textField.setBounds(10, 32, 248, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btninteger = new JButton(
                "�ഫ��Integer����");
        btninteger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_btninteger_actionPerformed(e);
            }
        });
        btninteger.setBounds(268, 31, 156, 23);
        contentPane.add(btninteger);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setOpaque(false);
        scrollPane.setBounds(10, 63, 414, 142);
        contentPane.add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setText("��T���ܮ�");
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_btninteger_actionPerformed(ActionEvent e) {
        // �إߦr�`�}�C��X�y
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(stream));// ���s�ɦVerr��X�y
        String numStr = textField.getText();// ��o�ϥΪ̿�J
        try {
            Integer value = Integer.valueOf(numStr);// �r������
        } catch (NumberFormatException e1) {
            e1.printStackTrace();// ��X���~�ҥ~��T
        }
        String info = stream.toString();// ��o�r�`��X�y���r��
        if (info.isEmpty()) {// ��ܥ��`�ഫ�����ܸ�T
            textArea.setText("�r���Integer���ഫ�S���o�ͨҥ~�C");
        } else {// ��ܥX�{�ҥ~�����ܸ�T�P�ҥ~
            textArea.setText("�����աI�ഫ�L�{���X�{�F�p�U�ҥ~���~�G\n" + info);
        }
    }
}