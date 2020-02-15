package com.mingrisoft.reflection;

import java.util.Comparator;

public class ClassComparator implements Comparator<Class<?>> {
    @Override
    // �z�L��{Comparator���f�ӹ�{����\��
    public int compare(Class<?> clazz1, Class<?> clazz2) {
        if (clazz1.equals(clazz2)) {// �p�G������O�ﹳ�ۦP�h�Ǧ^0
            return 0;
        }
        if (clazz1.isAssignableFrom(clazz2)) {
            return -1; // �p�Gclazz1�Ҫ�ܪ����O�Oclazz2�Ҫ�ܪ����O�������O�h�Ǧ^-1
        }
        if (clazz2.isAssignableFrom(clazz1)) {
            return 1; // �p�Gclazz1�Ҫ�ܪ����O�Oclazz2�Ҫ�ܪ����O���l���O�h�Ǧ^1
        }
        throw new IllegalArgumentException("������O�����S�����Y");// ��L���p�ߥX�ҥ~
    }
}