package com.mingrisoft.oop;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Worker> workerList = new ArrayList<Worker>();
        List<Employee> employeeList = new ArrayList<Employee>();
        Worker worker = new Worker("������", 12);
        Employee employee = new Employee("������", 12);
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            workerList.add(worker.clone());
        }
        System.out.print("�ϥνƻs�쪺�覡��{�ƻs�Ҫ�O���ɶ��G");
        System.out.println(System.currentTimeMillis() - currentTime + "�@��");
        currentTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            employeeList.add(employee.clone());
        }
        System.out.print("�ϥΧǦC�ƪ��覡��{�ƻs�Ҫ�O���ɶ��G");
        System.out.println(System.currentTimeMillis() - currentTime + "�@��");
    }
}
