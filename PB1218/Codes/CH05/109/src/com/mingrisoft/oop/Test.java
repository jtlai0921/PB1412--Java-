package com.mingrisoft.oop;

public class Test {
    public static void main(String[] args) {
        System.out.println("複製之前：");
        Employee employee1 = new Employee();
        employee1.setName("明日科技");
        employee1.setAge(12);
        System.out.println("員工1的資訊：");
        System.out.println(employee1);
        System.out.println("複製之後：");
        Employee employee2 = employee1;
        employee2.setName("西南交通大學");
        employee2.setAge(114);
        System.out.println("員工2的資訊：");
        System.out.println(employee2);
        System.out.println("員工1的資訊：");
        System.out.println(employee1);
    }
}
