package com.mingrisoft.oop;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Java");
        employee.setSalary(100);
        employee.setBirthday(new Date());
        Manager manager = new Manager();
        manager.setName("������");
        manager.setSalary(3000);
        manager.setBirthday(new Date());
        manager.setBonus(2000);
        System.out.println("���u���m�W�G" + employee.getName());
        System.out.println("���u���~���G" + employee.getSalary());
        System.out.println("���u���ͤ�G" + employee.getBirthday());
        System.out.println("�g�z���m�W�G" + manager.getName());
        System.out.println("�g�z���~���G" + manager.getSalary());
        System.out.println("�g�z���ͤ�G" + manager.getBirthday());
        System.out.println("�g�z�������G" + manager.getBonus());
        
    }
}
