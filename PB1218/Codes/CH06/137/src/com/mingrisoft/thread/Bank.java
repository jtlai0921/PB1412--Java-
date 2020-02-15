package com.mingrisoft.thread;

public class Bank {
    // 使用ThreadLocal類別來管理共享變數account
    private static ThreadLocal<Integer> account = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 100;// 重新定義initialValue()方法，將account的初值設為100
        }
    };
    
    public void deposit(int money) {
        account.set(account.get() + money);// 利用account的get()、set()方法實現存錢
    }
    
    public int getAccount() {// 獲得賬戶餘額
        return account.get();
    }
}
