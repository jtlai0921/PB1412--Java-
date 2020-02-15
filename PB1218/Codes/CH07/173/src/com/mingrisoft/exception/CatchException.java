package com.mingrisoft.exception;

public class CatchException {
    public static void main(String[] args) {
        try {// 定義try塊
            System.out.println("進入try塊");
            @SuppressWarnings("unused")
            Class<?> clazz = Class.forName("");// 得到一個空的Class對像
            System.out.println("離開try塊");
        } catch (ClassNotFoundException e) {// 定義catch塊
            System.out.println("進入catch塊");
            e.printStackTrace();
            System.out.println("離開catch塊");
        } finally {// 定義finally塊
            System.out.println("進入finally塊");
        }
    }
}
