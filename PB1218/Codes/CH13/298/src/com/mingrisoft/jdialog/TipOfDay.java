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
        setTitle("さら苅ボ");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, BorderLayout.NORTH);
            {
                JLabel label = new JLabel("さら苅ボ");
                label.setFont(new Font("�L�n峡饗", Font.PLAIN, 16));
                panel.add(label);
            }
        }
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, BorderLayout.SOUTH);
            panel.setLayout(new BorderLayout(0, 0));
            {
                JCheckBox checkBox = new JCheckBox("ぃ�A塔ボ");
                checkBox.setFont(new Font("�L�n峡饗", Font.PLAIN, 16));
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
                textArea.setFont(new Font("�L�n峡饗", Font.PLAIN, 14));
                textArea.setLineWrap(true);
                textArea
                        .setText("そ�q族ざ�G�N�L�扎�ら�讌洟貝�そ�q�O�@�a�H�p財穣�nンм�N�握屬潛紺��讌洸����~�Aそ�q�悒潯�1999�~12る�A�O�M�~�裟灰粒nン�}�o尉�M�A鞍苅�儖咫C�h�~�唏l苛�P�O�鷁７~剤�z�nン�}�o�B柴�rて�X�����}�o�s�@�B横�~�q�l尉鞍柵�原}�o汽�A���瓲┘\�}�o�F�Aのネ横�B剤�z�B���y�B仙�P�B�A鞍汽獅一�墾h斎���~剤�z棲ノ�nン�M棲ノキ�x�C");
                scrollPane.setViewportView(textArea);
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("�U汚�H��");
                okButton.setFont(new Font("�L�n峡饗", Font.PLAIN, 16));
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("猪階機悼");
                cancelButton.setFont(new Font("�L�n峡饗", Font.PLAIN, 16));
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
}
