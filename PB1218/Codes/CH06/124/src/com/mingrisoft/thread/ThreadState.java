package com.mingrisoft.thread;

public class ThreadState implements Runnable {
    public synchronized void waitForASecond() throws InterruptedException {
        wait(500); // 使目前線程等待0.5秒或其他線程呼叫notify()或notifyAll()方法
    }
    
    public synchronized void waitForYears() throws InterruptedException {
        wait(); // 使目前線程永久等待，直到其他線程呼叫notify()或notifyAll()方法
    }
    
    public synchronized void notifyNow() throws InterruptedException {
        notify(); // 喚醒由呼叫wait()方法進入等待狀態的線程
    }
    
    public void run() {
        try {
            waitForASecond(); // 在新線程中執行waitForASecond()方法
            waitForYears(); // 在新線程中執行waitForYears()方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
