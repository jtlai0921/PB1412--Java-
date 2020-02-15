package com.mingrisoft.math;

import java.util.Random;

import org.apache.commons.math.stat.Frequency;

public class FrequencyTest {
    public static void main(String[] args) {
        Frequency frequency = new Frequency();
        for (int i = 0; i < 100; i++) {
            frequency.addValue(new Random().nextInt(10));// �W�[100�Ӥp��10���H����
        }
        System.out.println("�W�פ��G�����");
        for (int i = 0; i < 10; i++) {// ���0~9�C�Ӽƭ�ø�s�����
            System.out.print("�ƭ�" + i + "���W�סG");
            for (int j = 0; j < frequency.getCount(i); j++) {// ��J���P�ӬP���Ӫ�ܤ��P���W��
                System.out.print("*");
            }
            System.out.println("\t" + frequency.getCumFreq(i));// ��X�֭p�W��
        }
    }
}
