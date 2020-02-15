import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class ExampleFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    
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
                    ExampleFrame frame = new ExampleFrame();
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
    public ExampleFrame() {
        // ������W�[�}�Ҩƥ��ť��
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);// �I�s����}�Ҩƥ�B�z��k
            }
        });
        setTitle("�ʺA���J�����");// �]�w������D
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);// �]�w����j�p
        contentPane = new JPanel();// �إߤ��e���O
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JScrollPane scrollPane = new JScrollPane();// �إ߱��ʭ��O
        contentPane.add(scrollPane, BorderLayout.CENTER);
        table = new JTable();// �إߪ�汱�
        model = new DefaultTableModel(new Object[][] {}, new String[]
            { "�Ǹ�", "�åͤ���", "�ͬ�����" });// �إ߹w�]������Ƽҫ�
        table.setModel(model);// �]�w����Ƽҫ�
        scrollPane.setViewportView(table);// ����W�[�챲�ʭ��O�˵�
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        // �إ�Timer���
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();// �إ��H���ƹﹳ
                Integer[] values = new Integer[]
                    // �إ߾�ư}�C�@��������
                    { random.nextInt(100), random.nextInt(100),
                            random.nextInt(100) };
                model.addRow(values);// ������Ƽҫ��W�[�@����
            }
        });
        timer.start();// �Ұ�Timer���
    }
}
