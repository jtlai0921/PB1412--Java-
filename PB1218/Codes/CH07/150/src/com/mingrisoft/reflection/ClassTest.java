package com.mingrisoft.reflection;

import java.util.Date;

public class ClassTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("��1�ؤ�k�GObject.getClass()");
        Class c1 = new Date().getClass();// �ϥ�getClass()�覡��oClass�ﹳ
        System.out.println(c1.getName());// ��X�ﹳ�W��
        System.out.println("��2�ؤ�k�G.class�y�k");
        Class c2 = boolean.class;// �ϥ�.class�y�k��oClass�ﹳ
        System.out.println(c2.getName());// ��X�ﹳ�W��
        System.out.println("��3�ؤ�k�GClass.forName()");
        Class c3 = Class.forName("java.lang.String");// �ϥ�Class.forName()��oClass�ﹳ
        System.out.println(c3.getName());// ��X�ﹳ�W��
        System.out.println("��4�ؤ�k�G�]�����O��TYPE��");
        Class c4 = Double.TYPE;// �ϥΥ]�����O��oClass�ﹳ
        System.out.println(c4.getName());// ��X�ﹳ�W��
    }
}
