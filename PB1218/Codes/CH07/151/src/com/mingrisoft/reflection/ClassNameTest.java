package com.mingrisoft.reflection;

import java.util.Date;

public class ClassNameTest {
    public static void main(String[] args) {
        String dateName = new Date().getClass().getName();// ��o�Ѧҫ��A�W��
        System.out.println("�D�}�C�Ѧҫ��A���W�١G" + dateName);// ��X�Ѧҫ��A�W��
        String byteName = byte.class.getName();// ��o��l���A�W��
        System.out.println("�򥻫��A���W�١G" + byteName);// ��X��l���A�W��
        String oneDimensionArray = new Date[4].getClass().getName();// ��o�@���Ѧҫ��A�}�C
        System.out.println("�@���Ѧҫ��A�}�C�G" + oneDimensionArray);// ��X�@���Ѧҫ��A�}�C�W��
        String twoDimensionArray = new int[4][4].getClass().getName();// ��o�G����l���A
        System.out.println("�G���򥻫��A�}�C�G" + twoDimensionArray);// ��X�G���Ѧҫ��A�}�C�W��
    }
}
