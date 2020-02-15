package com.mingrisoft.oop;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee(3, "Java", 1);
        Employee employee2 = new Employee(2, "PHP", 2);
        Employee employee3 = new Employee(1, "Ruby", 3);
        Employee[] employees = new Employee[3];
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;
        System.out.println("排序前：");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("排序後：");
        Arrays.sort(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
