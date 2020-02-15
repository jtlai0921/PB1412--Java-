import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class LazyButton extends JFrame {
    
    private JPanel contentPane;
    private JButton button;
    private Timer timer;
    
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
                    LazyButton frame = new LazyButton();
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
    public LazyButton() {
        setTitle("����ͮĪ����s");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 372, 395);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(18, 50, 318, 224);
        contentPane.add(scrollPane);
        
        JTextArea textArea = new JTextArea();// �إߤ�r�챱�
        textArea.setLineWrap(true);// �۰ʧ��
        StringBuilder sb = new StringBuilder();// �إߦr��غc��
        // �إߤ�r���˾�
        Scanner scan = new Scanner(getClass().getResourceAsStream("lzw.txt"));
        while (scan.hasNext()) {// �ˬd��r���˾�
            String string = (String) scan.nextLine();// �v����o���
            sb.append(string + "\n");// ��Ҧ����ƼW�[��r��غc��
        }
        textArea.setText(sb.toString());// ����r��غc�������r����r��
        textArea.setSelectionStart(0);// ���r��b���ʭ��O���u�ܭ���
        textArea.setSelectionEnd(0);
        scrollPane.setViewportView(textArea);
        // �إ߼��ұ��
        JLabel lblJava = new JLabel("Java�s�{����\�i��w");
        lblJava.setFont(new Font("SansSerif", Font.PLAIN, 24));// ���w���Ҧr��
        lblJava.setHorizontalAlignment(SwingConstants.CENTER);// ���Ҥ�r�~��
        lblJava.setBounds(18, 6, 318, 32);
        contentPane.add(lblJava);
        // �إ߱������s
        button = new JButton("�����]10��^");
        button.setEnabled(false);// �������s���i�Ϊ��A
        button.setBounds(59, 286, 124, 30);
        contentPane.add(button);
        // �إߩڵ����s
        JButton button_1 = new JButton("�ڵ�");
        button_1.setBounds(195, 286, 90, 30);
        contentPane.add(button_1);
    }
    
    protected void do_this_windowOpened(WindowEvent e) {// ����}�Ҩƥ�B�z��k
        timer = new Timer(1000, new ActionListener() {// �إ�timer��H�ù�{�ƥ�B�z��ť��
                    int tNum = 10;// �w�q�˭p�ɴy�z
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.setText("�����]" + --tNum + "��^");// ��s���s���p�ɤ�r
                        if (tNum <= 0) {// �p�ɵ�����A�Ұʫ��s�i�Ϊ��A�ð���timer���
                            button.setEnabled(true);
                            timer.stop();
                        }
                    }
                });
        timer.start();// �Ұ�timer���
    }
}
