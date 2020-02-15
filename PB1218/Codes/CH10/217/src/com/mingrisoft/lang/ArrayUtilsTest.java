package com.mingrisoft.lang;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

public class ArrayUtilsTest {
    public static void main(String[] args) {
        int[] array0 = { 1, 2, 3, 2, 1 };// 在定義陣列時實現初始化
        System.out.println("陣列中的元素是：");
        System.out.println(Arrays.toString(array0));// 輸出陣列中的全部元素
        System.out.println("刪除最後一個元素");
        int[] array1 = ArrayUtils.remove(array0, 4);// 刪除索引為4的元素
        System.out.println("陣列中的元素是：");
        System.out.println(Arrays.toString(array1));// 輸出新陣列中的全部元素
        System.out.println("刪除元素2");
        int[] array2 = ArrayUtils.removeElement(array0, 2);// 刪除元素2
        System.out.println("陣列中的元素是：");
        System.out.println(Arrays.toString(array2));// 輸出新陣列中的全部元素
    }
}
