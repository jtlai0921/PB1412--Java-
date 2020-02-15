package com.mingrisoft.thread;

public class Bank {
    // �ϥ�ThreadLocal���O�Ӻ޲z�@���ܼ�account
    private static ThreadLocal<Integer> account = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 100;// ���s�w�qinitialValue()��k�A�Naccount����ȳ]��100
        }
    };
    
    public void deposit(int money) {
        account.set(account.get() + money);// �Q��account��get()�Bset()��k��{�s��
    }
    
    public int getAccount() {// ��o���l�B
        return account.get();
    }
}
