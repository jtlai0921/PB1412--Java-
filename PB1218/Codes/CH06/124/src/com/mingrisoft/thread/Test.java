package com.mingrisoft.thread;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ThreadState state = new ThreadState();// �إ�State�ﹳ
        Thread thread = new Thread(state);// �Q��State�ﹳ�إ�Thread�ﹳ
        System.out.println("�s�W�u�{�G" + thread.getState());// ��X�u�{���A
        thread.start(); // �I�sthread��H��start()��k�A�Ұʷs�u�{
        System.out.println("�Ұʽu�{�G" + thread.getState());// ��X�u�{���A
        Thread.sleep(100); // �ثe�u�{��v0.1��A�Ϸs�u�{����waitForASecond()��k
        System.out.println("�p�ɵ��ݡG" + thread.getState());// ��X�u�{���A
        Thread.sleep(1000); // �ثe�u�{��v1��A�Ϸs�u�{����waitForYears()��k
        System.out.println("���ݽu�{�G" + thread.getState());// ��X�u�{���A
        state.notifyNow(); // �I�sstate��notifyNow()��k
        System.out.println("����u�{�G" + thread.getState());// ��X�u�{���A
        Thread.sleep(1000); // �ثe�u�{��v1��A�Ϸs�u�{����
        System.out.println("�פ�u�{�G" + thread.getState());// ��X�u�{���A
    }
    
}
