package com.mingrisoft.thread;

public class ThreadState implements Runnable {
    public synchronized void waitForASecond() throws InterruptedException {
        wait(500); // �ϥثe�u�{����0.5��Ψ�L�u�{�I�snotify()��notifyAll()��k
    }
    
    public synchronized void waitForYears() throws InterruptedException {
        wait(); // �ϥثe�u�{�ä[���ݡA�����L�u�{�I�snotify()��notifyAll()��k
    }
    
    public synchronized void notifyNow() throws InterruptedException {
        notify(); // ����ѩI�swait()��k�i�J���ݪ��A���u�{
    }
    
    public void run() {
        try {
            waitForASecond(); // �b�s�u�{������waitForASecond()��k
            waitForYears(); // �b�s�u�{������waitForYears()��k
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
