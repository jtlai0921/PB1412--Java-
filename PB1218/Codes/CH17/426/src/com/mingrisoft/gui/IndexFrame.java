package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mingrisoft.util.DBHelper;
import javax.swing.UIManager;

public class IndexFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1665617920851760553L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JTextField keyTextField;
    private JTable table;
    private JProgressBar progressBar;
    private File selectFile;
    
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
                    IndexFrame frame = new IndexFrame();
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
    public IndexFrame() {
        setTitle("�b�ƾڮw���إߺϽL������");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent arg0) {
                do_this_windowActivated(arg0);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);
        
        chooseTextField = new JTextField();
        choosePanel.add(chooseTextField);
        chooseTextField.setColumns(27);
        
        JButton chooseButton = new JButton("��ܺϽL");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(chooseButton);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        keyTextField = new JTextField();
        buttonPanel.add(keyTextField);
        keyTextField.setColumns(12);
        
        JButton searchButton = new JButton("�}�l�d��");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_searchButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(searchButton);
        
        progressBar = new JProgressBar();
        buttonPanel.add(progressBar);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
    }
    
    protected void do_this_windowActivated(WindowEvent arg0) {
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select * from tb_directories";
        int rowCount = DBHelper.query(sql).size();
        if (rowCount == 0) {
            model.setColumnIdentifiers(new Object[] { "id", "path" });
            table.setModel(model);
        } else {
            String[] tableHeader = DBHelper.getColumnNames(sql);
            List<Object[]> tableBody = DBHelper.query(sql);
            model.setColumnIdentifiers(tableHeader);
            for (int i = 0; i < tableBody.size(); i++) {
                model.addRow(tableBody.get(i));
            }
            table.setModel(model);
        }
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectFile = fileChooser.getSelectedFile();
            chooseTextField.setText(selectFile.getAbsolutePath());
            progressBar.setIndeterminate(true);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            IndexCreation creation = new IndexCreation(model);
            creation.execute();
            
        }
    }
    
    private static List<String> getFilePath(List<String> list, File rootFile) {
        File[] files = rootFile.listFiles();// �C�X�ϥΪ̿�ܪ��ɮק��U���Ҧ��ɮס]���^
        if (files == null)// �p�G�O���ɮק������Ǧ^
            return list;
        for (File file : files) {// �ˬd�ϥΪ̿�ܪ��ɮק��U�Ҧ����ɮס]���^
            if (file.isDirectory()) {// �p�G�O�@���ɮק��h�i�歡�N
                getFilePath(list, file);
            } else {
                list.add(file.getAbsolutePath().replace("\\", "/"));// �_�h�x�s���|
            }
        }
        return list;
    }
    
    private class IndexCreation extends SwingWorker<DefaultTableModel, Object[]> {
        
        private final DefaultTableModel model;
        
        public IndexCreation(DefaultTableModel model) {
            this.model = model;
        }
        
        @Override
        protected DefaultTableModel doInBackground() throws Exception {
            List<String> list = new ArrayList<String>();
            getFilePath(list, selectFile);
            for (int i = 0; i < list.size(); i++) {
                String sql = "select id from tb_directories where path = '" + list.get(i) + "';";
                int maxId = DBHelper.getMaxID("tb_directories");
                List<Object[]> results = DBHelper.query(sql);
                if (results.size() == 0) {
                    sql = "insert into tb_directories (path) values ('" + list.get(i) + "');";
                    DBHelper.update(sql);
                    publish(new Object[] { maxId + 1, list.get(i) });
                }
            }
            
            return model;
        }
        
        @Override
        protected void process(List<Object[]> chunks) {
            
            for (Object[] row : chunks) {
                model.addRow(row);
            }
        }
        
        @Override
        protected void done() {
            table.setModel(model);
            progressBar.setIndeterminate(false);
        }
    }
    
    protected void do_searchButton_actionPerformed(ActionEvent arg0) {
        String key = keyTextField.getText();
        if (key.length() == 0) {
            JOptionPane.showMessageDialog(this, "�п�J����r", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String sql = "select * from tb_directories where path like '%" + key + ".%';";
        List<Object[]> results = DBHelper.query(sql);
        if (results.size() == 0) {
            JOptionPane.showMessageDialog(this, "�S�����z�n�d�ߪ��ɮ�", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Object[] row : results) {
            model.addRow(row);
        }
        table.setModel(model);
    }
}
