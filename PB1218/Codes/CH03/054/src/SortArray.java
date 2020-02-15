import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SortArray extends JFrame {
    
    private JPanel contentPane;
    private JTextField arrayField;
    private JTextArea sortArea;
    
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
                    SortArray frame = new SortArray();
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
    public SortArray() {
        setTitle("��sort�Ƨǰ}�C");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel(
                "��J���e�A�H�Ů���j");
        label.setBounds(6, 6, 265, 18);
        contentPane.add(label);
        
        arrayField = new JTextField();
        arrayField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            }
            
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                String mask = "0123456789 " + (char) 8;
                if (mask.indexOf(key) == -1) {
                    e.consume();
                }
            }
            
        });
        arrayField.setBounds(6, 36, 422, 30);
        contentPane.add(arrayField);
        arrayField.setColumns(10);
        
        JButton button = new JButton("\u6392\u5E8F");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(164, 78, 90, 30);
        contentPane.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 118, 422, 138);
        contentPane.add(scrollPane);
        
        sortArea = new JTextArea();
        sortArea.setLineWrap(true);
        scrollPane.setViewportView(sortArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String text = arrayField.getText();// ��o�ϥΪ̿�J
        String[] arrayStr = text.split(" {1,}");// �����J���}�C
        int[] array = new int[arrayStr.length];// �إ߾�ƫ��A�}�C
        sortArea.setText("�}�C�즳���e�G\n");
        for (String string : arrayStr) {// ��X�즳�}�C���e
            sortArea.append(string + "    ");
        }
        for (int i = 0; i < array.length; i++) {// ��l�ƾ�ΰ}�C
            array[i] = Integer.parseInt(arrayStr[i]);
        }
        sortArea.append("\n");
        Arrays.sort(array);// �ϥ�sort��k���ΰ}�C�i��Ƨ�
        sortArea.append("�}�C�Ƨǫ᪺���e�G\n");
        for (int value : array) {// ��X�Ƨǫ᪺�}�C���e
            sortArea.append(value + "    ");
        }
    }
    
    protected void do_arrayField_keyPressed(KeyEvent e) {
        char key = e.getKeyChar();// ��o�ϥΪ̫���r��
        String mask = "0123456789 " + (char) 8;// �w�q�W�d�Ʀr�żҪO
        if (mask.indexOf(key) == -1) {// �P�_����r�ŬO�_�ݩ�W�d�Ʀr�Žd��
            e.consume();// �����D�W�d�Ʀr�Ū���J���ĩ�
        }
    }
}
