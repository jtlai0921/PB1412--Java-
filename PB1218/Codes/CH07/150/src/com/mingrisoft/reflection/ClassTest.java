package com.mingrisoft.reflection;

import java.util.Date;

public class ClassTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("第1種方法：Object.getClass()");
        Class c1 = new Date().getClass();// 使用getClass()方式獲得Class對像
        System.out.println(c1.getName());// 輸出對像名稱
        System.out.println("第2種方法：.class語法");
        Class c2 = boolean.class;// 使用.class語法獲得Class對像
        System.out.println(c2.getName());// 輸出對像名稱
        System.out.println("第3種方法：Class.forName()");
        Class c3 = Class.forName("java.lang.String");// 使用Class.forName()獲得Class對像
        System.out.println(c3.getName());// 輸出對像名稱
        System.out.println("第4種方法：包裝類別的TYPE域");
        Class c4 = Double.TYPE;// 使用包裝類別獲得Class對像
        System.out.println(c4.getName());// 輸出對像名稱
    }
}
