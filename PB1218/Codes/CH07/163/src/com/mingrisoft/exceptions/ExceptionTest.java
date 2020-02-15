package com.mingrisoft.exceptions;

public class ExceptionTest {
    public static void main(String[] args) {
        Object array[] = new String[3]; // 聲明一個長度為3的Object型態的陣列
        array[0] = new Integer(1); // 將陣列的第一個元素給予值為整數對像1
        System.out.println(array[0]); // 輸出陣列的第一個元素
    }
}
