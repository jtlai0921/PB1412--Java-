package com.lzw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.Date;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class ListCustomTypeFile extends JFrame {
    /**
     * 自定義擴充名過濾器
     * 
     * @author 李鍾尉
     */
    private final class CustomFilter implements java.io.FileFilter {
        @Override
        public boolean accept(File pathname) {
            // 獲得使用者設定的指定擴充名
            String extName = extNameField.getText();
            if (extName == null || extName.isEmpty())
                return false;
            if (!extName.startsWith("."))// 判斷擴充名前綴
                extName = "." + extName;// 完事擴充名前綴
            extName = extName.toLowerCase();
            // 判斷擴充名與過濾檔案名是否符合要求
            if (pathname.getName().toLowerCase().endsWith(extName))
                return true;
            return false;
        }
    }
    
    private JPanel contentPane;
    private JTextField extNameField;
    private JTable table;
    private File dir;
    private JLabel label;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ListCustomTypeFile frame = new ListCustomTypeFile();
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
    public ListCustomTypeFile() {
        setTitle("顯示指定類型的文件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 93, 54, 0 };
        gbl_panel.rowHeights = new int[] { 23, 0, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);
        
        JButton button = new JButton("選擇文件夾");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.anchor = GridBagConstraints.NORTH;
        gbc_button.gridx = 0;
        gbc_button.gridy = 0;
        panel.add(button, gbc_button);
        
        label = new JLabel("文件夾");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.HORIZONTAL;
        gbc_label.gridx = 1;
        gbc_label.gridy = 0;
        panel.add(label, gbc_label);
        
        JLabel label_1 = new JLabel(
                "輸入指定文件擴展名稱：");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.EAST;
        gbc_label_1.insets = new Insets(0, 0, 0, 5);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 1;
        panel.add(label_1, gbc_label_1);
        
        extNameField = new JTextField();
        extNameField.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                do_extNameField_caretUpdate(e);
            }
        });
        extNameField.setText(".gif");
        GridBagConstraints gbc_extNameField = new GridBagConstraints();
        gbc_extNameField.insets = new Insets(0, 0, 5, 0);
        gbc_extNameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_extNameField.gridx = 1;
        gbc_extNameField.gridy = 1;
        panel.add(extNameField, gbc_extNameField);
        extNameField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
                "文件名稱", "文件大小",
                "修改日期" }) {
            boolean[] columnEditables = new boolean[] { false, false, false };
            
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(220);
        table.getColumnModel().getColumn(1).setPreferredWidth(85);
        table.getColumnModel().getColumn(2).setPreferredWidth(110);
        scrollPane.setViewportView(table);
    }
    
    /**
     * 選擇檔案夾按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        // 設定選擇器的過濾器
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showDialog(this, null);
        dir = chooser.getSelectedFile();
        getLabel().setText(dir.toString());
        // 獲得過濾後的符合條件的檔案陣列
        listFiles();
    }
    
    /**
     * 顯示檔案夾中的檔案
     */
    private void listFiles() {
        if (dir == null)
            return;
        // 獲得符合條件的檔案陣列
        File[] files = dir.listFiles(new CustomFilter());
        // 獲得表格的資料模型
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (File file : files) {// 檢查檔案陣列
            // 建立表格行資料
            Object[] row = { file.getName(), file.length(),
                    new Date(file.lastModified()) };
            model.addRow(row);// 增加行資料到表格模型
        }
    }
    
    protected void do_extNameField_caretUpdate(CaretEvent e) {
        listFiles();
    }
    
    protected JLabel getLabel() {
        return label;
    }
}
