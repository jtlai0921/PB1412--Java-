package com.mingrisoft.lang;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

public class ArrayUtilsTest {
    public static void main(String[] args) {
        int[] array0 = { 1, 2, 3, 2, 1 };// �b�w�q�}�C�ɹ�{��l��
        System.out.println("�}�C���������O�G");
        System.out.println(Arrays.toString(array0));// ��X�}�C������������
        System.out.println("�R���̫�@�Ӥ���");
        int[] array1 = ArrayUtils.remove(array0, 4);// �R�����ެ�4������
        System.out.println("�}�C���������O�G");
        System.out.println(Arrays.toString(array1));// ��X�s�}�C������������
        System.out.println("�R������2");
        int[] array2 = ArrayUtils.removeElement(array0, 2);// �R������2
        System.out.println("�}�C���������O�G");
        System.out.println(Arrays.toString(array2));// ��X�s�}�C������������
    }
}
