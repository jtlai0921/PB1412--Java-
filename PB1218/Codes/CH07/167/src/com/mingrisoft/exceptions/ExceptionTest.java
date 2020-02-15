package com.mingrisoft.exceptions;

import java.lang.reflect.Field;

public class ExceptionTest {
    public static void main(String[] args) {
        Class<?> clazz = String.class;// ��o�N��String���O�����O�ﹳ
        Field[] fields = clazz.getDeclaredFields();// ��oString���O���Ҧ���
        for (Field field : fields) {// �ˬd�Ҧ���
            if (field.getName().equals("hash")) {// �p�G�쪺�W�r�Ohash
                try {
                    System.out.println(field.getInt("hash"));// ��Xhash����
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
