package com.mingrisoft.exceptions;

import java.lang.reflect.Field;

public class ExceptionTest {
    public static void main(String[] args) {
        Class<?> clazz = String.class;// 獲得代表String類別的類別對像
        Field[] fields = clazz.getDeclaredFields();// 獲得String類別的所有域
        for (Field field : fields) {// 檢查所有域
            if (field.getName().equals("hash")) {// 如果域的名字是hash
                try {
                    System.out.println(field.getInt("hash"));// 輸出hash的值
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
