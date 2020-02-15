import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SetFormSizeByDeskSize extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SetFormSizeByDeskSize frame = new SetFormSizeByDeskSize();
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
    public SetFormSizeByDeskSize() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);
            }
        });
        setTitle("�ھڮୱ�j�p�վ㵡��j�p");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        Toolkit toolkit = getToolkit();// ��o����u��]
        Dimension screenSize = toolkit.getScreenSize();// ��o�̹��j�p
        int width = (int) (screenSize.width * 0.8);// �p�ⵡ��s�e��
        int height = (int) (screenSize.height * 0.8);// �p�ⵡ��s�e��
        setSize(width, height);// �]�w����j�p
    }
}
