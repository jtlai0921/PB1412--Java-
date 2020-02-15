package com.mingrisoft.exceptions;

public class ExceptionTest {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        String string = null;// 將字串設定為null
        System.out.println(string.toLowerCase());// 將字串轉換成小寫
    }
}
