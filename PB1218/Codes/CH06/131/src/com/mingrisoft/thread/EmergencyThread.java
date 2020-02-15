package com.mingrisoft.thread;

public class EmergencyThread implements Runnable {
    
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("緊急情況：" + i + "號車出發！");
        }
    }
}