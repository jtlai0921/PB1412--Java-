import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class CheckBoxArray extends JFrame {
    
    private JPanel contentPane;
    private JPanel panel;
    
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
                    CheckBoxArray frame = new CheckBoxArray();
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
    public CheckBoxArray() {
        setTitle("�֨��������}�C");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 409, 331);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JLabel label = new JLabel(
                "\u4F60\u7684\u7231\u597D\u6709\u54EA\u4E9B\uFF1A");
        contentPane.add(label, BorderLayout.NORTH);
        contentPane.add(getPanel(), BorderLayout.CENTER);
    }
    
    private JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();// �إ߭��O�ﹳ
            panel.setLayout(new GridLayout(0, 4));// �]�w����G���޲z��
            // �إ߱����r�}�C
            String[] labels = { "���y", "�x�y", "�]�N", "���y", "�ݹq�v", "�]�~�@��", "CS�Զ�",
                    "�Ф�y", "��a", "�ȹC", "���s", "�ۺq", "�g������", "�ʪ��@��", "���", "�u�N�L",
                    "Ū����", "�t��", "�}��", "�}�ӳ�", "�±N", "�ݮ�", "�W���ݸ��", "�s�D", "�x��",
                    "�K��", "�i��", "����" };
            JCheckBox[] boxs = new JCheckBox[labels.length];// �إ߱���}�C
            for (int i = 0; i < boxs.length; i++) {// �ˬd����}�C
                boxs[i] = new JCheckBox(labels[i]);// ��l�ư}�C�����_��ؤ���
                panel.add(boxs[i]);// ��}�C�����]�Y�C�Ӵ_��ء^�W�[�쭱�O��
            }
        }
        return panel;
    }
}
