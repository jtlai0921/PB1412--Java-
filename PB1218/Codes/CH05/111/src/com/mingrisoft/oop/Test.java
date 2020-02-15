package com.mingrisoft.oop;

public class Test {
    public static void main(String[] args) {
        System.out.println("複製之前：");
        Address address = new Address("中國", "吉林", "長春");
        Employee employee1 = new Employee("明日科技", 12, address);
        System.out.println("員工1的資訊：");
        System.out.println(employee1);
        System.out.println("複製之後：");
        Employee employee2 = employee1.clone();
        employee2.getAddress().setState("中國");
        employee2.getAddress().setProvince("四川");
        employee2.getAddress().setCity("成都");
        employee2.setName("西南交通大學");
        employee2.setAge(114);
        System.out.println("員工2的資訊：");
        System.out.println(employee2);
        System.out.println("員工1的資訊：");
        System.out.println(employee1);
    }
}
