package com.mingrisoft.generic;

public class GenericComparisonTest {
    public static void main(String[] args) {
        String[] books = { "Java從入門到精通（第2版）", "Java編程寶典", "細說Java", "視訊學Java" };
        System.out.println("明日科技新書列表：");
        for (String book : books) {
            System.out.println(book);
        }
        String min = GenericComparison.getMin(books);
        System.out.println("按名稱排序的第一本書：");
        System.out.println(min);
    }
}
