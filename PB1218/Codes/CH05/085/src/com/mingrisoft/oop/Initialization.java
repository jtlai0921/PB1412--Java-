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
        System.out.println("�줸���A����ȡG" + init.b);
        System.out.println("�u��ƫ��A����ȡG" + init.s);
        System.out.println("��ƫ��A����ȡG" + init.i);
        System.out.println("����ƫ��A����ȡG" + init.l);
        System.out.println("���ׯB�I���A����ȡG" + init.f);
        System.out.println("����ׯB�I���A����ȡG" + init.d);
        System.out.println("�������A����ȡG" + init.bl);
        System.out.println("�r�ū��A����ȡG" + init.c);
        System.out.println("�Ѧҫ��A����ȡG" + init.string);
    }
}
