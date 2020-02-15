package com.mingrisoft.thread;

import javax.swing.JTextArea;

public class Transfer implements Runnable {
    private Bank bank;
    private JTextArea textArea;
    
    public Transfer(Bank bank, JTextArea textArea) {// �Q�Ϋغc��k��l���ܼ�
        this.bank = bank;
        this.textArea = textArea;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {// �`��10���V���s��
            bank.deposit(10);// �V���s�J10����
            String text = textArea.getText();// ��o��r�줺�e
            textArea.setText(text + "��᪺�l�B�O�G" + bank.getAccount() + "\n");
        }
    }
}
