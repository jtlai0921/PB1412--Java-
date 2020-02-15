package com.mingrisoft.thread;

import javax.swing.JTextArea;

public class Transfer implements Runnable {
    private Bank bank;
    private JTextArea textArea;
    
    public Transfer(Bank bank, JTextArea textArea) {// 利用建構方法初始化變數
        this.bank = bank;
        this.textArea = textArea;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {// 循環10次向賬戶存錢
            bank.deposit(10);// 向賬戶存入10塊錢
            String text = textArea.getText();// 獲得文字域內容
            textArea.setText(text + "賬戶的餘額是：" + bank.getAccount() + "\n");
        }
    }
}
