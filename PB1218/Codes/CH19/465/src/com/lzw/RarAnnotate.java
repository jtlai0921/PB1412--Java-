package com.lzw;

import static java.lang.Runtime.getRuntime;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RarAnnotate extends JFrame {
    
    private JPanel contentPane;
    private JTextField rarFileField;
    private File rarFile;
    private JTextArea annotateArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RarAnnotate frame = new RarAnnotate();
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
    public RarAnnotate() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 5));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));
        
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
        panel.add(rarFileField, BorderLayout.CENTER);
        rarFileField.setColumns(10);
        
        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setHgap(25);
        contentPane.add(panel_1, BorderLayout.SOUTH);
        
        JButton annotateButton = new JButton("�K�[/�ק�");
        annotateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_annotateButton_actionPerformed(e);
            }
        });
        panel_1.add(annotateButton);
        
        JButton closeButton = new JButton("����");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_closeButton_actionPerformed(e);
            }
        });
        panel_1.add(closeButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(new BevelBorder(
                BevelBorder.LOWERED, null, null, null, null),
                "�������ɡG", TitledBorder.LEADING,
                TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        annotateArea = new JTextArea();
        annotateArea.setLineWrap(true);
        scrollPane.setViewportView(annotateArea);
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
        try {
            // �إ��{���ɮ�
            File tempFile = File.createTempFile("rar", ".txt");
            // ������R�������O�A�������T�x�s�b�{���ɮפ�
            Process process = getRuntime().exec(
                    "rar cw \"" + rarFile + "\" \"" + tempFile + "\" -y");
            process.getOutputStream().close();// �����B�z�{�ǿ�X�y
            Scanner sc = new Scanner(process.getInputStream());
            while (sc.hasNext()) {
                sc.nextLine();// �M�ſ�J�y
            }
            process.getInputStream().close();// ������J�y
            annotateArea.setText("");// ���p��r�줺�e
            Scanner scan = new Scanner(tempFile);// �إ�Ū���{���ɮת����˾�
            while (scan.hasNext()) {
                // �������T��ܨ��r�챱���
                annotateArea.append(scan.next() + "\n");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    
    /**
     * �������s���ƥ��ť��
     * 
     * @param e
     */
    protected void do_closeButton_actionPerformed(ActionEvent e) {
        this.dispose();
    }
    
    /**
     * �W�[�ק���s���ƥ�B�z��k
     * 
     * @param e
     */
    protected void do_annotateButton_actionPerformed(ActionEvent e) {
        String annotateStr = annotateArea.getText();// ��o������r
        int length = annotateStr.getBytes().length;// ��o������r����
        if (length > 32767) {// �����r����
            JOptionPane.showMessageDialog(null, "�������פ���j��32767");
            return;
        }
        try {
            Process process = getRuntime().exec(// ����W�[�������O
                    "rar c \"" + rarFile + "\"");
            // �������r�ǻ����������O
            process.getOutputStream().write(annotateStr.getBytes());
            process.getOutputStream().close();// ������X�y
            process.getInputStream().close();// ������J�y
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
