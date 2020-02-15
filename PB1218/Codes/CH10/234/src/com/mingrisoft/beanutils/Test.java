package com.mingrisoft.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

public class Test {
    
    public static void main(String[] args) {
        Company company = new Company();
        try {
            PropertyUtils.setNestedProperty(company, "employee.name", "明日科技");
            PropertyUtils.setNestedProperty(company, "employee.phoneNumber[0]", "1234567");
            PropertyUtils.setNestedProperty(company, "employee.address(home)", "中國");
            System.out.println("獲得設定的串聯屬性：");
            String name = (String) PropertyUtils.getNestedProperty(company, "employee.name");
            String phoneNumber = (String) PropertyUtils.getNestedProperty(company, "employee.phoneNumber[0]");
            String address = (String) PropertyUtils.getNestedProperty(company, "employee.address(home)");
            System.out.println("employee.name = " + name);
            System.out.println("employee.phoneNumber[0] = " + phoneNumber);
            System.out.println("employee.address(home) = " + address);
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