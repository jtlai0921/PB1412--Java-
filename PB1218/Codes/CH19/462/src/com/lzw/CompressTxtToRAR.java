package com.lzw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;

public class CompressTxtToRAR extends JFrame {
    
    /**
     * �������Y�u�@����n��
     * 
     * @author ����L
     */
    private final class CompressThread extends Thread {
        public void run() {
            try {
                // ��o��汱�����Ƽҫ�
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int rowCount = model.getRowCount();// ��o��Ƽҫ��������
                StringBuilder fileList = new StringBuilder();
                for (int i = 0; i < rowCount; i++) {// �ˬd��ƪ��ҫ������ɮ׹ﹳ
                    File file = (File) model.getValueAt(i, 2);
                    fileList.append(file.getPath() + "\n");// ���ɮ׸��|�s��r��غc����
                }
                // �إ��{���ɮסA�Ω��x�s���Y�ɮצC��
                File listFile = File.createTempFile("fileList", ".tmp");
                FileOutputStream fout = new FileOutputStream(listFile);
                fout.write(fileList.toString().getBytes());// �x�s�r��غc����ƨ��{���ɮ�
                fout.close();
                // �إ����Y���O�r��
                final String command = "rar a " + rarFile.getPath() + " @"
                        + listFile.getPath();
                Runtime runtime = Runtime.getRuntime();// ��oRuntime�ﹳ
                progress = runtime.exec(command.toString() + "\n");// �������Y���O
                progress.getOutputStream().close();// �����B�z�{�ǿ�X�y
                progressBar.setString(null);// ��l�ƶi�ױ����
                progressBar.setValue(0);
                // ��o�B�z�{�ǿ�J�y
                Scanner scan = new Scanner(progress.getInputStream());
                while (scan.hasNext()) {
                    String line = scan.nextLine();// ��o�B�z�{�Ǵ��ܳ���T
                    // ��o���ܸ�T���i�צʤ��񪺯��ަ�m
                    int index = line.lastIndexOf("%") - 3;
                    if (index <= 0)
                        continue;
                    // ��o�i�צʤ���r��
                    String substring = line.substring(index, index + 3);
                    // ��o��ƪ��ʤ���ƭ�
                    int percent = Integer.parseInt(substring.trim());
                    progressBar.setValue(percent);// �b�i�ױ������ܦʤ���
                }
                progressBar.setString("����");
                scan.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private JPanel contentPane;
    private JTable table;
    private JPanel panel;
    private JButton addButton;
    private JButton removeButton;
    private JPanel panel_1;
    private JLabel label;
    private JTextField compressFileField;
    private JButton browseButton;
    private File rarFile;
    private JButton compressButton;
    private JProgressBar progressBar;
    private JButton stopButton;
    private Process progress;
    
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
                    CompressTxtToRAR frame = new CompressTxtToRAR();
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
    public CompressTxtToRAR() {
        setTitle("������Y��RAR����");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
                "���W��", "���j�p",
                "�����|" }));
        table.getColumnModel().getColumn(0).setPreferredWidth(125);
        table.getColumnModel().getColumn(2).setPreferredWidth(250);
        table.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(table);
        scrollPane.getViewport().setBackground(Color.WHITE);
        
        panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.SOUTH);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[] { 0, 60, 0, 0 };
        gbl_panel_1.rowHeights = new int[] { 0, 17, 0 };
        gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0,
                Double.MIN_VALUE };
        gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
        panel_1.setLayout(gbl_panel_1);
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        GridBagConstraints gbc_progressBar = new GridBagConstraints();
        gbc_progressBar.gridwidth = 3;
        gbc_progressBar.insets = new Insets(0, 0, 5, 5);
        gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
        gbc_progressBar.gridx = 0;
        gbc_progressBar.gridy = 0;
        panel_1.add(progressBar, gbc_progressBar);
        
        label = new JLabel("���Y���ɡG");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.HORIZONTAL;
        gbc_label.insets = new Insets(0, 0, 0, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 1;
        panel_1.add(label, gbc_label);
        
        compressFileField = new JTextField();
        compressFileField.setEditable(false);
        GridBagConstraints gbc_compressFileField = new GridBagConstraints();
        gbc_compressFileField.insets = new Insets(0, 0, 0, 5);
        gbc_compressFileField.fill = GridBagConstraints.HORIZONTAL;
        gbc_compressFileField.gridx = 1;
        gbc_compressFileField.gridy = 1;
        panel_1.add(compressFileField, gbc_compressFileField);
        compressFileField.setColumns(10);
        
        browseButton = new JButton("�s��");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_browseButton_actionPerformed(arg0);
            }
        });
        GridBagConstraints gbc_browseButton = new GridBagConstraints();
        gbc_browseButton.gridx = 2;
        gbc_browseButton.gridy = 1;
        panel_1.add(browseButton, gbc_browseButton);
        
        panel = new JPanel();
        contentPane.add(panel, BorderLayout.WEST);
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        addButton = new JButton("�W�[");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_addButton_actionPerformed(arg0);
            }
        });
        panel.add(addButton);
        
        removeButton = new JButton("����");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_removeButton_actionPerformed(arg0);
            }
        });
        panel.add(removeButton);
        
        compressButton = new JButton("���Y");
        compressButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_compressButton_actionPerformed(arg0);
            }
        });
        panel.add(compressButton);
        
        stopButton = new JButton("����");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_stopButton_actionPerformed(arg0);
            }
        });
        panel.add(stopButton);
    }
    
    /**
     * �W�[���s���ƥ�B�z��k
     * 
     * @param arg0
     */
    protected void do_addButton_actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setMultiSelectionEnabled(true);// �]�w���\�ɮצh��
        int option = chooser.showOpenDialog(this);// ����ɮ׶}�ҥ�͵���
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        File[] files = chooser.getSelectedFiles();// ��o�ϥΪ̿���ɮװ}�C
        // ��o��汱�����Ƽҫ�
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (File file : files) {// �ˬd�ϥΪ̿�ܪ��ɮװ}�C
            // ���ɮ׸�T�W�[���汱����ҫ���
            model.addRow(new Object[] { file.getName(), file.length(), file });
        }
    }
    
    /**
     * �������s���ƥ�B�z��k
     * 
     * @param arg0
     */
    protected void do_removeButton_actionPerformed(ActionEvent arg0) {
        int[] rows = table.getSelectedRows();// ��o��椤�Ŀ諸����ު��}�C
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = rows.length - 1; i >= 0; i--) {
            model.removeRow(rows[i]);// �ˬd�ò����Ҧ��Ŀ��
        }
    }
    
    /**
     * ������YRAR����s�����s���ƥ�B�z��k
     * 
     * @param arg0
     */
    protected void do_browseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        // �]�w����ɮ׫��A��Rar
        chooser.setFileFilter(new FileNameExtensionFilter("RAR���Y���", "rar"));
        chooser.setAcceptAllFileFilterUsed(false);
        int option = chooser.showSaveDialog(this);// ����x�s��͵���
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        rarFile = chooser.getSelectedFile();// ��o�ϥΪ̩w�s��RAR�ɮ�
        compressFileField.setText(rarFile.getPath());// ���RAR�ɮ׸��|��T
    }
    
    /**
     * ���Y���s���ƥ�B�z��k
     * 
     * @param arg0
     */
    protected void do_compressButton_actionPerformed(ActionEvent arg0) {
        if (rarFile == null) {
            browseButton.doClick();
            if (rarFile == null)
                return;
        }
        progressBar.setVisible(true);
        CompressThread compressThread = new CompressThread(); // �إ����Y�u�{
        compressThread.start();// �Ұʽu�{
    }
    
    /**
     * ������s���ƥ�B�z��k
     * 
     * @param arg0
     */
    protected void do_stopButton_actionPerformed(ActionEvent arg0) {
        if (progress != null) {
            progress.destroy();
            progressBar.setValue(0);
            progressBar.setVisible(false);
        }
    }
}
