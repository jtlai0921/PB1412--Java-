package com.mingrisoft.jtable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SortedTable extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2215793712885732497L;
    private JPanel contentPane;
    private JTable table;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SortedTable frame = new SortedTable();
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
    public SortedTable() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("支持排序功能的表格");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
        table.setRowHeight(35);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        scrollPane.setViewportView(table);
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[] { "顏色名稱", "顏色" });
        model.addRow(new Object[] { "黑色", Color.BLACK });
        model.addRow(new Object[] { "藍色", Color.BLUE });
        model.addRow(new Object[] { "灰色", Color.GRAY });
        model.addRow(new Object[] { "綠色", Color.GREEN });
        model.addRow(new Object[] { "橙色", Color.ORANGE });
        model.addRow(new Object[] { "粉色", Color.PINK });
        model.addRow(new Object[] { "紅色", Color.RED });
        model.addRow(new Object[] { "白色", Color.WHITE });
        model.addRow(new Object[] { "黃色", Color.YELLOW });
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        sorter.setComparator(1, new Comparator<Color>() {
            
            @Override
            public int compare(Color o1, Color o2) {
                int r = o1.getRed() - o2.getRed();
                int g = o1.getGreen() - o2.getGreen();
                int b = o1.getBlue() - o2.getBlue();
                if (r != 0) {
                    return r;
                } else if (g != 0) {
                    return g;
                } else {
                    return b;
                }
            }
        });
        table.setRowSorter(sorter);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
    }
}
