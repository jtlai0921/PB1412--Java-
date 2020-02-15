package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.UIManager;

public class UnZipTextFileFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7525621255251725313L;
    private JPanel contentPane;
    private JTextField sourceTextField;
    private JTable table;
    private File zipFile;
    private JTextField targetTextField;
    private File targetFile;
    
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
                    UnZipTextFileFrame frame = new UnZipTextFileFrame();
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
    public UnZipTextFileFrame() {
        setTitle("���Y�]��������w���");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);
        
        sourceTextField = new JTextField();
        sourceTextField.setFont(new Font("�L�n����", Font.PLAIN, 16));
        choosePanel.add(sourceTextField);
        sourceTextField.setColumns(7);
        
        JButton sourceButton = new JButton("Zip���");
        sourceButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        sourceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_sourceButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(sourceButton);
        
        targetTextField = new JTextField();
        targetTextField.setFont(new Font("�L�n����", Font.PLAIN, 16));
        choosePanel.add(targetTextField);
        targetTextField.setColumns(7);
        
        JButton targetButton = new JButton("������");
        targetButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        targetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_targetButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(targetButton);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton unzipButton = new JButton("�}�l�����Y");
        unzipButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        unzipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_unzipButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(unzipButton);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("�L�n����", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("�L�n����", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPane.setViewportView(table);
    }
    
    protected void do_sourceButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("��r�ɮ�", "zip"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            zipFile = fileChooser.getSelectedFile();
            sourceTextField.setText(zipFile.getAbsolutePath());
        }
    }
    
    protected void do_targetButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            targetFile = fileChooser.getSelectedFile();
            targetTextField.setText(targetFile.getAbsolutePath());
        }
    }
    
    @SuppressWarnings("unchecked")
    protected void do_unzipButton_actionPerformed(ActionEvent arg0) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();// ��o���ҫ�
        model.setColumnIdentifiers(new Object[] { "�Ǹ�", "�ɮצW" });// �]�w���Y
        int id = 1;// �n���Ǹ��ܼ�
        ZipFile zf = null;
        try {
            zf = new ZipFile(zipFile);// �Q�ΨϥΪ̿�ܪ�ZIP�ɮ׫إ�ZipFile�ﹳ
            Enumeration e = zf.entries();// �إߦC�|�ܼ�
            while (e.hasMoreElements()) {// �ˬd�C�|�ܼ�
                ZipEntry entry = (ZipEntry) e.nextElement();// ��oZipEntry�ﹳ
                if (!entry.getName().endsWith(".txt")) {// �p�G���O��r�ɮ״N���i������Y
                    continue;
                }
                // �Q�ΨϥΪ̿�ܪ��ɮק��MZipEntry�ﹳ�W�٫إ߸����᪺�ɮ�
                File currentFile = new File(targetFile + File.separator + entry.getName());
                FileOutputStream out = new FileOutputStream(currentFile);
                InputStream in = zf.getInputStream(entry);// �Q����o��ZipEntry��H����J�y
                int buffer = 0;
                while ((buffer = in.read()) != -1) {// �N��J�y�g�J�쥻���ɮ�
                    out.write(buffer);
                }
                model.addRow(new Object[] { id++, currentFile.getName() });// �W�[�@������
                in.close();// ����귽
                out.close();
            }
            table.setModel(model);// ��s���
            JOptionPane.showMessageDialog(this, "�����Y����");// ���ܨϥΪ̸����Y����
        } catch (ZipException e) {// �����ҥ~
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zf != null) {
                try {
                    zf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
