import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.UIManager;
import java.awt.Color;

public class ArrayExample extends JFrame {
    
    private JPanel contentPane;
    private JTextField nameField;
    private JTextArea personnelArea;
    private JTextArea resultArea;
    
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
                    ArrayExample frame = new ArrayExample();
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
    public ArrayExample() {
        setTitle("�Q�ΰ}�C������B�[��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 498, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel
                .setBorder(new TitledBorder(
                        null,
                        "��J�{�b�[��",
                        TitledBorder.LEADING, TitledBorder.TOP, null,
                        new Color(59, 59, 59)));
        panel.setBounds(10, 10, 174, 242);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 5));
        
        nameField = new JTextField();
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                do_textField_keyPressed(e);
            }
        });
        panel.add(nameField, BorderLayout.NORTH);
        nameField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);
        
        personnelArea = new JTextArea();
        personnelArea.setEditable(false);
        scrollPane.setViewportView(personnelArea);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null,
                "����[���H��",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
                        59)));
        panel_1.setBounds(183, 10, 219, 242);
        contentPane.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane_1 = new JScrollPane();
        panel_1.add(scrollPane_1);
        
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        scrollPane_1.setViewportView(resultArea);
        
        JButton button = new JButton("���");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(407, 164, 63, 25);
        contentPane.add(button);
        
        JButton button_1 = new JButton("���}");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(407, 215, 63, 25);
        contentPane.add(button_1);
    }
    
    protected void do_textField_keyPressed(KeyEvent e) {
        if (e.getKeyChar() != '\n')// ���O�T�{�r�Ť����B�z
            return;
        String name = nameField.getText();
        if (name.isEmpty())// �p�G��r�بS���r�ꤣ���B�z
            return;
        personnelArea.append(name + "\n");// ���J�H�W�P�T�{�żW�[��H���C��
        nameField.selectAll();// ��ܤ�r�ةҦ��r��
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String perstring = personnelArea.getText();// ��o�H���C���r
        String[] personnelArray = perstring.split("\n{1,}");// ��o�H���}�C
        int index = (int) (Math.random() * personnelArray.length);// �����H���}�C����
        // �w�q�]�t�榡�Ѽƪ�������T
        String formatArg = "��������[���H���G\n\t%1$s\n����%1$s���������[��������j���o�D�C"
                + "\n\n�ڭ̱N��%1$s�{�o�G\n\t�L�����ĥ��G�Q�c�C";
        // ��������T�W�[�H���Ѽ�
        String info = String.format(formatArg, personnelArray[index]);
        resultArea.setText(info);// �b��r����ܤ�����T
    }
    
    protected void do_button_1_actionPerformed(ActionEvent e) {
        dispose();
    }
}
