package com.mingrisoft.exceptions;

import java.util.Arrays;

public class ExceptionTest {
    public static void main(String[] args) {
        int[] array = new int[5]; // �n���@�Ӫ��׬�5����ư}�C
        Arrays.fill(array, 8); // �N�s�n�����}�C�Ҧ����������Ȭ�8
        for (int i = 0; i < 6; i++) {// �ˬd��X�Ҧ��}�C����
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }
}
