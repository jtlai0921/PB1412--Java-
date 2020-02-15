package com.mingrisoft.oop;

public class Child extends Ancestor {
    
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println("獲得祖先的止癢藥方：");
        System.out.println(child.getPrescription());
    }
}
