package com.mingrisoft.thread;

public class Worker implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("�mJava�s�{����n��" + i + "����s�I");// �ϥΪ̽u�{�Ψӿ�X�@�Ǳԭz
        }
    }
}