import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ModalDialog extends JFrame {
    
    private final JPanel contentPanel = new JPanel();
    
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
        try {
            ModalDialog dialog = new ModalDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Create the dialog.
     */
    public ModalDialog() {
        setTitle("�ҺA��ܮػP�D�ҺA��ܮ�");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        JButton button = new JButton(
                "�ҺA��ܹ�ܮ�");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(103, 64, 206, 30);
        contentPanel.add(button);
        
        JButton button_1 = new JButton(
                "�D�ҺA��ܹ�ܮ�");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(103, 106, 206, 30);
        contentPanel.add(button_1);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("�T�w");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("����");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog(this);// �إߥثe���骺��͵���
        dialog.setModal(true);// �]�w��͵������ҺA
        dialog.setSize(300, 200);// �]�w��͵����j�p
        dialog.setLocationByPlatform(true);// �Ѩt�Υ��x�G�m�����m
        dialog.setTitle("�ҺA��͵���");// ��͵������D
        dialog.setVisible(true);// ��ܥ�͵���
    }
    
    protected void do_button_1_actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog(this);// �إߥثe���骺��͵���
        dialog.setModal(false);// �]�w��͵������ҺA
        dialog.setSize(300, 200);// �]�w��͵����j�p
        dialog.setLocationByPlatform(true);// �Ѩt�Υ��x�G�m�����m
        dialog.setTitle("�D�ҺA��͵���");// ��͵������D
        dialog.setVisible(true);// ��ܥ�͵���
    }
}
