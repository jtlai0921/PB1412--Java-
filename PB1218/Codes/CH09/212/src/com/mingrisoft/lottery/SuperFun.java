package com.mingrisoft.lottery;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SuperFun extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6787592245621788484L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    
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
                    SuperFun frame = new SuperFun();
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
    public SuperFun() {
        setTitle("�j�ֳz���X�ͦ���");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JLabel label = new JLabel("�п�J���X�ӼơG");
        label.setFont(new Font("�L�n����", Font.PLAIN, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);
        
        textField = new JTextField();
        textField.setFont(new Font("�L�n����", Font.PLAIN, 18));
        panel.add(textField);
        textField.setColumns(10);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button = new JButton("�ͦ����X");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setFont(new Font("�L�n����", Font.PLAIN, 18));
        buttonPanel.add(button);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("�L�n����", Font.PLAIN, 18));
        scrollPane.setViewportView(textArea);
    }
    
    protected void do_button_actionPerformed(ActionEvent e) {
        int times = Integer.parseInt(textField.getText());// ��o�ϥΪ̿�J���ݭn���ͪ��������X�Ӽ�
        // �ٲ������ʶR�ƶq�Ӧh���{���X
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < 5; j++) {// �b1~35���H�����5�ӼƦr
                List<Integer> list = new ArrayList<Integer>();
                for (int k = 1; k < 36; k++) {
                    list.add(k);// �N1~35�W�[��C��
                }
                int number = list.get(new Random().nextInt(list.size()));// �H����ܤ@�ӼƦr
                String luckNumber = number < 10 ? "0" + number : "" + number;// �榡�ƼƦr
                sb.append(luckNumber + " ");// �Vsb���W�[�Ʀr
                list.remove(new Integer(number));// �R����ܪ��Ʀr�A�o�˴N�קK�F����
            }
            sb.append("\t\t");
            for (int j = 0; j < 2; j++) {// �b1~12���H�����2�ӼƦr
                List<Integer> list = new ArrayList<Integer>();
                for (int k = 1; k < 13; k++) {
                    list.add(k);// �N1~12�W�[��C��
                }
                int number = list.get(new Random().nextInt(list.size()));
                String luckNumber = number < 10 ? "0" + number : "" + number;// �榡�ƼƦr
                sb.append(luckNumber + " ");// �Vsb���W�[�Ʀr
                list.remove(new Integer(number));// �R����ܪ��Ʀr�A�o�˴N�קK�F����
            }
            sb.append("\n");
        }
        textArea.setText(sb.toString());
    }
    
}
