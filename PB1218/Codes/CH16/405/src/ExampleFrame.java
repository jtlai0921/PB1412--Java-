import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class ExampleFrame extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    
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
                    ExampleFrame frame = new ExampleFrame();
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
    public ExampleFrame() {
        // 為窗體增加開啟事件監聽器
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);// 呼叫窗體開啟事件處理方法
            }
        });
        setTitle("動態載入表格資料");// 設定窗體標題
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);// 設定窗體大小
        contentPane = new JPanel();// 建立內容面板
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JScrollPane scrollPane = new JScrollPane();// 建立捲動面板
        contentPane.add(scrollPane, BorderLayout.CENTER);
        table = new JTable();// 建立表格控制項
        model = new DefaultTableModel(new Object[][] {}, new String[]
            { "學號", "衛生分數", "生活分數" });// 建立預設的表格資料模型
        table.setModel(model);// 設定表格資料模型
        scrollPane.setViewportView(table);// 把表格增加到捲動面板檢視
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        // 建立Timer控制項
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();// 建立隨機數對像
                Integer[] values = new Integer[]
                    // 建立整數陣列作為表格行資料
                    { random.nextInt(100), random.nextInt(100),
                            random.nextInt(100) };
                model.addRow(values);// 為表格資料模型增加一行資料
            }
        });
        timer.start();// 啟動Timer控制項
    }
}
