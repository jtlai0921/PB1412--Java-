package com.mingrisoft.thread;

import javax.swing.JTextArea;

public class Transfer implements Runnable {

	private Bank bank;
	private JTextArea textArea;

	public Transfer(Bank bank, JTextArea textArea) {
		this.bank = bank;
		this.textArea = textArea;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			bank.deposit(10);
			String text = textArea.getText();
			textArea.setText(text + "½ã¤áªº¾lÃB¬O¡G" + bank.getAccount() + "\n");
		}
	}
}