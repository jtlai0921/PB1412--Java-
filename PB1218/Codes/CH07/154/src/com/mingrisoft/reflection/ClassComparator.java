package com.mingrisoft.reflection;

import java.util.Comparator;

public class ClassComparator implements Comparator<Class<?>> {
    @Override
    // 透過實現Comparator接口來實現比較功能
    public int compare(Class<?> clazz1, Class<?> clazz2) {
        if (clazz1.equals(clazz2)) {// 如果兩個類別對像相同則傳回0
            return 0;
        }
        if (clazz1.isAssignableFrom(clazz2)) {
            return -1; // 如果clazz1所表示的類別是clazz2所表示的類別的父類別則傳回-1
        }
        if (clazz2.isAssignableFrom(clazz1)) {
            return 1; // 如果clazz1所表示的類別是clazz2所表示的類別的子類別則傳回1
        }
        throw new IllegalArgumentException("兩個類別之間沒有關係");// 其他情況拋出例外
    }
}