package com.mingrisoft.oop;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Java");
        employee.setSalary(100);
        employee.setBirthday(new Date());
        Manager manager = new Manager();
        manager.setName("明日科技");
        manager.setSalary(3000);
        manager.setBirthday(new Date());
        manager.setBonus(2000);
        System.out.println("員工的姓名：" + employee.getName());
        System.out.println("員工的薪水：" + employee.getSalary());
        System.out.println("員工的生日：" + employee.getBirthday());
        System.out.println("經理的姓名：" + manager.getName());
        System.out.println("經理的薪水：" + manager.getSalary());
        System.out.println("經理的生日：" + manager.getBirthday());
        System.out.println("經理的獎金：" + manager.getBonus());
        
    }
}
