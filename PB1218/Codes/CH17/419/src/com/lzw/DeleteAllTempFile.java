package com.lzw;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DeleteAllTempFile extends JFrame {
    
    private JPanel contentPane;
    private JTable table;
    private JList driverList;
    private SearchThread searchThread;
    private JProgressBar progressBar;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteAllTempFile frame = new DeleteAllTempFile();
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
    public DeleteAllTempFile() {
        setTitle("刪除磁盤所有.tmp臨時文件");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 561, 339);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        driverList = new JList();
        driverList.setPreferredSize(new Dimension(130, 0));
        driverList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
                null, null));
        contentPane.add(driverList, BorderLayout.WEST);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
                null, null));
        contentPane.add(scrollPane, BorderLayout.CENTER);
        table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
                "文件名稱", "文件路徑",
                "文件大小", "處理結果" }) {
            boolean[] columnEditables = new boolean[] { false, false, true,
                    true };
            
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(111);
        scrollPane.setViewportView(table);
        
        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setHgap(20);
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton searchButton = new JButton("搜索");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_searchButton_actionPerformed(e);
            }
        });
        
        JPanel panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(270, 22));
        panel.add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        panel_1.add(progressBar);
        panel.add(searchButton);
        
        JButton clearButton = new JButton("清理");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_clearButton_actionPerformed(e);
            }
        });
        panel.add(clearButton);
    }
    
    /**
     * 窗體啟動的事件處理方法
     * 
     * @param e
     */
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultListModel model = new DefaultListModel();
        File[] roots = File.listRoots();// 獲得計算機磁碟列表
        for (File file : roots) {// 檢查磁碟列表
            model.addElement(file);// 增加磁碟到JList控制項的模型
        }
        driverList.setModel(model);// 設定列表控制項的模型
    }
    
    /**
     * 搜索按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_searchButton_actionPerformed(ActionEvent e) {
        // 獲得使用者在列表控制項選擇的磁碟對像
        final File driver = (File) driverList.getSelectedValue();
        if (searchThread != null) {// 如果搜索線程已經初始化
            searchThread.setSearching(false);// 停止該線程
        }
        // 獲得表格對象的資料模型
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        // 建立新的搜索線程
        searchThread = new SearchThread(driver, model, progressBar);
        searchThread.start();// 啟動搜索線程
    }
    
    /**
     * 清除按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_clearButton_actionPerformed(ActionEvent e) {
        // 獲得表格控制項的資料模型
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();// 獲得模型中表格資料的行數
        for (int i = 0; i < rowCount; i++) {// 變數模型指定行數的資料
            File file = (File) model.getValueAt(i, 1);// 獲得指定行的檔案對像
            if (file.exists())// 判斷檔案存在
                file.delete();// 刪除tmp臨時檔案
            model.setValueAt("處理完成", i, 3);// 更新模型中對該檔案的處理結果
        }
    }
}
