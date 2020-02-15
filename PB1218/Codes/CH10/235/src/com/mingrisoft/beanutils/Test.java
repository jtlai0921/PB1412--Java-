package com.mingrisoft.beanutils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;

public class Test {
    public static void main(String[] args) {
        DynaProperty[] properties = new DynaProperty[3];// 聲明儲存3個屬性值的陣列
        // 指定屬性名稱和型態
        properties[0] = new DynaProperty("name", String.class);
        properties[1] = new DynaProperty("phoneNumber", String[].class, String.class);
        properties[2] = new DynaProperty("address", Map.class, String.class);
        BasicDynaClass dynaClass = new BasicDynaClass("employee", null, properties);
        DynaBean employee = null;
        try {
            employee = dynaClass.newInstance();// 獲得DynaBean的實例
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        // 為屬性給予值
        employee.set("name", "明日科技");
        employee.set("phoneNumber", new String[10]);// 索引型態要先初始化
        employee.set("phoneNumber", 0, "1234567");
        employee.set("address", new HashMap<String, String>());// 映射型態要先初始化
        employee.set("address", "home", "中國");
        String name = (String) employee.get("name");
        String phoneNumber = (String) employee.get("phoneNumber", 0);
        String address = (String) employee.get("address", "home");
        // 輸出屬性值
        System.out.println("新增JavaBean的name屬性：" + name);
        System.out.println("新增JavaBean的phoneNumber屬性的第一個值：" + phoneNumber);
        System.out.println("新增JavaBean的address屬性home鍵所對應的值：" + address);
    }
}
