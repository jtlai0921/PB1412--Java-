package com.mingrisoft.oop;

import java.util.Random;

public class BookTest {
    public static void main(String[] args) {
        String[] titles = { "�mJava�q�J�����q�]��2���^�n", "�mJava�s�{����n", "�m���T��Java�n" };
        for (int i = 0; i < 5; i++) {
            new Book(titles[new Random().nextInt(3)]);
        }
        System.out.println("�`�p�P��F" + Book.getCounter() + "���ϮѡI");
    }
}
