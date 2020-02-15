package com.mingrisoft.thread;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ThreadState state = new ThreadState();// 建立State對像
        Thread thread = new Thread(state);// 利用State對像建立Thread對像
        System.out.println("新增線程：" + thread.getState());// 輸出線程狀態
        thread.start(); // 呼叫thread對象的start()方法，啟動新線程
        System.out.println("啟動線程：" + thread.getState());// 輸出線程狀態
        Thread.sleep(100); // 目前線程休眠0.1秒，使新線程執行waitForASecond()方法
        System.out.println("計時等待：" + thread.getState());// 輸出線程狀態
        Thread.sleep(1000); // 目前線程休眠1秒，使新線程執行waitForYears()方法
        System.out.println("等待線程：" + thread.getState());// 輸出線程狀態
        state.notifyNow(); // 呼叫state的notifyNow()方法
        System.out.println("喚醒線程：" + thread.getState());// 輸出線程狀態
        Thread.sleep(1000); // 目前線程休眠1秒，使新線程結束
        System.out.println("終止線程：" + thread.getState());// 輸出線程狀態
    }
    
}
