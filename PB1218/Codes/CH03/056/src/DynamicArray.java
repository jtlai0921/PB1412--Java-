import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class DynamicArray extends JFrame {
    
    private JPanel contentPane;
    private final JPanel panel = new JPanel();
    
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
                    DynamicArray frame = new DynamicArray();
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
    public DynamicArray() {
        setTitle("�ΰʺA�}�C�O�s�ǥͩm�W");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 337, 269);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        list = new JList();
        scrollPane.setViewportView(list);
        
        JPanel panel_1 = new JPanel();
        scrollPane.setColumnHeaderView(panel_1);
        
        JLabel label = new JLabel("�ǥͩm�W");
        panel_1.add(label);
        
        textField = new JTextField();
        panel_1.add(textField);
        textField.setColumns(10);
        panel.setPreferredSize(new Dimension(100, 10));
        contentPane.add(panel, BorderLayout.EAST);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton button = new JButton("�[�ǥ�");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        panel.add(button);
        
        JButton button_1 = new JButton("�R�ǥ�");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        panel.add(button_1);
    }
    
    private ArrayList<String> arraylist = new ArrayList<String>();
    private JTextField textField;
    private JList list;
    
    protected void do_button_actionPerformed(ActionEvent e) {
        textField.requestFocusInWindow();
        textField.selectAll();// ��ܤ�r�ؤ�r�ǳƤU����J
        String text = textField.getText();// ��o�ϥΪ̿�J�m�W
        if (text.isEmpty())// �L�o����J�m�W�����p
            return;
        arraylist.add(text);// ��m�W�W�[��}�C���X��
        replaceModel();// ��}�C���X�����e��ܨ�ɭ��C�����
    }
    
    protected void do_button_1_actionPerformed(ActionEvent e) {
        Object value = list.getSelectedValue();// ��o�C�������ܶ�
        arraylist.remove(value);// �q�}�C���X�������ϥΪ̪���ܶ�
        replaceModel();// ��}�C���X�����e��ܨ�ɭ��C�����
    }
    
    private void replaceModel() {
        // ���C����]�w��Ƽҫ���ܰ}�C���X�������
        list.setModel(new AbstractListModel() {
            @Override
            public int getSize() {// ��o�}�C�j�p
                return arraylist.size();
            }
            
            @Override
            public Object getElementAt(int index) {// ��o���w���ޤ���
                return arraylist.get(index);
            }
        });
    }
}
