package com.mingrisoft.thread;

public class Bank {
    private int account = 100;// ���]��᪺��l���B�O100
    
    public void deposit(int money) {// �V���s������k
        account += money;
    }
    
    public int getAccount() {// ��o�����B����k
        return account;
    }
}
