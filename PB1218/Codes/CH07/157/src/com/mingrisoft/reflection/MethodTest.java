package com.mingrisoft.reflection;

import java.lang.reflect.Method;

public class MethodTest {
    public static void main(String[] args) {
        try {
            System.out.println("�I�sMath���O���R�A��ksin()");
            Method sin = Math.class.getDeclaredMethod("sin", Double.TYPE);
            Double sin1 = (Double) sin.invoke(null, new Integer(1));
            System.out.println("1�������ȬO�G" + sin1);
            System.out.println("�I�sString���O���D�R�A��kequals()");
            Method equals = String.class.getDeclaredMethod("equals", Object.class);
            Boolean mrsoft = (Boolean) equals.invoke(new String("������"), "������");
            System.out.println("�r��O�_�O�����ޡG" + mrsoft);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
