import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class EnctryAndUnEntryFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField entryTextField;
    private JTextField saveTextField;
    private JTextField unentryTextField;
    private JTextField unsaveTextField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EnctryAndUnEntryFrame frame = new EnctryAndUnEntryFrame();
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
    public EnctryAndUnEntryFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 247);
        setTitle("�ɮ�²��[�K�ѱK");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 434, 218);
        contentPane.add(tabbedPane);
        JPanel untryPanene = new JPanel();
        tabbedPane.addTab("�ѱK���O", null, untryPanene, null);
        untryPanene.setLayout(null);
        JPanel entryPanel = new JPanel();
        tabbedPane.addTab("�[�K���O", null, entryPanel, null);
        entryPanel.setLayout(null);
        JLabel entryLabel = new JLabel("�n�[�K���ɮסG");
        entryLabel.setBounds(10, 39, 100, 15);
        entryPanel.add(entryLabel);
        
        entryTextField = new JTextField();
        entryTextField.setBounds(115, 36, 168, 21);
        entryPanel.add(entryTextField);
        entryTextField.setColumns(10);
        
        JButton entryButton = new JButton("���");
        entryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_entryButton_actionPerformed(arg0);
            }
        });
        entryButton.setBounds(293, 31, 69, 23);
        entryPanel.add(entryButton);
        
        JLabel saveLabel = new JLabel("�O �s �a �} �G");
        saveLabel.setBounds(10, 84, 100, 15);
        entryPanel.add(saveLabel);
        
        saveTextField = new JTextField();
        saveTextField.setColumns(10);
        saveTextField.setBounds(115, 81, 168, 21);
        entryPanel.add(saveTextField);
        
        JButton saveButton = new JButton("���");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_saveButton_actionPerformed(arg0);
            }
        });
        saveButton.setBounds(293, 80, 69, 23);
        entryPanel.add(saveButton);
        
        JButton confirmButton = new JButton("�T�{�[�K");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_confirmButton_actionPerformed(arg0);
            }
        });
        confirmButton.setBounds(152, 132, 101, 23);
        entryPanel.add(confirmButton);
        JLabel unentryLabel = new JLabel("�n�ѱK���ɮסG");
        unentryLabel.setBounds(10, 39, 100, 15);
        untryPanene.add(unentryLabel);
        
        unentryTextField = new JTextField();
        unentryTextField.setBounds(115, 36, 168, 21);
        untryPanene.add(unentryTextField);
        unentryTextField.setColumns(10);
        
        JButton unentryButton = new JButton("���");
        unentryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                undo_entryButton_actionPerformed(arg0);
            }
        });
        unentryButton.setBounds(293, 31, 69, 23);
        untryPanene.add(unentryButton);
        
        JLabel unsaveLabel = new JLabel("�O �s �a �} �G");
        unsaveLabel.setBounds(10, 84, 100, 15);
        untryPanene.add(unsaveLabel);
        
        unsaveTextField = new JTextField();
        unsaveTextField.setColumns(10);
        unsaveTextField.setBounds(115, 81, 168, 21);
        untryPanene.add(unsaveTextField);
        
        JButton unsaveButton = new JButton("���");
        unsaveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                undo_saveButton_actionPerformed(arg0);
            }
        });
        unsaveButton.setBounds(293, 80, 69, 23);
        untryPanene.add(unsaveButton);
        
        JButton unconfirmButton = new JButton("�T�{�ѱK");
        unconfirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                undo_confirmButton_actionPerformed(arg0);
            }
        });
        unconfirmButton.setBounds(152, 132, 101, 23);
        untryPanene.add(unconfirmButton);
        
    }
    
    // ��ܭn�[�K�ɮ׫��s�������ƥ�
    protected void do_entryButton_actionPerformed(ActionEvent arg0) {
        java.awt.FileDialog fd = new FileDialog(this);
        fd.setVisible(true);
        String filePath = fd.getDirectory() + fd.getFile();
        if (!filePath.equals("") && !(filePath == null)) {
            entryTextField.setText(filePath);
        }
        
    }
    
    // ��ܥ[�K���ɮת��x�s�a�}���s�������ƥ�
    protected void do_saveButton_actionPerformed(ActionEvent arg0) {
        FileDialog saveDialog = new FileDialog(this, "�x�s�ɮץ�͵���", FileDialog.SAVE);
        saveDialog.setVisible(true);
        String filePath = saveDialog.getDirectory() + saveDialog.getFile();
        if (!filePath.equals("") && !(filePath == null)) {
            saveTextField.setText(filePath);
        }
    }
    
    // �T�w�[�K���s�����ƥ�
    
protected void do_confirmButton_actionPerformed(ActionEvent arg0) {
    EncryptFile encryFile = new EncryptFile();  //�إ��x�s���ɮץ[�K��k�����O�ﹳ
    encryFile.encry(entryTextField.getText(), saveTextField.getText()); //�I�s���ɮ׶i��[�K��k
    JOptionPane.showMessageDialog(getContentPane(), "�ɮץ[�K���\�I", "��T���ܮ�",
            JOptionPane.WARNING_MESSAGE); // ���ϥΪ̴��Ѵ��ܸ�T��͵���
}
    
    // ��ܭn�ѱK�ɮ׫��s�������ƥ�
    protected void undo_entryButton_actionPerformed(ActionEvent arg0) {
        FileDialog saveDialog = new FileDialog(this, "�x�s�ɮץ�͵���", FileDialog.SAVE);
        saveDialog.setVisible(true);
        String filePath = saveDialog.getDirectory() + saveDialog.getFile();
        unentryTextField.setText(filePath);
    }
    
    // ��ܸѱK���ɮת��x�s�a�}���s�������ƥ�
    protected void undo_saveButton_actionPerformed(ActionEvent arg0) {
        FileDialog saveDialog = new FileDialog(this, "�x�s�ɮץ�͵���", FileDialog.SAVE);
        saveDialog.setVisible(true);
        String filePath = saveDialog.getDirectory() + saveDialog.getFile();
        unsaveTextField.setText(filePath);
    }
    
    // �T�w�ѱK���s�����ƥ�
    protected void undo_confirmButton_actionPerformed(ActionEvent arg0) {
        EncryptFile encryFile = new EncryptFile();
        encryFile
                .unEncry(unentryTextField.getText(), unsaveTextField.getText());
        JOptionPane.showMessageDialog(getContentPane(), "�ɮ׸ѱK���\�I", "��T���ܮ�",
                JOptionPane.WARNING_MESSAGE); // ���ϥΪ̴��Ѵ��ܸ�T��͵���
    }
    
}
