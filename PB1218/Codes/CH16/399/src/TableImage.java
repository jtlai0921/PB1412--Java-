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
        ImageIcon[] icons = new ImageIcon[12];
        for (int i = 0; i < icons.length; i++) {
            icons[i] = new ImageIcon(getClass().getResource(
                    "/res/" + (i + 1) + ".png"));
        }
        table.setModel(new DefaultTableModel(
                new Object[][]
                {// 設定表格資料模型
                { icons[0], "油田管理系統部門模塊", "李某", "應用程式" },
                        { icons[0], "油田管理系統部門模塊", "張某", "應用程式" },
                        { icons[1], "油田管理系統業務模塊", "劉某", "應用程式" },
                        { icons[2], "油田管理系統統計模塊", "王某", "應用程式" },
                        { icons[3], "油田管理系統登入模塊", "李某", "應用程式" },
                        { icons[4], "油田管理系統部門模塊", "張某", "應用程式" },
                        { icons[5], "油田管理系統業務模塊", "劉某", "應用程式" },
                        { icons[6], "油田管理系統統計模塊", "王某", "應用程式" },
                        { icons[7], "油田管理系統登入模塊", "李某", "應用程式" },
                        { icons[8], "油田管理系統部門模塊", "張某", "應用程式" },
                        { icons[9], "油田管理系統業務模塊", "劉某", "應用程式" },
                        { icons[10], "油田管理系統統計模塊", "王某", "應用程式" },
                        { icons[11], "油田管理系統報表模塊", "誤某", "應用程式" } },
                new String[]
                { "模塊標誌", "項目名稱", "項目負責人", "項目型態" }));
        table.getColumnModel().getColumn(1).setPreferredWidth(146);// 設定列寬
        TableColumn column = table.getColumnModel().getColumn(0);// 獲得表格第4列對像
        table.setRowHeight(32);
        column.setCellRenderer(new TableCellRenderer() {// 設定第4列的著色器
                    @Override
                    public Component getTableCellRendererComponent(
                            JTable table, Object value, boolean isSelected,
                            boolean hasFocus, int row, int column) {
                        ImageIcon icon = (ImageIcon) value;
                        JLabel label = new JLabel(icon);// 建立進度條
                        label.setBackground(table.getSelectionBackground());
                        if (isSelected)// 把選擇的標籤設定為不透明
                            label.setOpaque(true);
                        return label;// 把進度條作為著色控制項
                    }
                });
        scrollPane.setViewportView(table);// 把表格增加到捲動面板
    }
}
