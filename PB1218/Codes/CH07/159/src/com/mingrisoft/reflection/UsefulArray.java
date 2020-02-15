package com.mingrisoft.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UsefulArray {
    
    public static Object increaseArray(Object array) {
        Class<?> clazz = array.getClass();// ��o�N��}�C��Class�ﹳ
        if (clazz.isArray()) {// �p�G��J�O�@�Ӱ}�C
            Class<?> componentType = clazz.getComponentType();// ��o�}�C���������A
            int length = Array.getLength(array);// ��o��J���}�C������
            Object newArray = Array.newInstance(componentType, length + 5);// �s�W�}�C
            System.arraycopy(array, 0, newArray, 0, length);// �ƻs��Ӱ}�C�����Ҧ����
            return newArray;// �Ǧ^�s�W�}�C
        }
        return null;// �p�G��J�����O�}�C�N�Ǧ^��
    }
    
    public static void main(String[] args) {
        int[] intArray = new int[10];
        System.out.println("��ư}�C��l���׬O�G" + intArray.length);
        Arrays.fill(intArray, 8);
        System.out.println("��ư}�C�����e�G");
        System.out.println(Arrays.toString(intArray));
        int[] newIntArray = (int[]) increaseArray(intArray);
        System.out.println("��ư}�C�X�R����׬O�G" + newIntArray.length);
        System.out.println("��ư}�C�����e�G");
        System.out.println(Arrays.toString(newIntArray));
    }
}
