package com.mingrisoft.jlist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class DynamicList extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 890359141688419648L;
    private JPanel contentPane;
    private JList list;
    private DefaultListModel model = new DefaultListModel();
    
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
                    DynamicList frame = new DynamicList();
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
    public DynamicList() {
        setTitle("�C�����W�[�P�R��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JButton addButton = new JButton("�W�[");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_addButton_actionPerformed(e);
            }
        });
        addButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        panel.add(addButton);
        
        JButton deleteButton = new JButton("�R��");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_deleteButton_actionPerformed(e);
            }
        });
        deleteButton.setFont(new Font("�L�n����", Font.PLAIN, 16));
        panel.add(deleteButton);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        list = new JList();
        list.setFont(new Font("�L�n����", Font.PLAIN, 16));
        scrollPane.setViewportView(list);
        
        model.addElement("�mJava�q�J�����q�]��2���^�n");
        model.addElement("�mPHP�q�J�����q�]��2���^�n");
        model.addElement("�mVisual Basic�q�J�����q�]��2���^�n");
        model.addElement("�mVisual C++�q�J�����q�]��2���^�n");
        model.addElement("�mJava�s�{����n");
        model.addElement("�m�ӻ�Java�n");
        model.addElement("�m���T��Java�n");
        list.setModel(model);
    }
    
    protected void do_addButton_actionPerformed(ActionEvent e) {
        String text = JOptionPane.showInputDialog("�W�[����");
        if ((text != null) && (!text.trim().isEmpty())) {
            model.addElement(text.trim());
        } else {
            return;
        }
    }
    
    protected void do_deleteButton_actionPerformed(ActionEvent e) {
        model.removeElement(list.getSelectedValue());
    }
}
