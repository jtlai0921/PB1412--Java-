package com.mingrisoft.thread;

public class Timer implements Runnable {
    public void run() {
        long currentTime = System.currentTimeMillis();// 獲得系統目前時間
        long processTime = 0;// 設定系統執行時間為0
        while (true) {// 如果系統執行時間發生變化就輸出
            if ((System.currentTimeMillis() - currentTime) > processTime) {
                processTime = System.currentTimeMillis() - currentTime;
                System.out.println("程式執行時間：" + processTime);
            }
        }
    }
}