import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.UIManager;

public class TablePercent extends JFrame {
    
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
                    TablePercent frame = new TablePercent();
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
    public TablePercent() {
        setTitle("�b��椤��ܤu�@�i�צʤ���");// �]�w������D
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 470, 300);// �]�w�����m�P�j�p
        contentPane = new JPanel();// �إߤ��e���O
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JScrollPane scrollPane = new JScrollPane();// �إ߱��ʭ��O
        contentPane.add(scrollPane, BorderLayout.CENTER);// �W�[���ʭ��O�쵡��
        table = new JTable();// �إߪ�汱�
        table.setModel(new DefaultTableModel(
                new Object[][] {// �]�w����Ƽҫ�
                { "�o�к޲z�t�εn�J�Ҷ�", "���Y", "���ε{��", new Integer(93) },
                        { "�o�к޲z�t�γ����Ҷ�", "�i�Y", "���ε{��", new Integer(63) },
                        { "�o�к޲z�t�η~�ȼҶ�", "�B�Y", "���ε{��", new Integer(73) },
                        { "�o�к޲z�t�βέp�Ҷ�", "���Y", "���ε{��", new Integer(43) },
                        { "�o�к޲z�t�εn�J�Ҷ�", "���Y", "���ε{��", new Integer(93) },
                        { "�o�к޲z�t�γ����Ҷ�", "�i�Y", "���ε{��", new Integer(63) },
                        { "�o�к޲z�t�η~�ȼҶ�", "�B�Y", "���ε{��", new Integer(73) },
                        { "�o�к޲z�t�βέp�Ҷ�", "���Y", "���ε{��", new Integer(43) },
                        { "�o�к޲z�t�εn�J�Ҷ�", "���Y", "���ε{��", new Integer(93) },
                        { "�o�к޲z�t�γ����Ҷ�", "�i�Y", "���ε{��", new Integer(63) },
                        { "�o�к޲z�t�η~�ȼҶ�", "�B�Y", "���ε{��", new Integer(73) },
                        { "�o�к޲z�t�βέp�Ҷ�", "���Y", "���ε{��", new Integer(43) },
                        { "�o�к޲z�t�γ���Ҷ�", "�~�Y", "���ε{��", new Integer(53) } },
                new String[] { "���ئW��", "���حt�d�H", "���ث��A", "�}�o�i��" }));
        table.getColumnModel().getColumn(0).setPreferredWidth(146);// �]�w�C�e
        TableColumn column = table.getColumnModel().getColumn(3);// ��o����4�C�ﹳ
        column.setCellRenderer(new TableCellRenderer() {// �]�w��4�C���ۦ⾹
                    @Override
                    public Component getTableCellRendererComponent(
                            JTable table, Object value, boolean isSelected,
                            boolean hasFocus, int row, int column) {
                        if (value instanceof Integer) {// �إ߾�Ƶۦⱱ�
                            JProgressBar bar = new JProgressBar();// �إ߶i�ױ�
                            Integer percent = (Integer) value;// ��ثe���ର���
                            bar.setValue(percent);// �]�w�i�ױ�����
                            bar.setStringPainted(true);// ��ܶi�ױ���r
                            return bar;// ��i�ױ��@���ۦⱱ�
                        } else {
                            return null;
                        }
                    }
                });
        scrollPane.setViewportView(table);// ����W�[�챲�ʭ��O
    }
    
}
