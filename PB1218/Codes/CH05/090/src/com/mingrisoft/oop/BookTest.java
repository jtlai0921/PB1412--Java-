package com.mingrisoft.oop;

import java.util.Random;

public class BookTest {
    public static void main(String[] args) {
        String[] titles = { "《Java從入門到精通（第2版）》", "《Java編程詞典》", "《視訊學Java》" };
        for (int i = 0; i < 5; i++) {
            new Book(titles[new Random().nextInt(3)]);
        }
        System.out.println("總計銷售了" + Book.getCounter() + "本圖書！");
    }
}
