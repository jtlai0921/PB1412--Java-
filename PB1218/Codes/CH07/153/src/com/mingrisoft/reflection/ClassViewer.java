package com.mingrisoft.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassViewer {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        System.out.println("類別的標準名稱：" + clazz.getCanonicalName());
        Constructor[] constructors = clazz.getConstructors();// 獲得該類別對象的所有建構方法
        System.out.println("類別的建構方法：");
        if (constructors.length != 0) {
            for (Constructor constructor : constructors) {
                System.out.println("\t" + constructor);// 輸出建構方法
            }
        } else {
            System.out.println("\t空");
        }
        Field[] fields = clazz.getDeclaredFields();// 獲得該類別對象的所有非繼承域
        System.out.println("類別的非繼承域變數：");
        if (fields.length != 0) {
            for (Field field : fields) {
                System.out.println("\t" + field);// 輸出非繼承域
            }
        } else {
            System.out.println("\t空");
        }
        Method[] methods = clazz.getDeclaredMethods();// 獲得該類別對象的所有非繼承方法
        System.out.println("類別的非繼承方法：");
        if (methods.length != 0) {
            for (Method method : methods) {
                System.out.println(method);// 輸出非繼承方法
            }
        } else {
            System.out.println("\t空");
        }
    }
}
