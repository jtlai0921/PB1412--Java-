package com.mingrisoft.oop;

public class Customer {
    
    public static void main(String[] args) {
        System.out.println("顧客要購買BMW:");
        Car bmw = CarFactory.getCar("BMW");
        System.out.println("分析汽車：" + bmw.getInfo());
        System.out.println("顧客要購買Benz:");
        Car benz = CarFactory.getCar("Benz");
        System.out.println("分析汽車：" + benz.getInfo());
    }
}
