package com.mingrisoft.exception;

public class ThrowsException {
    public static void throwsException() throws ClassNotFoundException {// 拋出例外
        Class.forName("com.mysql.jdbc.Driver");
    }
    
    public static void main(String[] args) {
        try {// 捕捉例外
            ThrowsException.throwsException();// 呼叫拋出例外的方法
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
