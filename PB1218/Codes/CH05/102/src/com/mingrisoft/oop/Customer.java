package com.mingrisoft.oop;

public class Customer {
    
    public static void main(String[] args) {
        System.out.println("�U�ȭn�ʶRBMW:");
        Car bmw = CarFactory.getCar("BMW");
        System.out.println("���R�T���G" + bmw.getInfo());
        System.out.println("�U�ȭn�ʶRBenz:");
        Car benz = CarFactory.getCar("Benz");
        System.out.println("���R�T���G" + benz.getInfo());
    }
}
