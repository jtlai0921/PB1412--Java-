import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;

public class ShowBevelBorder extends JFrame {
    
    private JPanel contentPane;
    
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
                    ShowBevelBorder frame = new ShowBevelBorder();
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
    public ShowBevelBorder() {
        setTitle("��{���ұ�����������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 132);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("�W�����������");
        label.setBounds(150, 18, 100, 22);// �]�w���Ҧ�m�P�j�p
        contentPane.add(label);// �W�[���Ҩ쵡�魱�O
        label.setHorizontalAlignment(SwingConstants.CENTER);// ��r�~�����
        label.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
                null));// �]�w���Ҫ����
        
        JLabel label_1 = new JLabel("��_���������");
        label_1.setBounds(150, 52, 100, 22);// �]�w���Ҧ�m�P�j�p
        contentPane.add(label_1);// �W�[���Ҩ쵡�魱�O
        label_1.setHorizontalAlignment(SwingConstants.CENTER);// ��r�~�����
        label_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
                null));// �]�w���Ҫ����
        
        JLabel label_2 = new JLabel("���̥i���O���s�A���O����");
        label_2.setBounds(262, 20, 166, 54);// �]�w���Ҧ�m�P�j�p
        contentPane.add(label_2);// �W�[���Ҩ쵡�魱�O
        
        JLabel label_3 = new JLabel("���w����C��");
        label_3.setHorizontalAlignment(SwingConstants.CENTER);// ��r�~�����
        label_3.setBounds(6, 17, 124, 55);// �]�w���Ҧ�m�P�j�p
        contentPane.add(label_3);// �W�[���Ҩ쵡�魱�O
        Color highlightOuter = new Color(255, 255, 0);// ��ت��ϥ��C��Ѽ�
        Color highlightInner = new Color(255, 175, 175);
        label_3.setBorder(new BevelBorder(BevelBorder.LOWERED, highlightOuter,
                highlightInner, Color.BLUE, Color.RED));// �]�w���Ҫ����
    }
}
