package com.mingrisoft.jlist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SearchList extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2294503152841317673L;
    private JPanel contentPane;
    private JTextField textField;
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
                    SearchList frame = new SearchList();
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
    public SearchList() {
        setTitle("�d��\�઺��{");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        JLabel label = new JLabel("��J����r�G");
        label.setFont(new Font("�L�n����", Font.PLAIN, 16));
        panel.add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("�L�n����", Font.PLAIN, 16));
        panel.add(textField);
        textField.setColumns(10);
        
        JButton button = new JButton("�d��");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("�L�n����", Font.PLAIN, 16));
        panel.add(button);
        
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
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String key = textField.getText();
        if ((key == null) || (key.trim().isEmpty())) {
            JOptionPane.showMessageDialog(this, "�п�J����r", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (model.contains(key)) {
            int index = model.indexOf(key);
            list.setSelectedIndex(index);
        } else {
            list.clearSelection();
            JOptionPane.showMessageDialog(this, "���������r", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
}
