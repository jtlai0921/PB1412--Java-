package com.mingrisoft.exceptions;

public class ExceptionTest {
    public static void main(String[] args) {
        Object array[] = new String[3]; // �n���@�Ӫ��׬�3��Object���A���}�C
        array[0] = new Integer(1); // �N�}�C���Ĥ@�Ӥ��������Ȭ���ƹﹳ1
        System.out.println(array[0]); // ��X�}�C���Ĥ@�Ӥ���
    }
}
