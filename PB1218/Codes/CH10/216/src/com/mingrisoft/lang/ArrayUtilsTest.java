package com.mingrisoft.lang;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

public class ArrayUtilsTest {
    public static void main(String[] args) {
        int[] array0 = new int[5]; // �إߪ��׬�5��int���A�}�C
        Arrays.fill(array0, 8); // �N�}�C��������������l�Ƭ�8
        System.out.println("�}�C���������O�G");
        System.out.println(Arrays.toString(array0)); // ��X�}�C������������
        System.out.println("�b�}�C���̫�W�[����10");
        int[] array1 = ArrayUtils.add(array0, 10); // �b�}�C���̫�W�[����10
        System.out.println("�}�C���������O�G");
        System.out.println(Arrays.toString(array1)); // ��X�s�}�C������������
        System.out.println("�b�}�C���}�Y�W�[����10");
        int[] array2 = ArrayUtils.add(array0, 0, 10); // �b�}�C���}�Y�W�[����10
        System.out.println("�}�C���������O�G");
        System.out.println(Arrays.toString(array2)); // ��X�s�}�C������������
        System.out.println("�N�s���ͪ���Ӱ}�C�X��");
        int[] array3 = ArrayUtils.addAll(array1, array2);// �X�ַs���ͪ���Ӱ}�C
        System.out.println("�}�C���������O�G");
        System.out.println(Arrays.toString(array3)); // ��X�s�}�C������������
    }
}
