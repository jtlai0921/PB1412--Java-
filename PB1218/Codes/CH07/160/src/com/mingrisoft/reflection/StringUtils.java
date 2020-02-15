package com.mingrisoft.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class StringUtils {
    @SuppressWarnings("unchecked")
    public String toString(Object object) {
        Class clazz = object.getClass();// ��o�N������O��Class�ﹳ
        StringBuilder sb = new StringBuilder(); // �Q��StringBuilder���x�s�r��
        Package packageName = clazz.getPackage(); // ��o���O�Ҧb���]
        sb.append("�]�W�G" + packageName.getName() + "\t");// ��X���O�Ҧb���]
        String className = clazz.getSimpleName(); // ��o���O��²��W��
        sb.append("���O�W�G" + className + "\n"); // ��X���O��²��W��
        sb.append("���@�غc��k�G\n");
        // ��o�Ҧ��N��غc��k��Constructor�}�C
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String modifier = Modifier.toString(constructor.getModifiers());// ��o��k�׹���
            if (modifier.contains("public")) {// �˵��׹��ŬO�_�t���upublic�v
                sb.append(constructor.toGenericString() + "\n");
            }
        }
        sb.append("���@��G\n");
        Field[] fields = clazz.getDeclaredFields();// ��o�N��Ҧ��쪺Field�}�C
        for (Field field : fields) {
            String modifier = Modifier.toString(field.getModifiers());
            if (modifier.contains("public")) {// �˵��׹��ŬO�_�t���upublic�v
                sb.append(field.toGenericString() + "\n");
            }
        }
        sb.append("���@��k�G\n");
        Method[] methods = clazz.getDeclaredMethods();// ��o�N��Ҧ���k��Method[]�}�C
        for (Method method : methods) {
            String modifier = Modifier.toString(method.getModifiers());
            if (modifier.contains("public")) {// �˵��׹��ŬO�_�t���upublic�v
                sb.append(method.toGenericString() + "\n");
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new StringUtils().toString(new Object()));
    }
}
