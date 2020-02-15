import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ArrayBound extends JFrame {
    
    private JPanel contentPane;
    private JFormattedTextField codeField;
    private JTextArea infoArea;
    
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
                    ArrayBound frame = new ArrayBound();
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
    public ArrayBound() {
        setTitle("�}�C���U�Ьɭ�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 349, 199);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("����E�X�D,1-5");
        label.setBounds(10, 10, 317, 27);
        contentPane.add(label);
        
        codeField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        codeField.setBounds(77, 40, 122, 30);
        contentPane.add(codeField);
        codeField.setColumns(10);
        
        JLabel label_2 = new JLabel("����E�X�D");
        label_2.setBounds(10, 46, 67, 18);
        contentPane.add(label_2);
        
        JButton button = new JButton("�T�w");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(211, 40, 90, 30);
        contentPane.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 76, 317, 79);
        contentPane.add(scrollPane);
        
        infoArea = new JTextArea();
        infoArea.setLineWrap(true);
        scrollPane.setViewportView(infoArea);
    }
    
    private String[] infos = { "50������", "�ۤ@���q", "�Ǫ��s", "���j�a���@�ӯ���", "3�U������" };
    
    protected void do_button_actionPerformed(ActionEvent e) {
        // ��o�ϥΪ̿�J�����
        int index = ((Number) codeField.getValue()).intValue();
        try {
            infoArea.setText(infos[index]);// ��o���w���ު��}�C������ܦb��r�챱���
        } catch (Exception e2) {
            infoArea.setText("�o�ͨҥ~�G\n" + e2.toString());// �ҥ~��T��ܦb��r�챱���
        }
    }
}
