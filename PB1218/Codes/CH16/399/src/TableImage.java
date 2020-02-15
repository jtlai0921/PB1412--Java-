import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.UIManager;

public class TableImage extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TableImage frame = new TableImage();
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
    public TableImage() {
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
        ImageIcon[] icons = new ImageIcon[12];
        for (int i = 0; i < icons.length; i++) {
            icons[i] = new ImageIcon(getClass().getResource(
                    "/res/" + (i + 1) + ".png"));
        }
        table.setModel(new DefaultTableModel(
                new Object[][]
                {// �]�w����Ƽҫ�
                { icons[0], "�o�к޲z�t�γ����Ҷ�", "���Y", "���ε{��" },
                        { icons[0], "�o�к޲z�t�γ����Ҷ�", "�i�Y", "���ε{��" },
                        { icons[1], "�o�к޲z�t�η~�ȼҶ�", "�B�Y", "���ε{��" },
                        { icons[2], "�o�к޲z�t�βέp�Ҷ�", "���Y", "���ε{��" },
                        { icons[3], "�o�к޲z�t�εn�J�Ҷ�", "���Y", "���ε{��" },
                        { icons[4], "�o�к޲z�t�γ����Ҷ�", "�i�Y", "���ε{��" },
                        { icons[5], "�o�к޲z�t�η~�ȼҶ�", "�B�Y", "���ε{��" },
                        { icons[6], "�o�к޲z�t�βέp�Ҷ�", "���Y", "���ε{��" },
                        { icons[7], "�o�к޲z�t�εn�J�Ҷ�", "���Y", "���ε{��" },
                        { icons[8], "�o�к޲z�t�γ����Ҷ�", "�i�Y", "���ε{��" },
                        { icons[9], "�o�к޲z�t�η~�ȼҶ�", "�B�Y", "���ε{��" },
                        { icons[10], "�o�к޲z�t�βέp�Ҷ�", "���Y", "���ε{��" },
                        { icons[11], "�o�к޲z�t�γ���Ҷ�", "�~�Y", "���ε{��" } },
                new String[]
                { "�Ҷ��лx", "���ئW��", "���حt�d�H", "���ث��A" }));
        table.getColumnModel().getColumn(1).setPreferredWidth(146);// �]�w�C�e
        TableColumn column = table.getColumnModel().getColumn(0);// ��o����4�C�ﹳ
        table.setRowHeight(32);
        column.setCellRenderer(new TableCellRenderer() {// �]�w��4�C���ۦ⾹
                    @Override
                    public Component getTableCellRendererComponent(
                            JTable table, Object value, boolean isSelected,
                            boolean hasFocus, int row, int column) {
                        ImageIcon icon = (ImageIcon) value;
                        JLabel label = new JLabel(icon);// �إ߶i�ױ�
                        label.setBackground(table.getSelectionBackground());
                        if (isSelected)// ���ܪ����ҳ]�w�����z��
                            label.setOpaque(true);
                        return label;// ��i�ױ��@���ۦⱱ�
                    }
                });
        scrollPane.setViewportView(table);// ����W�[�챲�ʭ��O
    }
}
