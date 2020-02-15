package com.mingrisoft.oop;

public class OverloadingTest {
    
    public void info() {
        System.out.println("普通方法：明日科技1歲了！");
    }
    
    public void info(int age) {
        System.out.println("多載方法：明日科技" + age + "歲了！");
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