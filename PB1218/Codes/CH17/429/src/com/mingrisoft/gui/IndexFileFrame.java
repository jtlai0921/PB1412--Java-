package com.mingrisoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class IndexFileFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2008614713725440868L;
    private JPanel contentPane;
    private JTextField chooseTextField;
    private JComboBox comboBox;
    private JProgressBar progressBar;
    private JTextArea textArea;
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
                    IndexFileFrame frame = new IndexFileFrame();
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
    public IndexFileFrame() {
        setTitle("�ЫغϽL���ޤ��");
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
        chooseTextField.setText("��ܫO�s�ϽL���ު����");
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
        
        JPanel Panel = new JPanel();
        contentPane.add(Panel, BorderLayout.SOUTH);
        
        comboBox = new JComboBox();
        comboBox.setFont(new Font("�L�n����", Font.PLAIN, 16));
        comboBox.setMaximumRowCount(8);
        Panel.add(comboBox);
        
        File[] files = File.listRoots();
        for (File file : files) {
            comboBox.addItem(file);
        }
        comboBox.setSelectedIndex(0);
        
        JButton createButton = new JButton("�Ыد���");
        createButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_createButton_actionPerformed(arg0);
            }
        });
        Panel.add(createButton);
        
        progressBar = new JProgressBar();
        progressBar.setFont(new Font("�L�n����", Font.PLAIN, 16));
        Panel.add(progressBar);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("�L�n����", Font.PLAIN, 16));
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("��r�ɮ�", "txt"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            chooseFile = fileChooser.getSelectedFile();
            chooseTextField.setText(chooseFile.getAbsolutePath());
        }
    }
    
    protected void do_createButton_actionPerformed(ActionEvent arg0) {
        if (chooseFile == null) {
            JOptionPane.showMessageDialog(this, "�п���x�s���ު��ɮ�", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String disc = comboBox.getSelectedItem().toString();// ��o�ϥΪ̿�ܪ��Ϻ�
        comboBox.setSelectedItem(disc);// �]�wJComboBox��ܨϥΪ̿�ܪ��Ϻ�
        final List<String> list = new ArrayList<String>();// ��list�x�s����
        final File rootFile = new File(disc);// �Q�ΨϥΪ̿�ܪ��ϺЫإ�File�ﹳ
        final StringBuilder sb = new StringBuilder();// �Q��StringBuilder�ﹳ�x�s�g�J������
        progressBar.setIndeterminate(true);// �]�w���ʱ��}�l����
        new Thread() {// �b�@�ӷs���u�{���B�z�إ߯��ީM�g�J���ު��ާ@
            @Override
            public void run() {
                getFilePath(list, rootFile);// ��o�ϺФW�Ҧ��ɮת����|
                Iterator<String> iterator = list.iterator();// �إ߭��N��
                while (iterator.hasNext()) {// �ˬdlist
                    sb.append(iterator.next());
                    sb.append("\r\n");
                    try {
                        Thread.sleep(100);// �u�{��v0.1��
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    textArea.setText(sb.toString());// �b��r�줤����ɮ׸��|
                }
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(chooseFile);
                    fileWriter.write(textArea.getText());// �V�ϥΪ̿�ܪ���r�ɮ׼g�J���
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // �ٲ�����귽���{���X
                progressBar.setIndeterminate(false);// ����i�ױ�������
                JOptionPane.showMessageDialog(null, "���ޫإߦ��\");// ���ܨϥΪ̯��ޫإߦ��\
            };
        }.start();
    }
    
    private static List<String> getFilePath(List<String> list, File rootFile) {
        File[] files = rootFile.listFiles();
        if (files == null)
            return list;
        for (File file : files) {
            if (file.isDirectory()) {
                getFilePath(list, file);
            } else {
                list.add(file.getAbsolutePath().replace("\\", "/"));
            }
        }
        return list;
    }
    
}
