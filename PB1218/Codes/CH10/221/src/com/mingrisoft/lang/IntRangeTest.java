package com.mingrisoft.lang;

import java.util.Arrays;

import org.apache.commons.lang.math.IntRange;

public class IntRangeTest {
    public static void main(String[] args) {
        IntRange range = new IntRange(-5, 5);// �إߤ@�ӱq-5��5���϶�
        System.out.println("�϶�����������ƬO�G");
        System.out.println(Arrays.toString(range.toArray()));// ��X�϶������������
        System.out.print("0�O�_�b�϶����G");
        System.out.println(range.containsInteger(0));// �P�_0�O�_�b�϶���
        System.out.print("�϶����W���O�G");
        System.out.println(range.getMaximumInteger());// ��X�϶����W��
        System.out.print("�϶����U���O�G");
        System.out.println(range.getMinimumInteger());// ��X�϶����U��
        System.out.print("�϶����r���ܬO�G");
        System.out.println(range.toString());// ��X�϶����ƾǪ�ܧΦ�
    }
}
