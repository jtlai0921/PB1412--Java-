package com.mingrisoft.reflection;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class NestedClassInformation {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.awt.geom.Point2D");
        Class<?>[] classes = cls.getDeclaredClasses();// 獲得代表內部類別的Class對像組成的陣列
        for (Class<?> clazz : classes) {// 檢查Class對像陣列
            System.out.println("類別的標準名稱：" + clazz.getCanonicalName());
            System.out.println("類別的修飾符：" + Modifier.toString(clazz.getModifiers()));
            Type[] interfaces = clazz.getGenericInterfaces();// 獲得所有泛型接口
            System.out.println("類別所實現的接口：");
            if (interfaces.length != 0) {// 如果泛型接口個數不是0則輸出
                for (Type type : interfaces) {
                    System.out.println("\t" + type);
                }
            } else {
                System.out.println("\t" + "空");
            }
            Type superClass = clazz.getGenericSuperclass();// 獲得直接父類別
            System.out.print("類別的直接繼承類別：");
            if (superClass != null) {// 如果直接父類別不是Object就輸出
                System.out.println(superClass);
            } else {
                System.out.println("空");
            }
        }
    }
}
