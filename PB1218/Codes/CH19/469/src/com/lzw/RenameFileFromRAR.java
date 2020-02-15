package com.lzw;

import static java.lang.Runtime.getRuntime;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class RenameFileFromRAR extends JFrame {
    
    private JPanel contentPane;
    private JTextField rarFileField;
    private File rarFile;
    private JTable table;
    private JTextField newFileField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RenameFileFromRAR frame = new RenameFileFromRAR();
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
    public RenameFileFromRAR() {
        setTitle("�qRAR���Y�]���R�����");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 532, 373);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 5));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(5, 0));
        
        JLabel lblrar = new JLabel("�@���RAR���ɡG");
        panel.add(lblrar, BorderLayout.WEST);
        
        JButton browseButton = new JButton("�s��");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_browseButton_actionPerformed(e);
            }
        });
        panel.add(browseButton, BorderLayout.EAST);
        
        rarFileField = new JTextField();
        rarFileField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
                null, null));
        panel.add(rarFileField, BorderLayout.CENTER);
        rarFileField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(2, 200));
        panel.add(scrollPane, BorderLayout.SOUTH);
        scrollPane.setBorder(new TitledBorder(new BevelBorder(
                BevelBorder.LOWERED, null, null, null, null),
                "���Y���C��G",
                TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(
                        0, 0, 0)));
        
        table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(450, 100));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
                "���W��", "�j�p",
                "���Y��j�p", "���Y�v",
                "�ɶ�" }));
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (e.getValueIsAdjusting())
                            return;
                        int row = table.getSelectedRow();
                        if (row < 0)
                            return;
                        String value = table.getValueAt(row, 0) + "";
                        newFileField.setText(value);
                    }
                });
        scrollPane.setViewportView(table);
        
        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setHgap(30);
        contentPane.add(panel_1, BorderLayout.SOUTH);
        
        JButton renameButton = new JButton("���R�W");
        renameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_renameButton_actionPerformed(e);
            }
        });
        panel_1.add(renameButton);
        
        JButton closeButton = new JButton("����");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_closeButton_actionPerformed(e);
            }
        });
        panel_1.add(closeButton);
        
        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));
        
        JLabel label = new JLabel(
                "��J�s���W�١]�`�N�ק�����|�|�ɭP��󲾰ʡ^:");
        label.setVerticalAlignment(SwingConstants.BOTTOM);
        panel_2.add(label, BorderLayout.WEST);
        
        newFileField = new JTextField();
        newFileField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
                null, null));
        panel_2.add(newFileField, BorderLayout.SOUTH);
        newFileField.setColumns(10);
    }
    
    /**
     * �s�����s���ƥ�B�z��k
     * 
     * @param e
     */
    protected void do_browseButton_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        chooser.setFileFilter(new FileNameExtensionFilter("RAR���", "rar"));
        chooser.setAcceptAllFileFilterUsed(false);
        int option = chooser.showOpenDialog(this);// ����ɮ׶}�ҥ�͵���
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        rarFile = chooser.getSelectedFile();// ��o��ܪ�rar�ɮ�
        rarFileField.setText(rarFile.toString());// ���rar�ɮר��r��
        resolveFileList();
    }
    
    /**
     * �ѪR�ɮצC���T���汱�
     */
    private void resolveFileList() {
        try {
            // ������R�������O�A�������T�x�s�b�{���ɮפ�
            Process process = getRuntime()
                    .exec("rar v -c- \"" + rarFile + "\"");
            process.getOutputStream().close();// �����B�z�{�ǿ�X�y
            Scanner sc = new Scanner(process.getInputStream());
            int count = 0;// �إߦ����
            // ��o��汱��ҫ�
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            Vector<String> row = new Vector<String>();// �إߦ��ƦV�q
            do {
                String line = sc.nextLine();// ��o�ɮצC���T���@��
                // �аO�_�l��������
                if (line.contains("----------------------")) {
                    count = (count == 0 ? count + 1 : -1);
                    continue;
                }
                if (count == 0)// ���L�_�l�аO
                    continue;
                if (count == -1)// �b�����аO�פ�`��
                    break;
                if (++count % 2 == 0) {// ��o�ɮצW��
                    row.add(line);
                } else {// ��o�ɮ׸ԲӸ�T
                    // ���ɮ׸ԲӸ�T���ά��}�C
                    String[] split = line.trim().split("\\s+");
                    for (String string : split) {// �ˬd�ԲӸ�T�}�C
                        row.add(string);// ��C�ӸԲ��ݩʼW�[�����椸���
                    }
                    // ����ƼW�[�����Ƽҫ�
                    model.addRow(row.toArray());
                    row.clear();// �M�����ƦV�q��H�A���U�@��ѪR���ǳ�
                }
            } while (sc.hasNext());
            process.getInputStream().close();// ������J�y
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    
    /**
     * �������s���ƥ�B�z��k
     * 
     * @param e
     */
    protected void do_closeButton_actionPerformed(ActionEvent e) {
        dispose();
    }
    
    /**
     * ���R�W���s���ƥ�B�z��k
     * 
     * @param e
     */
    protected void do_renameButton_actionPerformed(ActionEvent e) {
        // ��o����Ƽҫ�
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();// ��o���ثe��ܦ�
        if (selectedRow < 0)
            return;
        // ��o��ܦ椤���ɮצW
        String path = model.getValueAt(selectedRow, 0).toString();
        String newFile = newFileField.getText();// ��o�s�ɮצW��
        try {
            // ����rar��W���O
            Process exec = getRuntime().exec(
                    "rar rn -c- \"" + rarFile + "\" " + path + " " + newFile);
            // �إ߳B�z�{�ǿ�J�y
            Scanner scan = new Scanner(exec.getInputStream());
            while (scan.hasNext()) {// �ܼƿ�J�y���e
                scan.nextLine();// �M�ſ�J�y���
            }
            scan.close();// ������J�y
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        resolveFileList();// �h����椤�ɮצC����
    }
}
