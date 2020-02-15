package com.mingrisoft.thread;

public class JoinThread {
    
    public static void main(String[] args) {
        Thread thread = new Thread(new EmergencyThread());
        thread.start();
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("���`���p�G" + i + "�����X�o�I");
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}