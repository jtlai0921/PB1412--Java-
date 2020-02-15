import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JToolBar;

public class SetMDIForm extends JFrame {
    
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
                    SetMDIForm frame = new SetMDIForm();
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
    public SetMDIForm() {
        setTitle("�Ыؤ����l����");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 343);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        contentPane.add(desktopPane, BorderLayout.CENTER);
        
        button = new JButton("���}");
        button.setBounds(389, 259, 59, 30);
        desktopPane.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
    }
    
    private JDesktopPane desktopPane = new JDesktopPane();
    private int frameCount = 0;
    private JButton button;
    
    protected void do_button_actionPerformed(ActionEvent e) {
        frameCount++;// ����p�ƾ��֥[
        // �إߤ����l����
        JInternalFrame jif = new JInternalFrame("�l����" + frameCount, true, true,
                true, true);
        jif.setBounds(frameCount * 20, frameCount * 20, 200, 200);// �]�w�����m�P�j�p
        desktopPane.add(jif);// �W�[�l�����ୱ���O
        jif.setVisible(true);// ��ܤl����
        desktopPane.setComponentZOrder(button, 0);// ����s�m��
    }
}
