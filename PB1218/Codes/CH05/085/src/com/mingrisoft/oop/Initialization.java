package com.mingrisoft.oop;

public class Initialization {
    private byte b;
    private short s;
    private int i;
    private long l;
    private float f;
    private double d;
    private boolean bl;
    private char c;
    private String string;
    
    public static void main(String[] args) {
        Initialization init = new Initialization();
        System.out.println("位元型態的初值：" + init.b);
        System.out.println("短整數型態的初值：" + init.s);
        System.out.println("整數型態的初值：" + init.i);
        System.out.println("長整數型態的初值：" + init.l);
        System.out.println("單精度浮點型態的初值：" + init.f);
        System.out.println("雙精度浮點型態的初值：" + init.d);
        System.out.println("布爾型態的初值：" + init.bl);
        System.out.println("字符型態的初值：" + init.c);
        System.out.println("參考型態的初值：" + init.string);
    }
}
