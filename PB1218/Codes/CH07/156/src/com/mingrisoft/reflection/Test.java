package com.mingrisoft.reflection;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        Class<?> clazz = student.getClass();// ��o�N��student��H��Class�ﹳ
        System.out.println("���O���зǦW�١G" + clazz.getCanonicalName());
        try {
            Field id = clazz.getDeclaredField("id");
            System.out.println("�]�w�e��id�G" + student.getId());
            id.setAccessible(true);
            id.setInt(student, 10);// �]�wId�Ȭ�10
            System.out.println("�]�w�᪺id�G" + student.getId());
            
            Field name = clazz.getDeclaredField("name");
            System.out.println("�]�w�e��name�G" + student.getName());
            name.setAccessible(true);
            name.set(student, "������");// �]�wname�Ȭ�������
            System.out.println("�]�w�᪺name�G" + student.getName());
            
            Field male = clazz.getDeclaredField("male");
            System.out.println("�]�w�e��male�G" + student.isMale());
            male.setAccessible(true);
            male.setBoolean(student, true);// �]�wmale�Ȭ�true
            System.out.println("�]�w�᪺male�G" + student.isMale());
            
            Field account = clazz.getDeclaredField("account");
            System.out.println("�]�w�e��account�G" + student.getAccount());
            account.setAccessible(true);
            account.setDouble(student, 12.34);// �]�waccount�Ȭ�12.34
            System.out.println("�]�w�᪺account�G" + student.getAccount());
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
