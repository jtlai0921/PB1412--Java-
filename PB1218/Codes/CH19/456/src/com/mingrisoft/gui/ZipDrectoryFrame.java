package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.UIManager;

public class ZipDrectoryFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -138842864977841594L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JTable table;
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
                    ZipDrectoryFrame frame = new ZipDrectoryFrame();
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
    public ZipDrectoryFrame() {
        setTitle("���Y�Ҧ��l���");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel choosePanel = new JPanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);
        
        chooseTextField = new JTextField();
        chooseTextField.setFont(new Font("�L�n����", Font.PLAIN, 16));
        choosePanel.add(chooseTextField);
        chooseTextField.setColumns(18);
        
        JButton chooseButton = new JButton("��ܤ��");
        chooseButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        choosePanel.add(chooseButton);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton zipButton = new JButton("�}�l���Y");
        zipButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        zipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_zipButton_actionPerformed(arg0);
            }
        });
        buttonPanel.add(zipButton);
        
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
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectFile = fileChooser.getSelectedFile();
            chooseTextField.setText(selectFile.getAbsolutePath());
        }
    }
    
    protected void do_zipButton_actionPerformed(ActionEvent arg0) {
        
        List<String> path = new ArrayList<String>();
        getPath(selectFile, path);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new Object[] { "�Ǹ�", "�ɮ�" });
        int id = 1;
        for (String string : path) {
            model.addRow(new Object[] { id++, new File(string).getName() });
        }
        String targetZipFilePath = selectFile.getParent() + selectFile.getName() + ".zip";
        try {
            zipFile(path, new File(targetZipFilePath), selectFile.getAbsolutePath());
            JOptionPane.showMessageDialog(this, "�ɮק����Y���\");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void getPath(File rootFile, List<String> path) {
        File[] files = rootFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getPath(file, path);
            } else {
                path.add(file.getAbsolutePath());
            }
        }
    }
    
    private static void zipFile(List<String> path, File targetZipFile, String base) throws IOException {
        // �ھګ��w��targetZipFile�إ��ɮ׿�X�y�ﹳ
        FileOutputStream fos = new FileOutputStream(targetZipFile);
        ZipOutputStream zos = new ZipOutputStream(fos);// �Q���ɮ׿�X�y�ﹳ�إ�Zip��X�y�ﹳ
        byte[] buffer = new byte[1024];
        for (String string : path) {// �ˬd�Ҧ��n���Y�ɮת����|
            File currentFile = new File(string);
            ZipEntry entry = new ZipEntry(string.substring(base.length() + 1, string.length()));// �Q�έn���Y�ɮת��۹���|�إ�ZipEntry�ﹳ
            FileInputStream fis = new FileInputStream(currentFile);
            zos.putNextEntry(entry);
            int read = 0;
            while ((read = fis.read(buffer)) != -1) {// �N��Ƽg�J��Zip��X�y��
                zos.write(buffer, 0, read);
            }
            zos.closeEntry();// ����ZipEntry�ﹳ
            fis.close();
        }
        zos.close();// ����귽
        fos.close();
    }
    
}
