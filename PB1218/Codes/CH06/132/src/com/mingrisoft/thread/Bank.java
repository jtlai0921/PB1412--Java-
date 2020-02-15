package com.mingrisoft.thread;

public class Bank {
    private int account = 100;// 假設賬戶的初始金額是100
    
    public void deposit(int money) {// 向賬戶存錢的方法
        account += money;
    }
    
    public int getAccount() {// 獲得賬戶金額的方法
        return account;
    }
}
