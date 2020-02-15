package com.mingrisoft.thread;

public class TempThread implements Runnable {// 測試用的Runnable接口實現類別
    private int id = 0;
    
    @Override
    public void run() {// run()方法給id做自增運算
        id++;
    }
}