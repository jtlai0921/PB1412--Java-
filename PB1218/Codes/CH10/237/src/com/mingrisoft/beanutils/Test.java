package com.mingrisoft.beanutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;

public class Test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Employee employee1 = new Employee();// �إ�employee1��H�ê�l��
        employee1.setId(1);
        employee1.setName("IBM");
        employee1.setSalary(10000);
        Employee employee2 = new Employee();// �إ�employee2��H�ê�l��
        employee2.setId(2);
        employee2.setName("Oracle");
        employee2.setSalary(1000);
        Employee employee3 = new Employee();// �إ�employee3��H�ê�l��
        employee3.setId(3);
        employee3.setName("Sun");
        employee3.setSalary(100);
        List<Employee> list = new ArrayList<Employee>();// �إ�list��H���x�s�������u�ﹳ
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        System.out.println("�Ƨǫe�G");
        for (Employee employee : list) {
            System.out.println(employee);// ��X�Ҧ���H
        }
        Collections.<Employee> sort(list, new BeanComparator("salary"));// �i��Ƨ�
        System.out.println("���~���Ƨǫ�G");
        for (Employee employee : list) {
            System.out.println(employee);// ��X�Ҧ���H
        }
    }
}
