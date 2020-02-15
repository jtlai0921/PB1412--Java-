package com.mingrisoft.reflection;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        Class<?> clazz = student.getClass();// 獲得代表student對象的Class對像
        System.out.println("類別的標準名稱：" + clazz.getCanonicalName());
        try {
            Field id = clazz.getDeclaredField("id");
            System.out.println("設定前的id：" + student.getId());
            id.setAccessible(true);
            id.setInt(student, 10);// 設定Id值為10
            System.out.println("設定後的id：" + student.getId());
            
            Field name = clazz.getDeclaredField("name");
            System.out.println("設定前的name：" + student.getName());
            name.setAccessible(true);
            name.set(student, "明日科技");// 設定name值為明日科技
            System.out.println("設定後的name：" + student.getName());
            
            Field male = clazz.getDeclaredField("male");
            System.out.println("設定前的male：" + student.isMale());
            male.setAccessible(true);
            male.setBoolean(student, true);// 設定male值為true
            System.out.println("設定後的male：" + student.isMale());
            
            Field account = clazz.getDeclaredField("account");
            System.out.println("設定前的account：" + student.getAccount());
            account.setAccessible(true);
            account.setDouble(student, 12.34);// 設定account值為12.34
            System.out.println("設定後的account：" + student.getAccount());
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