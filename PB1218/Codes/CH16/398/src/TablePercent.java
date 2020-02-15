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
        setTitle("在表格中顯示工作進度百分比");// 設定窗體標題
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 470, 300);// 設定窗體位置與大小
        contentPane = new JPanel();// 建立內容面板
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JScrollPane scrollPane = new JScrollPane();// 建立捲動面板
        contentPane.add(scrollPane, BorderLayout.CENTER);// 增加捲動面板到窗體
        table = new JTable();// 建立表格控制項
        table.setModel(new DefaultTableModel(
                new Object[][] {// 設定表格資料模型
                { "油田管理系統登入模塊", "李某", "應用程式", new Integer(93) },
                        { "油田管理系統部門模塊", "張某", "應用程式", new Integer(63) },
                        { "油田管理系統業務模塊", "劉某", "應用程式", new Integer(73) },
                        { "油田管理系統統計模塊", "王某", "應用程式", new Integer(43) },
                        { "油田管理系統登入模塊", "李某", "應用程式", new Integer(93) },
                        { "油田管理系統部門模塊", "張某", "應用程式", new Integer(63) },
                        { "油田管理系統業務模塊", "劉某", "應用程式", new Integer(73) },
                        { "油田管理系統統計模塊", "王某", "應用程式", new Integer(43) },
                        { "油田管理系統登入模塊", "李某", "應用程式", new Integer(93) },
                        { "油田管理系統部門模塊", "張某", "應用程式", new Integer(63) },
                        { "油田管理系統業務模塊", "劉某", "應用程式", new Integer(73) },
                        { "油田管理系統統計模塊", "王某", "應用程式", new Integer(43) },
                        { "油田管理系統報表模塊", "誤某", "應用程式", new Integer(53) } },
                new String[] { "項目名稱", "項目負責人", "項目型態", "開發進度" }));
        table.getColumnModel().getColumn(0).setPreferredWidth(146);// 設定列寬
        TableColumn column = table.getColumnModel().getColumn(3);// 獲得表格第4列對像
        column.setCellRenderer(new TableCellRenderer() {// 設定第4列的著色器
                    @Override
                    public Component getTableCellRendererComponent(
                            JTable table, Object value, boolean isSelected,
                            boolean hasFocus, int row, int column) {
                        if (value instanceof Integer) {// 建立整數著色控制項
                            JProgressBar bar = new JProgressBar();// 建立進度條
                            Integer percent = (Integer) value;// 把目前值轉為整數
                            bar.setValue(percent);// 設定進度條的值
                            bar.setStringPainted(true);// 顯示進度條文字
                            return bar;// 把進度條作為著色控制項
                        } else {
                            return null;
                        }
                    }
                });
        scrollPane.setViewportView(table);// 把表格增加到捲動面板
    }
    
}
