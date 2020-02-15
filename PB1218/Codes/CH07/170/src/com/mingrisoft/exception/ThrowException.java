package com.mingrisoft.exception;

public class ThrowException {
    public static void throwException() {
        throw new UnsupportedOperationException("方法尚未實現");// 拋出例外
    }
    
    public static void main(String[] args) {
        ThrowException.throwException();// 呼叫拋出例外的方法
    }
}
