package com.mingrisoft.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee();// 獲得一個Employee對像
        // 獲得Employee對象的屬性值，由於事先並未對其給予值，所以應該為空
        String name = employee.getName();
        String phoneNumber = employee.getPhoneNumber()[0];
        String address = employee.getAddress().get("home");
        // 輸出剛獲得的屬性值
        System.out.println("設定屬性值之前：");
        System.out.println("name屬性：" + name);
        System.out.println("phoneNumber屬性的第一個值：" + phoneNumber);
        System.out.println("address屬性home鍵所對應的值：" + address);
        try {// 使用PropertyUtils類別的相關方法對Employee對象的域給予值
            PropertyUtils.setSimpleProperty(employee, "name", "明日科技");
            PropertyUtils.setIndexedProperty(employee, "phoneNumber", 0, "1234567");
            PropertyUtils.setMappedProperty(employee, "address", "home", "中國");
            // 獲得Employee對象的屬性值，由於剛剛對其給予值，所以應該為不空
            name = (String) PropertyUtils.getSimpleProperty(employee, "name");
            phoneNumber = (String) PropertyUtils.getIndexedProperty(employee, "phoneNumber", 0);
            address = (String) PropertyUtils.getMappedProperty(employee, "address", "home");
            // 輸出剛獲得的屬性值
            System.out.println("設定屬性值之後：");
            System.out.println("name屬性：" + name);
            System.out.println("phoneNumber屬性的第一個值：" + phoneNumber);
            System.out.println("address屬性home鍵所對應的值：" + address);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
