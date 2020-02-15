import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JTable;

public class ClassInfo extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    
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
                    ClassInfo frame = new ClassInfo();
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
    public ClassInfo() {
        setTitle("\u7528List\u96C6\u5408\u4F20\u9012\u5B66\u751F\u4FE1\u606F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 392, 223);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(getTable());
    }
    
    private JTable getTable() {
        if (table == null) {
            table = new JTable();// �إߪ�汱�
            table.setRowHeight(23);// �]�w�氪��
            String[] columns = { "�m�W", "�ʧO", "�X�ͤ��" };// �إߦC�W�}�C
            // �إߪ��ҫ�
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            table.setModel(model);// �]�w���ҫ�
            List<String> students = getStudents();// �I�s��k�ǻ�list���X�ﹳ
            for (String info : students) {// �ˬd�ǥͶ��X�ﹳ
                String[] args = info.split(",");// ��ǥ͸�T������}�C
                model.addRow(args);// ��ǥ͸�T�W�[���檺��
            }
        }
        return table;
    }
    
    private List<String> getStudents() {
        // �إ�List���X�ﹳ
        List<String> list = new ArrayList<String>();
        list.add("����,�k,1981-1-1");// �W�[��ƨ춰�X�ﹳ
        list.add("�p��,�k,1981-1-1");
        list.add("�p�B,�k,1981-1-1");
        list.add("�p�i,�k,1981-1-1");
        list.add("�p��,�k,1981-1-1");
        list.add("�p�f,�k,1981-1-1");
        return list;
    }
}
