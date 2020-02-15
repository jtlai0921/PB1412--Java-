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
            table = new JTable();// 建立表格控制項
            table.setRowHeight(23);// 設定行高度
            String[] columns = { "姓名", "性別", "出生日期" };// 建立列名陣列
            // 建立表格模型
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            table.setModel(model);// 設定表格模型
            List<String> students = getStudents();// 呼叫方法傳遞list集合對像
            for (String info : students) {// 檢查學生集合對像
                String[] args = info.split(",");// 把學生資訊拆分為陣列
                model.addRow(args);// 把學生資訊增加到表格的行
            }
        }
        return table;
    }
    
    private List<String> getStudents() {
        // 建立List集合對像
        List<String> list = new ArrayList<String>();
        list.add("李哥,男,1981-1-1");// 增加資料到集合對像
        list.add("小陳,女,1981-1-1");
        list.add("小劉,男,1981-1-1");
        list.add("小張,男,1981-1-1");
        list.add("小董,男,1981-1-1");
        list.add("小呂,男,1981-1-1");
        return list;
    }
}
