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
        setTitle("�R���ϽL�Ҧ�.tmp�{�ɤ��");
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
                "���W��", "�����|",
                "���j�p", "�B�z���G" }) {
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
        
        JButton searchButton = new JButton("�j��");
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
        
        JButton clearButton = new JButton("�M�z");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_clearButton_actionPerformed(e);
            }
        });
        panel.add(clearButton);
    }
    
    /**
     * ����Ұʪ��ƥ�B�z��k
     * 
     * @param e
     */
    protected void do_this_windowActivated(WindowEvent e) {
        DefaultListModel model = new DefaultListModel();
        File[] roots = File.listRoots();// ��o�p����ϺЦC��
        for (File file : roots) {// �ˬd�ϺЦC��
            model.addElement(file);// �W�[�ϺШ�JList������ҫ�
        }
        driverList.setModel(model);// �]�w�C������ҫ�
    }
    
    /**
     * �j�����s���ƥ�B�z��k
     * 
     * @param e
     */
    protected void do_searchButton_actionPerformed(ActionEvent e) {
        // ��o�ϥΪ̦b�C�����ܪ��Ϻйﹳ
        final File driver = (File) driverList.getSelectedValue();
        if (searchThread != null) {// �p�G�j���u�{�w�g��l��
            searchThread.setSearching(false);// ����ӽu�{
        }
        // ��o����H����Ƽҫ�
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        // �إ߷s���j���u�{
        searchThread = new SearchThread(driver, model, progressBar);
        searchThread.start();// �Ұʷj���u�{
    }
    
    /**
     * �M�����s���ƥ�B�z��k
     * 
     * @param e
     */
    protected void do_clearButton_actionPerformed(ActionEvent e) {
        // ��o��汱�����Ƽҫ�
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();// ��o�ҫ�������ƪ����
        for (int i = 0; i < rowCount; i++) {// �ܼƼҫ����w��ƪ����
            File file = (File) model.getValueAt(i, 1);// ��o���w�檺�ɮ׹ﹳ
            if (file.exists())// �P�_�ɮצs�b
                file.delete();// �R��tmp�{���ɮ�
            model.setValueAt("�B�z����", i, 3);// ��s�ҫ�������ɮת��B�z���G
        }
    }
}
