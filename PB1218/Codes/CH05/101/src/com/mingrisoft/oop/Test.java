package com.mingrisoft.oop;

public class Test {
    public static void main(String[] args) {
        Box box = new Box();
        System.out.println("將箱子的長度設定成-1");
        box.setLength(-1);
        System.out.println("將箱子的寬度設定成-1");
        box.setWidth(-1);
        System.out.println("將箱子的高度設定成-1");
        box.setHeight(-1);
        System.out.println("箱子的長度是：" + box.getLength());
        System.out.println("箱子的寬度是：" + box.getWidth());
        System.out.println("箱子的高度是：" + box.getHeight());
    }
}
