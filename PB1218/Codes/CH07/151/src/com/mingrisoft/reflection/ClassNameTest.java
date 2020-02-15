package com.mingrisoft.reflection;

import java.util.Date;

public class ClassNameTest {
    public static void main(String[] args) {
        String dateName = new Date().getClass().getName();// 獲得參考型態名稱
        System.out.println("非陣列參考型態的名稱：" + dateName);// 輸出參考型態名稱
        String byteName = byte.class.getName();// 獲得原始型態名稱
        System.out.println("基本型態的名稱：" + byteName);// 輸出原始型態名稱
        String oneDimensionArray = new Date[4].getClass().getName();// 獲得一維參考型態陣列
        System.out.println("一維參考型態陣列：" + oneDimensionArray);// 輸出一維參考型態陣列名稱
        String twoDimensionArray = new int[4][4].getClass().getName();// 獲得二維原始型態
        System.out.println("二維基本型態陣列：" + twoDimensionArray);// 輸出二維參考型態陣列名稱
    }
}
