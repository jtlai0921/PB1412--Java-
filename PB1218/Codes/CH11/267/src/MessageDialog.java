import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class MessageDialog extends JFrame {
    
    private JPanel contentPane;
    private JTextField titleField;
    private ButtonGroup bg;
    private JTextArea messageArea;
    
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
                    MessageDialog frame = new MessageDialog();
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
    public MessageDialog() {
        setTitle("�H�����ܹ�ܮ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 419, 254);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        titleField = new JTextField();
        titleField.setBounds(63, 6, 334, 30);
        contentPane.add(titleField);
        titleField.setColumns(10);
        
        JButton button = new JButton("�u�X��ܮ�");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(167, 180, 90, 30);
        contentPane.add(button);
        
        JLabel label = new JLabel("�H�����D�G");
        label.setBounds(6, 12, 65, 18);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel("�H�����e�G");
        label_1.setBounds(6, 42, 65, 18);
        contentPane.add(label_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(63, 42, 334, 99);
        contentPane.add(scrollPane);
        
        messageArea = new JTextArea();
        scrollPane.setViewportView(messageArea);
        
        JLabel label_2 = new JLabel("�H�������G");
        label_2.setBounds(6, 150, 65, 18);
        contentPane.add(label_2);
        
        JRadioButton radioButton = new JRadioButton("���q");
        radioButton.setActionCommand("���q");
        radioButton.setBounds(63, 150, 57, 18);
        contentPane.add(radioButton);
        
        JRadioButton radioButton_1 = new JRadioButton("��T");
        radioButton_1.setSelected(true);
        radioButton_1.setActionCommand("��T");
        radioButton_1.setBounds(131, 150, 57, 18);
        contentPane.add(radioButton_1);
        
        JRadioButton radioButton_2 = new JRadioButton("�ð�");
        radioButton_2.setActionCommand("�ð�");
        radioButton_2.setBounds(271, 150, 57, 18);
        contentPane.add(radioButton_2);
        
        JRadioButton radioButton_3 = new JRadioButton("ĵ�i");
        radioButton_3.setActionCommand("ĵ�i");
        radioButton_3.setBounds(202, 150, 57, 18);
        contentPane.add(radioButton_3);
        
        JRadioButton radioButton_4 = new JRadioButton("���~");
        radioButton_4.setActionCommand("���~");
        radioButton_4.setBounds(340, 150, 57, 18);
        contentPane.add(radioButton_4);
        bg = new ButtonGroup();
        bg.add(radioButton);
        bg.add(radioButton_1);
        bg.add(radioButton_2);
        bg.add(radioButton_3);
        bg.add(radioButton_4);
    }
    
protected void do_button_actionPerformed(ActionEvent e) {
    String title = titleField.getText();// ��o���D��r
    String message = messageArea.getText();// ��o���e��r
    String command = bg.getSelection().getActionCommand();// ��o��ܪ������s
    int messageType = JOptionPane.INFORMATION_MESSAGE;// �إ߸�T���A
    if (command.equals("���q"))// �ھڨϥΪ̿�ܽT�w��͵������A
        messageType = JOptionPane.PLAIN_MESSAGE;
    if (command.equals("�ð�"))
        messageType = JOptionPane.QUESTION_MESSAGE;
    if (command.equals("ĵ�i"))
        messageType = JOptionPane.WARNING_MESSAGE;
    if (command.equals("���~"))
        messageType = JOptionPane.ERROR_MESSAGE;
    // ��ܥ�͵���
    System.out.println(messageType);
    JOptionPane.showMessageDialog(this, message, title, messageType);
}
}
