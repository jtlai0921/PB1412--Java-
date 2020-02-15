package com.mingrisoft.time;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class DateValidator extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1397183659288755891L;
    private JPanel contentPane;
    private JTextField dateTextField;
    private JTextField formatTextField;
    
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
                    DateValidator frame = new DateValidator();
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
    public DateValidator() {
        setTitle("����榡���羹");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 1, 5, 5));
        
        JPanel datePanel = new JPanel();
        contentPane.add(datePanel);
        
        JLabel dateLabel = new JLabel("��J����G");
        dateLabel.setFont(new Font("�L�n����", Font.PLAIN, 18));
        datePanel.add(dateLabel);
        
        dateTextField = new JTextField();
        dateTextField.setFont(new Font("�L�n����", Font.PLAIN, 18));
        datePanel.add(dateTextField);
        dateTextField.setColumns(15);
        
        JPanel formatPanel = new JPanel();
        contentPane.add(formatPanel);
        
        JLabel formatLabel = new JLabel("��J�榡�G");
        formatLabel.setFont(new Font("�L�n����", Font.PLAIN, 18));
        formatPanel.add(formatLabel);
        
        formatTextField = new JTextField();
        formatTextField.setFont(new Font("�L�n����", Font.PLAIN, 18));
        formatPanel.add(formatTextField);
        formatTextField.setColumns(15);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel);
        
        JButton button = new JButton("����");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("�L�n����", Font.PLAIN, 18));
        buttonPanel.add(button);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        String date = dateTextField.getText();// ��o���
        String format = formatTextField.getText();// ��o�榡
        if (date.length() == 0 || format.length() == 0) {
            JOptionPane.showMessageDialog(this, "����ή榡���ର��", "", JOptionPane.WARNING_MESSAGE);// �p�G����ή榡���ūh���ܨϥΪ̿�J
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);// �إ߫��w�榡��formatter
        try {
            formatter.parse(date);// �Q�Ϋ��w���榡�ѪRdate�ﹳ
        } catch (ParseException pe) {
            JOptionPane.showMessageDialog(this, "����榡������", "", JOptionPane.WARNING_MESSAGE);// �p�G�����h���ܨϥΪ̤�����
            return;
        }
        JOptionPane.showMessageDialog(this, "����榡�ۤ����", "", JOptionPane.WARNING_MESSAGE);// �p�G���h���ܨϥΪ̯���
        return;
    }
    
}
