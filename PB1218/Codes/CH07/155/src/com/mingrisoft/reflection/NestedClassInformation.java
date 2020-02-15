package com.mingrisoft.reflection;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class NestedClassInformation {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.awt.geom.Point2D");
        Class<?>[] classes = cls.getDeclaredClasses();// ��o�N�������O��Class�ﹳ�զ����}�C
        for (Class<?> clazz : classes) {// �ˬdClass�ﹳ�}�C
            System.out.println("���O���зǦW�١G" + clazz.getCanonicalName());
            System.out.println("���O���׹��šG" + Modifier.toString(clazz.getModifiers()));
            Type[] interfaces = clazz.getGenericInterfaces();// ��o�Ҧ��x�����f
            System.out.println("���O�ҹ�{�����f�G");
            if (interfaces.length != 0) {// �p�G�x�����f�ӼƤ��O0�h��X
                for (Type type : interfaces) {
                    System.out.println("\t" + type);
                }
            } else {
                System.out.println("\t" + "��");
            }
            Type superClass = clazz.getGenericSuperclass();// ��o���������O
            System.out.print("���O�������~�����O�G");
            if (superClass != null) {// �p�G���������O���OObject�N��X
                System.out.println(superClass);
            } else {
                System.out.println("��");
            }
        }
    }
}
