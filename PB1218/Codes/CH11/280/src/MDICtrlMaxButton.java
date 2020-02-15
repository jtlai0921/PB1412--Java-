import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MDICtrlMaxButton extends JFrame {
    
    private JPanel contentPane;
    private JDesktopPane desktopPane;
    
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
                    MDICtrlMaxButton frame = new MDICtrlMaxButton();
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
    public MDICtrlMaxButton() {
        setTitle("�l���髫���ƦC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 545, 403);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        desktopPane = new JDesktopPane();
        contentPane.add(desktopPane, BorderLayout.CENTER);
        
        JToolBar toolBar = new JToolBar();
        contentPane.add(toolBar, BorderLayout.NORTH);
        
        JButton button = new JButton("�[���l����");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        toolBar.add(button);
        
        ctrlButton = new JToggleButton(
                "�T��骺�̤j��");
        ctrlButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                do_ctrlButton_itemStateChanged(e);
            }
        });
        toolBar.add(ctrlButton);
    }
    
    private int fCount = 0;
    private Random random = new Random();
    private JToggleButton ctrlButton;
    
    protected void do_button_actionPerformed(ActionEvent e) {
        final JInternalFrame jif = new JInternalFrame("�l����" + fCount++, true,
                true, true, true);// �إߤ�������
        jif.setSize(random.nextInt(100) + 100, random.nextInt(100) + 100);
        jif.setLocation(random.nextInt(getWidth() - 100), random
                .nextInt(getHeight() - 100));// �H���w�줺������
        desktopPane.add(jif);// �W�[���������ୱ���O
        jif.setVisible(true);// ��ܤ�������
        // ����������W�[�ƥ��ť��
        jif.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                ctrlButton.setSelected(!jif.isMaximizable());// ����<�T��骺�̤j��>���s���A
            }
        });
    }
    
    protected void do_ctrlButton_itemStateChanged(ItemEvent e) {
        JInternalFrame jif = desktopPane.getSelectedFrame();// ��o��ܪ���������
        if (jif != null) {
            jif.setMaximizable(!ctrlButton.isSelected());// �ҰʩθT�Τ�������̤j�ƫ��s
        }
    }
}
