package com.mingrisoft.thread;

public class Timer implements Runnable {
    public void run() {
        long currentTime = System.currentTimeMillis();// ��o�t�Υثe�ɶ�
        long processTime = 0;// �]�w�t�ΰ���ɶ���0
        while (true) {// �p�G�t�ΰ���ɶ��o���ܤƴN��X
            if ((System.currentTimeMillis() - currentTime) > processTime) {
                processTime = System.currentTimeMillis() - currentTime;
                System.out.println("�{������ɶ��G" + processTime);
            }
        }
    }
}