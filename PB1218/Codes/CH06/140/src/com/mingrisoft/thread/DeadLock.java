package com.mingrisoft.thread;

public class DeadLock implements Runnable {
    private boolean flag;// 使用flag變數作為進入不同塊的標誌
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();
    
    public void run() {
        String threadName = Thread.currentThread().getName();// 獲得目前線程的名字
        System.out.println(threadName + ": flag = " + flag);// 輸出目前線程的flag變數值
        if (flag == true) {
            synchronized (o1) {// 為o1加鎖
                try {
                    Thread.sleep(1000);// 線程休眠1秒鐘
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + "進入同步塊o1準備進入o2");// 顯示進入o1塊
                System.out.println(threadName + "已經進入同步塊o2");// 顯示進入o2塊
            }
            if (flag == false) {
                synchronized (o2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(threadName + "進入同步塊o2準備進入o1");// 顯示進入o2塊
                    synchronized (o1) {
                        System.out.println(threadName + "已經進入同步塊o1");// 顯示進入o1塊
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        DeadLock d1 = new DeadLock();// 建立DeadLock對像d1
        DeadLock d2 = new DeadLock();// 建立DeadLock對像d2
        d1.flag = true; // 將d1的flag設定為true
        d2.flag = false; // 將d2的flag設定為false
        new Thread(d1).start();// 在新線程中執行d1的run()方法
        new Thread(d2).start();// 在新線程中執行d2的run()方法
    }
}
