import java.awt.EventQueue;
import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.io.*;

public class UniteFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField savePathtextField;
    private JList fileList;
    Vector<String> vector = new Vector<String>();
    DefaultListModel list = new DefaultListModel();
    List<File> listFile = new ArrayList<File>();
   
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UniteFrame frame = new UniteFrame();
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
    public UniteFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("�X��txt�ɮ�");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton choiceButton = new JButton("��ܦX���ɮ�");
        choiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_choiceButton_actionPerformed(arg0);
            }
        });
        choiceButton.setBounds(22, 36, 114, 23);
        panel.add(choiceButton);
        
        JButton saveButton = new JButton("�x�s�a�}");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_saveButton_actionPerformed(arg0);
            }
        });
        saveButton.setBounds(22, 187, 114, 23);
        panel.add(saveButton);
        
        savePathtextField = new JTextField();
        savePathtextField.setBounds(152, 188, 228, 21);
        panel.add(savePathtextField);
        savePathtextField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(152, 36, 228, 129);
        panel.add(scrollPane);
        
        fileList = new JList(list);
        
        scrollPane.setViewportView(fileList);
        
        JButton submitbutton = new JButton("�T�w�X��");
        submitbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        submitbutton.setBounds(102, 229, 114, 23);
        panel.add(submitbutton);
    }
    
    protected void do_choiceButton_actionPerformed(ActionEvent arg0) {
        java.awt.FileDialog fd = new FileDialog(this); // �إ߿���ɮץ�͵���
        fd.setVisible(true); // �]�w���鬰�i�����A
        String filePath = fd.getDirectory() + fd.getFile(); // ��o�ϥΪ̿�ܪ��ɮ׸��|
        if (filePath.endsWith(".txt")) { // �P�_�ϥΪ̿�ܪ��O�_��txt�ɮ�
            list.addElement(fd.getDirectory() + fd.getFile()); // �N�ϥΪ̿�ܪ��ɮ׼W�[��C��
            listFile.add(new File((fd.getDirectory() + fd.getFile()))); // �N�ϥΪ̿�ܪ��ɮצW�W�[�춰�X�ﹳ��
        }
    }
    
    protected void do_saveButton_actionPerformed(ActionEvent arg0) {
        FileDialog saveDialog = new FileDialog(this, "�x�s�ɮץ�͵���", FileDialog.SAVE);
        saveDialog.setVisible(true);
        if (saveDialog.getDirectory() + saveDialog.getFile() != null) {
            savePathtextField.setText(saveDialog.getDirectory()
                    + saveDialog.getFile());
        }
    }
    
    protected void do_button_actionPerformed(ActionEvent arg0) {
        UniteFile unitFile = new UniteFile(); // �إ�UniteFile�ﹳ
        unitFile.writeFiles(listFile, savePathtextField.getText());// �I�s�X���ɮפ�k
        JOptionPane.showMessageDialog(getContentPane(), "�ɮצX�֦��\�I", "��T���ܮ�",
                JOptionPane.WARNING_MESSAGE); // ���ϥΪ̴��Ѵ��ܸ�T��͵���
    }
    
}
