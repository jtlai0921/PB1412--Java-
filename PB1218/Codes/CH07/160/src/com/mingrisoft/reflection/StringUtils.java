package com.mingrisoft.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class StringUtils {
    @SuppressWarnings("unchecked")
    public String toString(Object object) {
        Class clazz = object.getClass();// 獲得代表該類別的Class對像
        StringBuilder sb = new StringBuilder(); // 利用StringBuilder來儲存字串
        Package packageName = clazz.getPackage(); // 獲得類別所在的包
        sb.append("包名：" + packageName.getName() + "\t");// 輸出類別所在的包
        String className = clazz.getSimpleName(); // 獲得類別的簡單名稱
        sb.append("類別名：" + className + "\n"); // 輸出類別的簡單名稱
        sb.append("公共建構方法：\n");
        // 獲得所有代表建構方法的Constructor陣列
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String modifier = Modifier.toString(constructor.getModifiers());// 獲得方法修飾符
            if (modifier.contains("public")) {// 檢視修飾符是否含有「public」
                sb.append(constructor.toGenericString() + "\n");
            }
        }
        sb.append("公共域：\n");
        Field[] fields = clazz.getDeclaredFields();// 獲得代表所有域的Field陣列
        for (Field field : fields) {
            String modifier = Modifier.toString(field.getModifiers());
            if (modifier.contains("public")) {// 檢視修飾符是否含有「public」
                sb.append(field.toGenericString() + "\n");
            }
        }
        sb.append("公共方法：\n");
        Method[] methods = clazz.getDeclaredMethods();// 獲得代表所有方法的Method[]陣列
        for (Method method : methods) {
            String modifier = Modifier.toString(method.getModifiers());
            if (modifier.contains("public")) {// 檢視修飾符是否含有「public」
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