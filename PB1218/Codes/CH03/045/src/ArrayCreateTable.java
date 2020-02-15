import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class ArrayCreateTable extends JFrame {
    
    private JPanel contentPane;
    private JScrollPane scrollPane;
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
                    ArrayCreateTable frame = new ArrayCreateTable();
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
    public ArrayCreateTable() {
        setTitle("�ΰ}�C�]�wJTable���C�W�P�C�e");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 557, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.add(getScrollPane(), BorderLayout.CENTER);
    }
    
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setViewportView(getTable());
        }
        return scrollPane;
    }
    
    private JTable getTable() {
        if (table == null) {
            table = new JTable();
            // �w�q�C�W�}�C
            String[] columns = { "�P���@", "�P���G", "�P���T", "�P���|", "�P����", "�P����",
                    "�P����" };
            // �w�q�C�e�}�C
            int[] columnWidth = { 10, 20, 30, 40, 50, 60, 70 };
            // �إߪ���Ƽҫ�
            DefaultTableModel model = new DefaultTableModel(columns, 15);
            table.setModel(model);// �]�w����Ƽҫ�
            TableColumnModel columnModel = table.getColumnModel();// ��o�C�ҫ�
            int count = columnModel.getColumnCount();// ��o�C�ƶq
            for (int i = 0; i < count; i++) {// �ˬd�C
                TableColumn column = columnModel.getColumn(i);// ��o�C�ﹳ
                column.setPreferredWidth(columnWidth[i]);// �H�}�C�����]�w�C���e��
            }
        }
        return table;
    }
}
