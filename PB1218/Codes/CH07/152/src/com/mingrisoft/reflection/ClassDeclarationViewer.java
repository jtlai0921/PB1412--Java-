package com.mingrisoft.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class ClassDeclarationViewer {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.util.ArrayList");// 獲得ArrayList類別對像
        System.out.println("類別的標準名稱：" + clazz.getCanonicalName());
        System.out.println("類別的修飾符：" + Modifier.toString(clazz.getModifiers()));
        // 輸出類別的泛型參數
        TypeVariable<?>[] typeVariables = clazz.getTypeParameters();
        System.out.print("類別的泛型參數：");
        if (typeVariables.length != 0) {
            for (TypeVariable<?> typeVariable : typeVariables) {
                System.out.println(typeVariable + "\t");
            }
        } else {
            System.out.println("空");
        }
        // 輸出類別所實現的所有接口
        Type[] interfaces = clazz.getGenericInterfaces();
        System.out.println("類別所實現的接口：");
        if (interfaces.length != 0) {
            for (Type type : interfaces) {
                System.out.println("\t" + type);
            }
        } else {
            System.out.println("\t" + "空");
        }
        // 輸出類別的直接繼承類別，如果是繼承自Object則傳回空
        Type superClass = clazz.getGenericSuperclass();
        System.out.print("類別的直接繼承類別：");
        if (superClass != null) {
            System.out.println(superClass);
        } else {
            System.out.println("空");
        }
        // 輸出類別的所有註釋資訊，有些註釋資訊是不能用反射獲得的
        Annotation[] annotations = clazz.getAnnotations();
        System.out.print("類別的註釋：");
        if (annotations.length != 0) {
            for (Annotation annotation : annotations) {
                System.out.println("\t" + annotation);
            }
        } else {
            System.out.println("空");
        }
    }
}
