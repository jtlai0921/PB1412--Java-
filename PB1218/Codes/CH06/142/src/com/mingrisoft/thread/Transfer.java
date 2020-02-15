package com.mingrisoft.thread;

import java.util.concurrent.Callable;

import javax.swing.JTextArea;

public class Transfer implements Callable<Integer> {
    private Bank bank;
    private JTextArea textArea;
    
    public Transfer(Bank bank, JTextArea textArea) {// 利用建構方法初始化變數
        this.bank = bank;
        this.textArea = textArea;
    }
    
    public Integer call() {
        for (int i = 0; i < 10; i++) {// 循環10次向賬戶中存錢
            bank.deposit(10);
            String text = textArea.getText();
            textArea.setText(text + "賬戶的餘額是：" + bank.getAccount() + "\n");
        }
        return bank.getAccount();// 獲得賬戶的餘額
    }
}
