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
        setTitle("用陣列設定JTable的列名與列寬");
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
            // 定義列名陣列
            String[] columns = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六",
                    "星期日" };
            // 定義列寬陣列
            int[] columnWidth = { 10, 20, 30, 40, 50, 60, 70 };
            // 建立表格資料模型
            DefaultTableModel model = new DefaultTableModel(columns, 15);
            table.setModel(model);// 設定表格資料模型
            TableColumnModel columnModel = table.getColumnModel();// 獲得列模型
            int count = columnModel.getColumnCount();// 獲得列數量
            for (int i = 0; i < count; i++) {// 檢查列
                TableColumn column = columnModel.getColumn(i);// 獲得列對像
                column.setPreferredWidth(columnWidth[i]);// 以陣列元素設定列的寬度
            }
        }
        return table;
    }
}
