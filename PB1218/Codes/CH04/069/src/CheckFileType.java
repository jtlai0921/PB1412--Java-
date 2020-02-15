import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CheckFileType extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    CheckFileType frame = new CheckFileType();
                    frame.setVisible(true);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Create the frame.
     */
    public CheckFileType() {
        setTitle("�ɮ�����");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 501, 143);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("����ɮ�");
        label.setBounds(10, 10, 84, 15);
        contentPane.add(label);
        
        textField = new JTextField();
        textField.setBounds(88, 2, 289, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("�s��");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(389, 2, 90, 30);
        contentPane.add(button);
        
        textArea = new JTextArea();
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setBounds(83, 37, 396, 60);
        contentPane.add(textArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        Scanner scan = new Scanner(getClass()// ��o�����ɮת����˾�
                .getResourceAsStream("extName.inf"));
        JFileChooser chooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        boolean searched = false;
        int option = chooser.showOpenDialog(this);// �}���ɮ׿�ܥ�͵���
        if (option == JFileChooser.APPROVE_OPTION) {// �p�G���T����ɮ�
            File file = chooser.getSelectedFile();// ��o�ϥΪ̿���ɮ�
            textField.setText(file.getName());// ���ɮצW�W�[���r��
            String name = file.getName();// ��o�ɮצW
            while (scan.hasNextLine()) {// �ˬd�����ɮ�
                String line = scan.nextLine();// ��o�@�满����T
                String[] extInfo = line.split("\t");// ���满����T������}�C
                // �}�C�Ĥ@�Ӥ����O�ɮ��X�R�W�A�P�ϥΪ̿���ɮצW���
                if (name.endsWith(extInfo[0])) {
                    // �ĤG�Ӱ}�C�����O�ɮ׫��A��������T�A�W�[���r�챱���
                    textArea.setText(extInfo[1]);
                    searched = true;
                }
            }
            scan.close();// �������˾�
        }
        if (!searched) {// �p�G�S�������ɮ׫��A�������A�h���ܨϥΪ�
            textArea.setText("�A��ܪ��ɮ׫��A�S�������O���A�A�i�H�bextName.info�ɮפ��W�[�ӫ��A���y�z�C");
        }
    }
}
