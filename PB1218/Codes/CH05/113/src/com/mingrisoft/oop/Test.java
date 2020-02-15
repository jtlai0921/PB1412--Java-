package com.mingrisoft.oop;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Worker> workerList = new ArrayList<Worker>();
        List<Employee> employeeList = new ArrayList<Employee>();
        Worker worker = new Worker("明日科技", 12);
        Employee employee = new Employee("明日科技", 12);
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            workerList.add(worker.clone());
        }
        System.out.print("使用複製域的方式實現複製所花費的時間：");
        System.out.println(System.currentTimeMillis() - currentTime + "毫秒");
        currentTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            employeeList.add(employee.clone());
        }
        System.out.print("使用序列化的方式實現複製所花費的時間：");
        System.out.println(System.currentTimeMillis() - currentTime + "毫秒");
    }
}
