package com.mingrisoft.oop;

public class OverloadingTest {
    
    public void info() {
        System.out.println("���q��k�G������1���F�I");
    }
    
    public void info(int age) {
        System.out.println("�h����k�G������" + age + "���F�I");
    }
    
    public static void main(String[] args) {
        OverloadingTest ot = new OverloadingTest();
        ot.info();
        for (int i = 1; i < 5; i++) {
            ot.info(i);
        }
    }
}
