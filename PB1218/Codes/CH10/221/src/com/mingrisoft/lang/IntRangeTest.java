package com.mingrisoft.lang;

import java.util.Arrays;

import org.apache.commons.lang.math.IntRange;

public class IntRangeTest {
    public static void main(String[] args) {
        IntRange range = new IntRange(-5, 5);// 建立一個從-5到5的區間
        System.out.println("區間中的全部整數是：");
        System.out.println(Arrays.toString(range.toArray()));// 輸出區間中的全部整數
        System.out.print("0是否在區間中：");
        System.out.println(range.containsInteger(0));// 判斷0是否在區間中
        System.out.print("區間的上限是：");
        System.out.println(range.getMaximumInteger());// 輸出區間的上限
        System.out.print("區間的下限是：");
        System.out.println(range.getMinimumInteger());// 輸出區間的下限
        System.out.print("區間的字串表示是：");
        System.out.println(range.toString());// 輸出區間的數學表示形式
    }
}
