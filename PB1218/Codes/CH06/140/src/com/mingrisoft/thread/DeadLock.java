package com.mingrisoft.thread;

public class DeadLock implements Runnable {
    private boolean flag;// �ϥ�flag�ܼƧ@���i�J���P�����лx
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();
    
    public void run() {
        String threadName = Thread.currentThread().getName();// ��o�ثe�u�{���W�r
        System.out.println(threadName + ": flag = " + flag);// ��X�ثe�u�{��flag�ܼƭ�
        if (flag == true) {
            synchronized (o1) {// ��o1�[��
                try {
                    Thread.sleep(1000);// �u�{��v1����
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + "�i�J�P�B��o1�ǳƶi�Jo2");// ��ܶi�Jo1��
                System.out.println(threadName + "�w�g�i�J�P�B��o2");// ��ܶi�Jo2��
            }
            if (flag == false) {
                synchronized (o2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(threadName + "�i�J�P�B��o2�ǳƶi�Jo1");// ��ܶi�Jo2��
                    synchronized (o1) {
                        System.out.println(threadName + "�w�g�i�J�P�B��o1");// ��ܶi�Jo1��
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        DeadLock d1 = new DeadLock();// �إ�DeadLock�ﹳd1
        DeadLock d2 = new DeadLock();// �إ�DeadLock�ﹳd2
        d1.flag = true; // �Nd1��flag�]�w��true
        d2.flag = false; // �Nd2��flag�]�w��false
        new Thread(d1).start();// �b�s�u�{������d1��run()��k
        new Thread(d2).start();// �b�s�u�{������d2��run()��k
    }
}
