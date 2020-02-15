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
import javax.swing.JOptionPane;
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

public class DeCompressRAR extends JFrame {
    
    /**
     * �����Y���u�{���O
     * 
     * @author ����L
     */
    private final class DeCompressThread extends Thread {
        private final String command;
        
        private DeCompressThread(String command) {
            this.command = command;
        }
        
        public void run() {
            try {
                final Process process = Runtime.getRuntime().exec(command);
                process.getOutputStream().close();
                final Scanner scan = new Scanner(process.getInputStream());
                progressBar.setString(null);// ��l�ƶi�ױ����
                progressBar.setValue(0);
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
                    progressBar.setValue(percent + 1);// �b�i�ױ������ܦʤ���
                }
                progressBar.setString("����");
                process.getInputStream().close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    
    private JPanel contentPane;
    private JButton pathButton;
    private JPanel panel_1;
    private JLabel label;
    private JTextField compressFileField;
    private JButton browseButton;
    private File rarFile;
    private JProgressBar progressBar;
    private JTextField pathField;
    private JLabel label_1;
    private JButton deCompressButton;
    private JLabel label_2;
    private File dir;
    
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
                    DeCompressRAR frame = new DeCompressRAR();
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
    public DeCompressRAR() {
        setTitle("������Y��RAR����");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 154);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[] { 0, 60, 0, 0 };
        gbl_panel_1.rowHeights = new int[] { 17, 0, 0, 0 };
        gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0,
                Double.MIN_VALUE };
        gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel_1.setLayout(gbl_panel_1);
        
        label = new JLabel("���Y���ɡG");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.HORIZONTAL;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 0;
        panel_1.add(label, gbc_label);
        
        compressFileField = new JTextField();
        compressFileField.setEditable(false);
        GridBagConstraints gbc_compressFileField = new GridBagConstraints();
        gbc_compressFileField.insets = new Insets(0, 0, 5, 5);
        gbc_compressFileField.fill = GridBagConstraints.HORIZONTAL;
        gbc_compressFileField.gridx = 1;
        gbc_compressFileField.gridy = 0;
        panel_1.add(compressFileField, gbc_compressFileField);
        compressFileField.setColumns(10);
        
        browseButton = new JButton("�s��");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_browseButton_actionPerformed(arg0);
            }
        });
        GridBagConstraints gbc_browseButton = new GridBagConstraints();
        gbc_browseButton.insets = new Insets(0, 0, 5, 0);
        gbc_browseButton.gridx = 2;
        gbc_browseButton.gridy = 0;
        panel_1.add(browseButton, gbc_browseButton);
        
        label_1 = new JLabel("�������|�G");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 1;
        panel_1.add(label_1, gbc_label_1);
        
        pathField = new JTextField();
        GridBagConstraints gbc_pathField = new GridBagConstraints();
        gbc_pathField.insets = new Insets(0, 0, 5, 5);
        gbc_pathField.fill = GridBagConstraints.HORIZONTAL;
        gbc_pathField.gridx = 1;
        gbc_pathField.gridy = 1;
        panel_1.add(pathField, gbc_pathField);
        pathField.setColumns(10);
        
        pathButton = new JButton("���|");
        GridBagConstraints gbc_pathButton = new GridBagConstraints();
        gbc_pathButton.insets = new Insets(0, 0, 5, 0);
        gbc_pathButton.gridx = 2;
        gbc_pathButton.gridy = 1;
        panel_1.add(pathButton, gbc_pathButton);
        pathButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_pathButton_actionPerformed(arg0);
            }
        });
        
        label_2 = new JLabel("�i�סG");
        GridBagConstraints gbc_label_2 = new GridBagConstraints();
        gbc_label_2.insets = new Insets(0, 0, 0, 5);
        gbc_label_2.gridx = 0;
        gbc_label_2.gridy = 2;
        panel_1.add(label_2, gbc_label_2);
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        GridBagConstraints gbc_progressBar = new GridBagConstraints();
        gbc_progressBar.insets = new Insets(0, 0, 0, 5);
        gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
        gbc_progressBar.gridx = 1;
        gbc_progressBar.gridy = 2;
        panel_1.add(progressBar, gbc_progressBar);
        
        deCompressButton = new JButton("����");
        deCompressButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_deCompressButton_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_deCompressButton = new GridBagConstraints();
        gbc_deCompressButton.gridx = 2;
        gbc_deCompressButton.gridy = 2;
        panel_1.add(deCompressButton, gbc_deCompressButton);
    }
    
    /**
     * ���|���s���ƥ�B�z��k
     * 
     * @param arg0
     */
    protected void do_pathButton_actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        chooser.setDialogTitle("��ܸ����Y�ɮק�");// �]�w��͵������D
        chooser.setAcceptAllFileFilterUsed(false);
        // ��ܸ����Y�ɮק�
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = chooser.showOpenDialog(this);// ����ɮ׶}�ҥ�͵���
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        dir = chooser.getSelectedFile();// ��o��ܪ��ɮק�
        pathField.setText(dir.toString());// ���ɮק����|��s���r��
    }
    
    /**
     * ���RAR���Y����s�����s���ƥ�B�z��k
     * 
     * @param arg0
     */
    protected void do_browseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();// �إ��ɮ׿�ܾ�
        // �]�w����ɮ׫��A��Rar
        chooser.setFileFilter(new FileNameExtensionFilter("RAR���Y���", "rar"));
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setDialogTitle("���RAR���Y�ɮ�");// �]�w��͵������D
        int option = chooser.showOpenDialog(this);// ����x�s��͵���
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        rarFile = chooser.getSelectedFile();// ��o�ϥΪ̩w�s��RAR�ɮ�
        compressFileField.setText(rarFile.getPath());// ���RAR�ɮ׸��|��T
    }
    
    /**
     * �������s���ƥ�B�z��k
     * 
     * @param e
     */
    protected void do_deCompressButton_actionPerformed(ActionEvent e) {
        if (rarFile == null)// �p�G��������Y���
            browseButton.doClick();// ���������Y�ɮ׫��s�������ާ@
        if (dir == null)// �p�G����ܸ����Y�ɮק�
            pathButton.doClick();// �����ܸ����Y�ɮק������|���s�������ާ@
        if (rarFile == null || dir == null)// �p�G�ѼƤ����A�h�פ��k
            return;
        // �إ߫��O�r��
        final String command = "rar x " + rarFile + " " + dir + " /y";
        // ���ϥΪ̽T�{�O�_�л\�ؼ��ɮק��P�W�ɮ�
        int option = JOptionPane
                .showConfirmDialog(null, "���ާ@�|�л\�ؼ��ɮק��P�W�ɮסA�O�_�~��");
        if (option != JOptionPane.YES_OPTION)
            return;// ���л\�ؼ��ɮק����e�h����������Y
        new DeCompressThread(command).start();// �إߨñҰʸ����Y�u�{
    }
}
