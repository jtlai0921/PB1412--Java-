package com.mingrisoft.thread;

public class TempThread implements Runnable {// ���եΪ�Runnable���f��{���O
    private int id = 0;
    
    @Override
    public void run() {// run()��k��id���ۼW�B��
        id++;
    }
}