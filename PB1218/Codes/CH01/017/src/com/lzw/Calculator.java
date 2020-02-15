package com.lzw;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Calculator extends JFrame {

	private JTextField textField;
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public Calculator() {
		super();
		getContentPane().setLayout(null);
		setBounds(100, 100, 355, 255);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textField = new JTextField();
		textField.setBounds(10, 10, 321, 22);
		getContentPane().add(textField);

		final JButton sqrtButton = new JButton();
		sqrtButton.setForeground(Color.RED);
		sqrtButton.setText("/");
		sqrtButton.setBounds(225, 76, 41, 28);
		getContentPane().add(sqrtButton);

		final JButton sqrtButton_1 = new JButton();
		sqrtButton_1.setForeground(Color.RED);
		sqrtButton_1.setText("*");
		sqrtButton_1.setBounds(225, 110, 41, 28);
		getContentPane().add(sqrtButton_1);

		final JButton sqrtButton_2 = new JButton();
		sqrtButton_2.setForeground(Color.RED);
		sqrtButton_2.setText("-");
		sqrtButton_2.setBounds(225, 144, 41, 28);
		getContentPane().add(sqrtButton_2);

		final JButton sqrtButton_3 = new JButton();
		sqrtButton_3.setForeground(Color.RED);
		sqrtButton_3.setText("+");
		sqrtButton_3.setBounds(225, 178, 41, 28);
		getContentPane().add(sqrtButton_3);

		final JButton sqrtButton_4 = new JButton();
		sqrtButton_4.setMargin(new Insets(2, 2, 2, 2));
		sqrtButton_4.setForeground(Color.BLUE);
		sqrtButton_4.setText("sqrt");
		sqrtButton_4.setBounds(274, 75, 57, 28);
		getContentPane().add(sqrtButton_4);

		final JButton sqrtButton_1_1 = new JButton();
		sqrtButton_1_1.setForeground(Color.BLUE);
		sqrtButton_1_1.setText("%");
		sqrtButton_1_1.setBounds(274, 109, 57, 28);
		getContentPane().add(sqrtButton_1_1);

		final JButton sqrtButton_2_1 = new JButton();
		sqrtButton_2_1.setForeground(Color.BLUE);
		sqrtButton_2_1.setText("1/x");
		sqrtButton_2_1.setBounds(274, 143, 57, 28);
		getContentPane().add(sqrtButton_2_1);

		final JButton sqrtButton_3_1 = new JButton();
		sqrtButton_3_1.setForeground(Color.RED);
		sqrtButton_3_1.setText("=");
		sqrtButton_3_1.setBounds(274, 177, 57, 28);
		getContentPane().add(sqrtButton_3_1);

		final JButton sqrtButton_7 = new JButton();
		sqrtButton_7.setForeground(Color.RED);
		sqrtButton_7.setText("MC");
		sqrtButton_7.setBounds(10, 76, 57, 28);
		getContentPane().add(sqrtButton_7);

		final JButton sqrtButton_1_4 = new JButton();
		sqrtButton_1_4.setForeground(Color.RED);
		sqrtButton_1_4.setText("MR");
		sqrtButton_1_4.setBounds(10, 110, 57, 28);
		getContentPane().add(sqrtButton_1_4);

		final JButton sqrtButton_2_4 = new JButton();
		sqrtButton_2_4.setForeground(Color.RED);
		sqrtButton_2_4.setText("MS");
		sqrtButton_2_4.setBounds(10, 144, 57, 28);
		getContentPane().add(sqrtButton_2_4);

		final JButton sqrtButton_3_4 = new JButton();
		sqrtButton_3_4.setForeground(Color.RED);
		sqrtButton_3_4.setText("M+");
		sqrtButton_3_4.setBounds(10, 178, 57, 28);
		getContentPane().add(sqrtButton_3_4);

		final JButton sqrtButton_5 = new JButton();
		sqrtButton_5.setForeground(Color.BLUE);
		sqrtButton_5.setText("9");
		sqrtButton_5.setBounds(175, 76, 41, 28);
		getContentPane().add(sqrtButton_5);

		final JButton sqrtButton_1_2 = new JButton();
		sqrtButton_1_2.setForeground(Color.BLUE);
		sqrtButton_1_2.setText("6");
		sqrtButton_1_2.setBounds(175, 110, 41, 28);
		getContentPane().add(sqrtButton_1_2);

		final JButton sqrtButton_2_2 = new JButton();
		sqrtButton_2_2.setForeground(Color.BLUE);
		sqrtButton_2_2.setText("3");
		sqrtButton_2_2.setBounds(175, 144, 41, 28);
		getContentPane().add(sqrtButton_2_2);

		final JButton sqrtButton_3_2 = new JButton();
		sqrtButton_3_2.setForeground(Color.BLUE);
		sqrtButton_3_2.setText(".");
		sqrtButton_3_2.setBounds(175, 178, 41, 28);
		getContentPane().add(sqrtButton_3_2);

		final JButton sqrtButton_6 = new JButton();
		sqrtButton_6.setForeground(Color.BLUE);
		sqrtButton_6.setText("8");
		sqrtButton_6.setBounds(125, 76, 41, 28);
		getContentPane().add(sqrtButton_6);

		final JButton sqrtButton_1_3 = new JButton();
		sqrtButton_1_3.setForeground(Color.BLUE);
		sqrtButton_1_3.setText("5");
		sqrtButton_1_3.setBounds(125, 110, 41, 28);
		getContentPane().add(sqrtButton_1_3);

		final JButton sqrtButton_2_3 = new JButton();
		sqrtButton_2_3.setForeground(Color.BLUE);
		sqrtButton_2_3.setText("2");
		sqrtButton_2_3.setBounds(125, 144, 41, 28);
		getContentPane().add(sqrtButton_2_3);

		final JButton sqrtButton_3_3 = new JButton();
		sqrtButton_3_3.setForeground(Color.BLUE);
		sqrtButton_3_3.setMargin(new Insets(2, 2, 2, 2));
		sqrtButton_3_3.setText("+/-");
		sqrtButton_3_3.setBounds(125, 178, 41, 28);
		getContentPane().add(sqrtButton_3_3);

		final JButton sqrtButton_8 = new JButton();
		sqrtButton_8.setForeground(Color.BLUE);
		sqrtButton_8.setText("7");
		sqrtButton_8.setBounds(75, 76, 41, 28);
		getContentPane().add(sqrtButton_8);

		final JButton sqrtButton_1_5 = new JButton();
		sqrtButton_1_5.setForeground(Color.BLUE);
		sqrtButton_1_5.setText("4");
		sqrtButton_1_5.setBounds(75, 110, 41, 28);
		getContentPane().add(sqrtButton_1_5);

		final JButton sqrtButton_2_5 = new JButton();
		sqrtButton_2_5.setForeground(Color.BLUE);
		sqrtButton_2_5.setText("1");
		sqrtButton_2_5.setBounds(75, 144, 41, 28);
		getContentPane().add(sqrtButton_2_5);

		final JButton sqrtButton_3_5 = new JButton();
		sqrtButton_3_5.setForeground(Color.BLUE);
		sqrtButton_3_5.setText("0");
		sqrtButton_3_5.setBounds(75, 178, 41, 28);
		getContentPane().add(sqrtButton_3_5);

		final JButton backspacesButton = new JButton();
		backspacesButton.setForeground(Color.RED);
		backspacesButton.setMargin(new Insets(2, 2, 2, 2));
		backspacesButton.setText("Backspace");
		backspacesButton.setBounds(75, 38, 86, 28);
		getContentPane().add(backspacesButton);

		final JButton backspacesButton_1 = new JButton();
		backspacesButton_1.setForeground(Color.RED);
		backspacesButton_1.setMargin(new Insets(2, 2, 2, 2));
		backspacesButton_1.setText("CE");
		backspacesButton_1.setBounds(167, 38, 80, 28);
		getContentPane().add(backspacesButton_1);

		final JButton backspacesButton_2 = new JButton();
		backspacesButton_2.setForeground(Color.RED);
		backspacesButton_2.setMargin(new Insets(2, 2, 2, 2));
		backspacesButton_2.setText("C");
		backspacesButton_2.setBounds(253, 38, 78, 28);
		getContentPane().add(backspacesButton_2);
		//
	}

}
