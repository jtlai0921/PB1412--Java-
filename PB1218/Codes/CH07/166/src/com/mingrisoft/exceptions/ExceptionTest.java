package com.mingrisoft.exceptions;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");// 載入MySQL驅動程式
        } catch (ClassNotFoundException e) {// 捕捉例外
            e.printStackTrace();// 列印堆堆疊資訊
        }
    }
}
