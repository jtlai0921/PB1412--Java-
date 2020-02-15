import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ExpandFrame extends JFrame {
    private JPanel contentPane;
    private int frameWidth = 450;
    private JTextField textField;
    private JTextField textField_1;
    
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
                    ExpandFrame frame = new ExpandFrame();
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
    public ExpandFrame() {
        setTitle("�Զ}����S��");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 0, 221);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(135, 206, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("�n���Ҷ�");
        label.setOpaque(true);
        label.setBackground(new Color(245, 222, 179));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 30));
        label.setBounds(6, 6, 422, 72);
        contentPane.add(label);
        
        JLabel label_1 = new JLabel("�Τ�W�G");
        label_1.setBounds(31, 90, 55, 18);
        contentPane.add(label_1);
        
        JLabel label_2 = new JLabel("�K�@�X�G");
        label_2.setBounds(31, 134, 55, 18);
        contentPane.add(label_2);
        
        textField = new JTextField();
        textField.setBounds(83, 84, 184, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(83, 128, 184, 30);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JButton button = new JButton("�n��");
        button.setBounds(304, 84, 90, 30);
        contentPane.add(button);
        
        JButton button_1 = new JButton("����");
        button_1.setBounds(304, 128, 90, 30);
        contentPane.add(button_1);
        setLocationRelativeTo(null);
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        final int height = getHeight();// �O�����鰪��
        new Thread() {// �إ߷s�u�{
            public void run() {
                Rectangle rec = getBounds();
                for (int i = 0; i < frameWidth; i += 10) {// �`�����i����
                    setBounds(rec.x - i / 2, rec.y, i, height);// ���_�]�w����j�p�P��m
                    try {
                        Thread.sleep(10);// �u�{��v10�@��
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }.start();// �Ұʽu�{
    }
}
