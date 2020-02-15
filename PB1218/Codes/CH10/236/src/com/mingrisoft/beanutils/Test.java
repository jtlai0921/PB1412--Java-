package com.mingrisoft.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

public class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee();// 聲明Employee變數
        Employee employee2 = new Employee();// 聲明Employee變數
        try {
            // 為employee1給予值
            PropertyUtils.setSimpleProperty(employee1, "name", "明日科技");
            PropertyUtils.setIndexedProperty(employee1, "phoneNumber", 0, "1234567");
            PropertyUtils.setMappedProperty(employee1, "address", "home", "中國");
            BeanUtils.copyProperties(employee2, employee1);// 將employee1複製到employee2
            // 獲得employee2的屬性值
            String name = (String) PropertyUtils.getSimpleProperty(employee2, "name");
            String phoneNumber = (String) PropertyUtils.getIndexedProperty(employee2, "phoneNumber", 0);
            String address = (String) PropertyUtils.getMappedProperty(employee2, "address", "home");
            // 輸出employee2的屬性值
            System.out.println("複製屬性值之後：");
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