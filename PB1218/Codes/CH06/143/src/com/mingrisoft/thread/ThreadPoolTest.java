package com.mingrisoft.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();// �إ�Runtime�ﹳ
        run.gc();// ����U���^�����A�o�˥i�H��ֻ~�t
        long freeMemory = run.freeMemory();// ��o�ثe���������Ŷ��O����
        long currentTime = System.currentTimeMillis();// ��o�ثe���������ɶ�
        for (int i = 0; i < 10000; i++) {// �W�߰���1000�ӽu�{
            new Thread(new TempThread()).start();
        }
        System.out.println("�W�߰���1000�ӽu�{�Ҧ��Ϊ��O����G" + (freeMemory - run.freeMemory()) + "�r�`");// �˵��O���骺�ܤ�
        System.out.println("�W�߫إ�1000�ӽu�{�Ү��Ӫ��ɶ��G" + (System.currentTimeMillis() - currentTime) + "�@��");// �˵��ɶ����ܤ�
        
        run.gc();// ����U���^����
        freeMemory = run.freeMemory();// ��o�ثe���������Ŷ��O����
        currentTime = System.currentTimeMillis();// ��o�ثe���������ɶ�
        ExecutorService executorService = Executors.newFixedThreadPool(2);// �إ߽u�{��
        for (int i = 0; i < 1000; i++) {// �ϥνu�{������1000�ӽu�{
            executorService.submit(new TempThread());
        }
        System.out.println("�ϥγs��������1000�ӽu�{�Ҧ��Ϊ��O����G" + (freeMemory - run.freeMemory()) + "�r�`");// �˵��O���骺�ܤ�
        System.out.println("�ϥγs�����إ�1000�ӽu�{�Ү��Ӫ��ɶ��G" + (System.currentTimeMillis() - currentTime) + "�@��");// �˵��ɶ����ܤ�
    }
}
