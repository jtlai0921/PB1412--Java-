package com.mingrisoft.exception;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[5];// �w�q���׬�5���}�C
        Arrays.fill(array, 5);// �N�}�C�������������Ȭ�5
        for (int i = 4; i > -1; i--) {// �ˬd��Ӱ}�C
            if (i == 0) {// �p�G��0
                throw new DivideZeroException("���s�ҥ~");// �p�G���s�N�ߥX���ҥ~��T���غc��k
            }// �p�G���O���s�N��X���G
            System.out.println("array[" + i + "] / " + i + " = " + array[i] / i);
        }
    }
}
