package com.mingrisoft.time;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Birthday extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7168326951841017566L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea messageTextArea;

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
					Birthday frame = new Birthday();
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
	public Birthday() {
		setTitle("�ͤ�H��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel inputPanel = new JPanel();
		contentPane.add(inputPanel, BorderLayout.NORTH);
		inputPanel.setLayout(new GridLayout(1, 2, 5, 5));

		JLabel inputLabel = new JLabel("��J�ͤ�(�榡yyyy-MM-dd):");
		inputLabel.setFont(new Font("�L�n����", Font.PLAIN, 16));
		inputPanel.add(inputLabel);

		textField = new JTextField();
		textField.setFont(new Font("�L�n����", Font.PLAIN, 16));
		inputPanel.add(textField);
		textField.setColumns(10);

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		JButton button = new JButton("�d�ݫH��");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
		});
		button.setFont(new Font("�L�n����", Font.PLAIN, 16));
		buttonPanel.add(button);

		JPanel messagePanel = new JPanel();
		contentPane.add(messagePanel, BorderLayout.CENTER);
		messagePanel.setLayout(new BorderLayout(0, 0));

		messageTextArea = new JTextArea();
		messageTextArea.setFont(new Font("�L�n����", Font.PLAIN, 18));
		messageTextArea.setEditable(false);
		messagePanel.add(messageTextArea, BorderLayout.CENTER);
	}

    protected void do_button_actionPerformed(ActionEvent e) {
        String input = textField.getText();//��o�ϥΪ̿�J�����
        //�ٲ����ҵ{���X
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//�]�w�ѪR������榡
        Calendar birthday = new GregorianCalendar();//��o�ثe��������
        try {
            birthday.setTime(format.parse(input));//�ѪR����A�ñN���G�x�s��birthday��
        } catch (ParseException e1) {
            //�ٲ����ܸ�T�{���X
        }
        Calendar today = new GregorianCalendar();//��o�ثe��������
        int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);//��o�~��
        String[] weekdays = new DateFormatSymbols().getWeekdays();//��o�@�g�U�Ѫ��W�r
        StringBuilder message = new StringBuilder();
        message.append("�z�X�ͪ��P���O" + weekdays[birthday.get(Calendar.DAY_OF_WEEK)] + "\n");
        birthday.set(Calendar.YEAR, today.get(Calendar.YEAR));
        message.append("�z�{�b���~�֬O" + (birthday.after(today) ? age - 1 : age) + "��" + "\n");
        message.append("�z���~���ͤ�O" + weekdays[birthday.get(Calendar.DAY_OF_WEEK)] + "\n");
        messageTextArea.setText(message.toString());//�N�r����ܦb��r�ؤ�
    }
}