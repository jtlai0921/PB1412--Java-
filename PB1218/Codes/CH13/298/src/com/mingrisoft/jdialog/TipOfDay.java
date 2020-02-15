package com.mingrisoft.jdialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class TipOfDay extends JDialog {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6493879146336970741L;
    private final JPanel contentPanel = new JPanel();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            TipOfDay dialog = new TipOfDay();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Create the dialog.
     */
    public TipOfDay() {
        setTitle("���鴣��");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, BorderLayout.NORTH);
            {
                JLabel label = new JLabel("���鴣��");
                label.setFont(new Font("�L�n����", Font.PLAIN, 16));
                panel.add(label);
            }
        }
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, BorderLayout.SOUTH);
            panel.setLayout(new BorderLayout(0, 0));
            {
                JCheckBox checkBox = new JCheckBox("���A���");
                checkBox.setFont(new Font("�L�n����", Font.PLAIN, 16));
                panel.add(checkBox);
            }
        }
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, BorderLayout.WEST);
        }
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, BorderLayout.EAST);
        }
        {
            JScrollPane scrollPane = new JScrollPane();
            contentPanel.add(scrollPane, BorderLayout.CENTER);
            {
                JTextArea textArea = new JTextArea();
                textArea.setFont(new Font("�L�n����", Font.PLAIN, 14));
                textArea.setLineWrap(true);
                textArea
                        .setText("���q²���G�N�L�٩����ަ������q�O�@�a�H�p����n��޳N���֤ߪ�����ޫ����~�A���q�إߩ�1999�~12��A�O�M�~�����γn��}�o�өM�A�ȴ��ѰӡC�h�~�өl�׭P�O�󲣷~�޲z�n��}�o�B�Ʀr�ƥX�����}�o�s�@�B���~�q�l�ӰȺ����}�o���A���ᦨ�\�}�o�F�A�ΥͲ��B�޲z�B���y�B��P�B�A�ȵ���쪺�h�إ��~�޲z���γn��M���Υ��x�C");
                scrollPane.setViewportView(textArea);
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("�U���H��");
                okButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("��������");
                cancelButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
}
