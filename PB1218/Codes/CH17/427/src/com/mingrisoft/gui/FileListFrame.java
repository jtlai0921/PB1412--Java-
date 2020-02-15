package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class FileListFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -615665572894071265L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JButton chooseButton;
    private JScrollPane scrollPane;
    private JTable table;
    private JProgressBar progressBar;
    private File chooseFile;
    
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
                    FileListFrame frame = new FileListFrame();
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
    public FileListFrame() {
        setTitle("����ʺA�[���ϽL���");
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
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        
        chooseTextField = new JTextField();
        panel.add(chooseTextField);
        chooseTextField.setColumns(13);
        
        chooseButton = new JButton("��ܤ��");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        panel.add(chooseButton);
        
        progressBar = new JProgressBar();
        panel.add(progressBar);
        
        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            chooseFile = fileChooser.getSelectedFile();// ��o�ϥΪ̿�ܪ��ɮק�
            chooseTextField.setText(chooseFile.getAbsolutePath());// ��ܨϥΪ̿�ܪ��ɮק�
            progressBar.setIndeterminate(true);// �]�w���ʱ��}�l����
            final File[] subFiles = chooseFile.listFiles();// ��o�ϥΪ̿�ܪ��ɮק������Ҧ��ɮס]���^
            final DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);// �M�Ū��
            new Thread() {// �}�l�s���u�{
                public void run() {
                    for (int i = 0; i < subFiles.length; i++) {// �ˬd�ϥΪ̿�ܪ��ɮק�
                        if (subFiles[i].isFile()) {// �P�_�O�_�O�@���ɮ�
                            Object[] property = new Object[3];
                            property[0] = i + 1;// �x�s�Ǹ�
                            property[1] = subFiles[i].getName();// �x�s�ɮצW
                            property[2] = "";
                            if (subFiles[i].isHidden()) {// �P�_�O�_�O�@�������ɮ�
                                property[2] = "�����ɮ�";
                            }
                            model.addRow(property);// �V��椤�W�[�O��
                            table.setModel(model);// ��s���
                        }
                        try {
                            Thread.sleep(100);// �u�{��v0.1���{�ʺA���J
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    progressBar.setIndeterminate(false);// ����i�ױ�����
                };
            }.start();
            
        }
    }
    
    protected void do_this_windowActivated(WindowEvent arg0) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new Object[] { "�Ǹ�", "�ɮצW", "�ݩ�" });
    }
    
}
