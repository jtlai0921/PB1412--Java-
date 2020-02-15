package com.mingrisoft.thread;

public class Worker implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("《Java編程詞典》第" + i + "次更新！");// 使用者線程用來輸出一些敘述
        }
    }
}