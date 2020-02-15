package com.mingrisoft.system;

public class Timing {
    public static double round(double value) {
        return Math.round(value * 10.0) / 10.0;// �Q��Math���O��round��k�i��|�ˤ��J�p��
    }
    
    public static String getElapsedText(long elapsedMillis) {
        if (elapsedMillis < 60000) {
            double unit = round(elapsedMillis / 1000.0);// �N�ɶ��ഫ����
            return unit + "��";// �b�ഫ�����ɶ���W�[���
        } else if (elapsedMillis < 60000 * 60) {
            double unit = round(elapsedMillis / 60000.0);// �N�ɶ��ഫ����
            return unit + "��";// �b�ഫ�����ɶ���W�[���
        } else if (elapsedMillis < 60000 * 60 * 24) {
            double unit = round(elapsedMillis / (60000.0 * 60));// �N�ɶ��ഫ����
            return unit + "��";// �b�ഫ�����ɶ���W�[���
        } else {
            double unit = round(elapsedMillis / (60000.0 * 60 * 24));// �N�ɶ��ഫ����
            return unit + "��";// �b�ഫ�����ɶ���W�[���
        }
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println("�{���}�l����ɶ��G" + begin);
        for (int i = 0; i < 1000000000; i++) {
            Math.random();
        }
        long end = System.currentTimeMillis();
        System.out.println("�{����������ɶ��G" + end);
        System.out.println("�{������ɶ��G" + getElapsedText(end - begin));
    }
}
