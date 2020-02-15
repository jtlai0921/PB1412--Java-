package com.mingrisoft.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassViewer {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        System.out.println("���O���зǦW�١G" + clazz.getCanonicalName());
        Constructor[] constructors = clazz.getConstructors();// ��o�����O��H���Ҧ��غc��k
        System.out.println("���O���غc��k�G");
        if (constructors.length != 0) {
            for (Constructor constructor : constructors) {
                System.out.println("\t" + constructor);// ��X�غc��k
            }
        } else {
            System.out.println("\t��");
        }
        Field[] fields = clazz.getDeclaredFields();// ��o�����O��H���Ҧ��D�~�Ӱ�
        System.out.println("���O���D�~�Ӱ��ܼơG");
        if (fields.length != 0) {
            for (Field field : fields) {
                System.out.println("\t" + field);// ��X�D�~�Ӱ�
            }
        } else {
            System.out.println("\t��");
        }
        Method[] methods = clazz.getDeclaredMethods();// ��o�����O��H���Ҧ��D�~�Ӥ�k
        System.out.println("���O���D�~�Ӥ�k�G");
        if (methods.length != 0) {
            for (Method method : methods) {
                System.out.println(method);// ��X�D�~�Ӥ�k
            }
        } else {
            System.out.println("\t��");
        }
    }
}
