import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class StringLinewrap extends JFrame {
    
    private JPanel contentPane;
    private JTextArea sourceTextArea;
    private JTextArea destinationTextArea;
    
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
                    StringLinewrap frame = new StringLinewrap();
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
    public StringLinewrap() {
        setTitle("�ھڼ��I��r�����");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 475, 441);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel(
                "<html>�b�U������r�����J�r��q���A�䤤�n�]�A�]�A�^���I�Ÿ��C�M���I����������ܡ����s�A�{���N�ھڡ]�A�^�Ÿ�����C</html>");
        label.setBorder(new TitledBorder(null, "����",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        label.setBounds(10, 10, 439, 76);
        contentPane.add(label);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 84, 439, 98);
        contentPane.add(scrollPane);
        
        sourceTextArea = new JTextArea();
        sourceTextArea.setLineWrap(true);
        scrollPane.setViewportView(sourceTextArea);
        
        JButton button = new JButton("�������");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(177, 192, 101, 25);
        contentPane.add(button);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 233, 439, 156);
        contentPane.add(scrollPane_1);
        
        destinationTextArea = new JTextArea();
        scrollPane_1.setViewportView(destinationTextArea);
        
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String sourceString = sourceTextArea.getText();// ��o�ϥΪ̿�J�r�q
        String[] lines = sourceString.split(",|�A");// �ھڤ��^��r�����Φr�ꬰ�}�C
        StringBuilder sbuilder = new StringBuilder();// �إߦr��غc��
        for (String line : lines) {// �ˬd���Ϋ᪺�r��}�C
            // ��C�Ӱ}�C�������r��P�T�{�Ŭ۳s�üW�[��r��غc����
            sbuilder.append(line + "\n");
        }
        // ��r��W�[�촫����ܦr�ꪺ��r�줤
        destinationTextArea.setText(sbuilder.toString());
    }
}
