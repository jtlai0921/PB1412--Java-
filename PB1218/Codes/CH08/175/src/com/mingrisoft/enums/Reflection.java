package com.mingrisoft.enums;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflection {
    public static void main(String[] args) {
        Class<Position> enumClass = Position.class;
        String modifiers = Modifier.toString(enumClass.getModifiers());
        System.out.println("enum���A���׹��šG" + modifiers);
        System.out.println("enum���A�������O�G" + enumClass.getSuperclass());
        System.out.println("enum���A���۩w�q��k�G");
        Method[] methods = enumClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
