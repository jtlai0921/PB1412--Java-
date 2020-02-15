package com.mingrisoft.thread;

import java.util.concurrent.Callable;

import javax.swing.JTextArea;

public class Transfer implements Callable<Integer> {
    private Bank bank;
    private JTextArea textArea;
    
    public Transfer(Bank bank, JTextArea textArea) {// �Q�Ϋغc��k��l���ܼ�
        this.bank = bank;
        this.textArea = textArea;
    }
    
    public Integer call() {
        for (int i = 0; i < 10; i++) {// �`��10���V��ᤤ�s��
            bank.deposit(10);
            String text = textArea.getText();
            textArea.setText(text + "��᪺�l�B�O�G" + bank.getAccount() + "\n");
        }
        return bank.getAccount();// ��o��᪺�l�B
    }
}
