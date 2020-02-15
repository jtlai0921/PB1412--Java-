package com.mingrisoft.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class ClassDeclarationViewer {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.util.ArrayList");// ��oArrayList���O�ﹳ
        System.out.println("���O���зǦW�١G" + clazz.getCanonicalName());
        System.out.println("���O���׹��šG" + Modifier.toString(clazz.getModifiers()));
        // ��X���O���x���Ѽ�
        TypeVariable<?>[] typeVariables = clazz.getTypeParameters();
        System.out.print("���O���x���ѼơG");
        if (typeVariables.length != 0) {
            for (TypeVariable<?> typeVariable : typeVariables) {
                System.out.println(typeVariable + "\t");
            }
        } else {
            System.out.println("��");
        }
        // ��X���O�ҹ�{���Ҧ����f
        Type[] interfaces = clazz.getGenericInterfaces();
        System.out.println("���O�ҹ�{�����f�G");
        if (interfaces.length != 0) {
            for (Type type : interfaces) {
                System.out.println("\t" + type);
            }
        } else {
            System.out.println("\t" + "��");
        }
        // ��X���O�������~�����O�A�p�G�O�~�Ӧ�Object�h�Ǧ^��
        Type superClass = clazz.getGenericSuperclass();
        System.out.print("���O�������~�����O�G");
        if (superClass != null) {
            System.out.println(superClass);
        } else {
            System.out.println("��");
        }
        // ��X���O���Ҧ�������T�A���ǵ�����T�O����ΤϮg��o��
        Annotation[] annotations = clazz.getAnnotations();
        System.out.print("���O�������G");
        if (annotations.length != 0) {
            for (Annotation annotation : annotations) {
                System.out.println("\t" + annotation);
            }
        } else {
            System.out.println("��");
        }
    }
}
