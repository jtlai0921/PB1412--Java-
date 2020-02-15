package com.lzw;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * 獲得檔案列表的過濾器
 * 
 * @author 李鍾尉
 */
public class RenameFiles extends JFrame {
    
    private final class ExtNameFileFilter implements FileFilter {
        private String extName;
        
        public ExtNameFileFilter(String extName) {
            this.extName = extName;// 儲存檔案擴充名
        }
        
        @Override
        public boolean accept(File pathname) {
            // 過濾檔案擴充名
            if (pathname.getName().toUpperCase()
                    .endsWith(extName.toUpperCase()))
                return true;
            return false;
        }
    }
    
    private JPanel contentPane;
    private JTextField forderField;
    private JTextField templetField;
    private File dir;
    private JTable table;
    private JTextField extNameField;
    private JSpinner startSpinner;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RenameFiles frame = new RenameFiles();
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
    public RenameFiles() {
        setResizable(false);
        setTitle("文件批量重命名");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 383, 409);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 72, 54, 60, 87, 91, 0 };
        gbl_contentPane.rowHeights = new int[] { 25, 25, 10, 25, 24, 25, 2,
                216, 0 };
        gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
                Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);
        
        JLabel label = new JLabel();
        label.setText("檔案批次重命名模塊：");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.VERTICAL;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridwidth = 3;
        gbc_label.gridx = 1;
        gbc_label.gridy = 0;
        contentPane.add(label, gbc_label);
        
        JLabel label_1 = new JLabel();
        label_1.setText("檔案路徑：");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.EAST;
        gbc_label_1.fill = GridBagConstraints.VERTICAL;
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 1;
        contentPane.add(label_1, gbc_label_1);
        
        forderField = new JTextField();
        forderField.setText("");
        GridBagConstraints gbc_forderField = new GridBagConstraints();
        gbc_forderField.fill = GridBagConstraints.HORIZONTAL;
        gbc_forderField.insets = new Insets(0, 0, 5, 5);
        gbc_forderField.gridwidth = 3;
        gbc_forderField.gridx = 1;
        gbc_forderField.gridy = 1;
        contentPane.add(forderField, gbc_forderField);
        
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setText("瀏覽");
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.anchor = GridBagConstraints.NORTHWEST;
        gbc_button.insets = new Insets(0, 0, 5, 0);
        gbc_button.gridx = 4;
        gbc_button.gridy = 1;
        contentPane.add(button, gbc_button);
        
        JSeparator separator_1 = new JSeparator();
        GridBagConstraints gbc_separator_1 = new GridBagConstraints();
        gbc_separator_1.fill = GridBagConstraints.BOTH;
        gbc_separator_1.insets = new Insets(0, 0, 5, 0);
        gbc_separator_1.gridwidth = 5;
        gbc_separator_1.gridx = 0;
        gbc_separator_1.gridy = 2;
        contentPane.add(separator_1, gbc_separator_1);
        
        JLabel label_5 = new JLabel();
        label_5
                .setText("使用 # 可以指定數字計數所佔的位置：");
        GridBagConstraints gbc_label_5 = new GridBagConstraints();
        gbc_label_5.fill = GridBagConstraints.VERTICAL;
        gbc_label_5.insets = new Insets(0, 0, 5, 0);
        gbc_label_5.gridwidth = 5;
        gbc_label_5.gridx = 0;
        gbc_label_5.gridy = 3;
        contentPane.add(label_5, gbc_label_5);
        
        JLabel label_3 = new JLabel();
        label_3.setText("  模板：");
        GridBagConstraints gbc_label_3 = new GridBagConstraints();
        gbc_label_3.anchor = GridBagConstraints.EAST;
        gbc_label_3.fill = GridBagConstraints.VERTICAL;
        gbc_label_3.insets = new Insets(0, 0, 5, 5);
        gbc_label_3.gridx = 0;
        gbc_label_3.gridy = 4;
        contentPane.add(label_3, gbc_label_3);
        
        templetField = new JTextField();
        templetField.setText("photoshop###");
        GridBagConstraints gbc_templetField = new GridBagConstraints();
        gbc_templetField.anchor = GridBagConstraints.SOUTH;
        gbc_templetField.fill = GridBagConstraints.HORIZONTAL;
        gbc_templetField.insets = new Insets(0, 0, 5, 5);
        gbc_templetField.gridwidth = 3;
        gbc_templetField.gridx = 1;
        gbc_templetField.gridy = 4;
        contentPane.add(templetField, gbc_templetField);
        
        JLabel label_4 = new JLabel();
        label_4.setText("開始於：");
        GridBagConstraints gbc_label_4 = new GridBagConstraints();
        gbc_label_4.fill = GridBagConstraints.VERTICAL;
        gbc_label_4.insets = new Insets(0, 0, 5, 5);
        gbc_label_4.gridx = 0;
        gbc_label_4.gridy = 5;
        contentPane.add(label_4, gbc_label_4);
        
        startSpinner = new JSpinner();
        GridBagConstraints gbc_startSpinner = new GridBagConstraints();
        gbc_startSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_startSpinner.insets = new Insets(0, 0, 5, 5);
        gbc_startSpinner.gridx = 1;
        gbc_startSpinner.gridy = 5;
        contentPane.add(startSpinner, gbc_startSpinner);
        
        JLabel label_2 = new JLabel();
        label_2.setText("  擴充名：");
        GridBagConstraints gbc_label_2 = new GridBagConstraints();
        gbc_label_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_2.insets = new Insets(0, 0, 5, 5);
        gbc_label_2.gridx = 2;
        gbc_label_2.gridy = 5;
        contentPane.add(label_2, gbc_label_2);
        
        JButton startButton = new JButton();
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_startButton_actionPerformed(e);
            }
        });
        
        extNameField = new JTextField();
        extNameField.setText("jpg");
        GridBagConstraints gbc_extNameField = new GridBagConstraints();
        gbc_extNameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_extNameField.insets = new Insets(0, 0, 5, 5);
        gbc_extNameField.gridx = 3;
        gbc_extNameField.gridy = 5;
        contentPane.add(extNameField, gbc_extNameField);
        startButton.setText("開始");
        GridBagConstraints gbc_startButton = new GridBagConstraints();
        gbc_startButton.anchor = GridBagConstraints.NORTH;
        gbc_startButton.insets = new Insets(0, 0, 5, 0);
        gbc_startButton.gridx = 4;
        gbc_startButton.gridy = 5;
        contentPane.add(startButton, gbc_startButton);
        
        JSeparator separator_2 = new JSeparator();
        GridBagConstraints gbc_separator_2 = new GridBagConstraints();
        gbc_separator_2.anchor = GridBagConstraints.NORTH;
        gbc_separator_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_separator_2.insets = new Insets(0, 0, 5, 0);
        gbc_separator_2.gridwidth = 5;
        gbc_separator_2.gridx = 0;
        gbc_separator_2.gridy = 6;
        contentPane.add(separator_2, gbc_separator_2);
        
        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridwidth = 5;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 7;
        contentPane.add(scrollPane, gbc_scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
                "舊文件名", "新文件名" }));
        scrollPane.setViewportView(table);
    }
    
    /**
     * 瀏覽按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// 建立檔案選擇器
        // 設定只選擇檔案夾
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = chooser.showOpenDialog(this);// 顯示開啟交談視窗
        if (option == JFileChooser.APPROVE_OPTION) {
            dir = chooser.getSelectedFile();// 獲得選擇的檔案夾
        } else {
            dir = null;
        }
        forderField.setText(dir + "");// 顯示檔案夾資訊
    }
    
    /**
     * 開始按鈕的事件處理方法
     * 
     * @param e
     */
    protected void do_startButton_actionPerformed(ActionEvent e) {
        String templet = templetField.getText();// 獲得模板字串
        if (templet.isEmpty()) {
            JOptionPane.showMessageDialog(this, "請確定重命名模板", "資訊交談視窗",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        // 獲得表格資料模型
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);// 清除表格資料
        int bi = (Integer) startSpinner.getValue();// 獲得起始編號
        int index = templet.indexOf("#");// 獲得第一個「#」的索引
        String code = templet.substring(index);// 獲得模板中數字佔位字串
        // 把模板中數字佔位字串替換為指定格式
        templet = templet.replace(code, "%0" + code.length() + "d");
        String extName = extNameField.getText().toLowerCase();
        if (extName.indexOf(".") == -1)
            extName = "." + extName;
        // 獲得檔案中檔案列表陣列
        File[] files = dir.listFiles(new ExtNameFileFilter(extName));
        for (File file : files) {// 變數檔案陣列
            // 格式化每個檔案名稱
            String name = String.format(templet, bi++) + extName;
            // 把檔案的舊名稱與新名稱增加到表格的資料模型
            model.addRow(new String[] { file.getName(), name });
            File parentFile = file.getParentFile();// 獲得檔案所在檔案夾對像
            File newFile = new File(parentFile, name);
            file.renameTo(newFile);// 檔案重命名
        }
    }
}
