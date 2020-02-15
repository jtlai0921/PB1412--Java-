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
		setTitle("生日信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel inputPanel = new JPanel();
		contentPane.add(inputPanel, BorderLayout.NORTH);
		inputPanel.setLayout(new GridLayout(1, 2, 5, 5));

		JLabel inputLabel = new JLabel("輸入生日(格式yyyy-MM-dd):");
		inputLabel.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
		inputPanel.add(inputLabel);

		textField = new JTextField();
		textField.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
		inputPanel.add(textField);
		textField.setColumns(10);

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		JButton button = new JButton("查看信息");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
		});
		button.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
		buttonPanel.add(button);

		JPanel messagePanel = new JPanel();
		contentPane.add(messagePanel, BorderLayout.CENTER);
		messagePanel.setLayout(new BorderLayout(0, 0));

		messageTextArea = new JTextArea();
		messageTextArea.setFont(new Font("微軟雅黑", Font.PLAIN, 18));
		messageTextArea.setEditable(false);
		messagePanel.add(messageTextArea, BorderLayout.CENTER);
	}

    protected void do_button_actionPerformed(ActionEvent e) {
        String input = textField.getText();//獲得使用者輸入的日期
        //省略驗證程式碼
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//設定解析日期的格式
        Calendar birthday = new GregorianCalendar();//獲得目前日期的日曆
        try {
            birthday.setTime(format.parse(input));//解析日期，並將結果儲存到birthday中
        } catch (ParseException e1) {
            //省略提示資訊程式碼
        }
        Calendar today = new GregorianCalendar();//獲得目前日期的日曆
        int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);//獲得年齡
        String[] weekdays = new DateFormatSymbols().getWeekdays();//獲得一週各天的名字
        StringBuilder message = new StringBuilder();
        message.append("您出生的星期是" + weekdays[birthday.get(Calendar.DAY_OF_WEEK)] + "\n");
        birthday.set(Calendar.YEAR, today.get(Calendar.YEAR));
        message.append("您現在的年齡是" + (birthday.after(today) ? age - 1 : age) + "歲" + "\n");
        message.append("您今年的生日是" + weekdays[birthday.get(Calendar.DAY_OF_WEEK)] + "\n");
        messageTextArea.setText(message.toString());//將字串顯示在文字框中
    }
}