import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class SplitPath extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SplitPath frame = new SplitPath();
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
    public SplitPath() {
        setTitle("�q�r�ꤤ�����ɮ׸��|�B�ɮצW�ΰ��ɦW");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 408, 252);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(5, 5));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(10, 0));
        
        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("����ɮ�");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button, BorderLayout.EAST);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(null, "�ɮ׸�T",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        scrollPane.setOpaque(false);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setOpaque(false);
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        int option = chooser.showOpenDialog(this);// ����ɮ׶}�ҥ�͵���
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();// ��o�ϥΪ̿�ܪ��ɮ�
            String path = file.getAbsolutePath();// ��o�ɮ׵�����|
            textField.setText(path);// ��s���g��T���r��
            int splitIndex = path.lastIndexOf("\\");// �ɮפ��j�ů���
            int typeIndex = path.lastIndexOf(".");// �ɮ׫��A���βů���
            if (typeIndex < 0)
                typeIndex = path.length();
            String filePath = path.substring(0, splitIndex);// �I�����|
            String fileName = path.substring(splitIndex + 1, typeIndex);// �I���ɮצW
            String extName = path.substring(typeIndex);// �I���X�R�W
            textArea.setText("");// �M�Ť�r��
            textArea.append("�ɮצW�١G" + fileName + "\n");// �W�[�ɮצW��T���r��
            textArea.append("�X�R�W�١G" + extName + "\n");// �W�[�X�R�W��T���r��
            textArea.append("�ɮ׸��|�G" + filePath + "\n");// �W�[�ɮ׸��|��T���r��
        }
    }
}
