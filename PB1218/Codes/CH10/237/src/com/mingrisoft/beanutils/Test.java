package com.mingrisoft.beanutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;

public class Test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Employee employee1 = new Employee();// 建立employee1對象並初始化
        employee1.setId(1);
        employee1.setName("IBM");
        employee1.setSalary(10000);
        Employee employee2 = new Employee();// 建立employee2對象並初始化
        employee2.setId(2);
        employee2.setName("Oracle");
        employee2.setSalary(1000);
        Employee employee3 = new Employee();// 建立employee3對象並初始化
        employee3.setId(3);
        employee3.setName("Sun");
        employee3.setSalary(100);
        List<Employee> list = new ArrayList<Employee>();// 建立list對象並儲存全部員工對像
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        System.out.println("排序前：");
        for (Employee employee : list) {
            System.out.println(employee);// 輸出所有對象
        }
        Collections.<Employee> sort(list, new BeanComparator("salary"));// 進行排序
        System.out.println("按薪水排序後：");
        for (Employee employee : list) {
            System.out.println(employee);// 輸出所有對象
        }
    }
}
