package com.mingrisoft.exception;

public class DivideZeroException extends ArithmeticException {// 自定義例外類別
    private static final long serialVersionUID = 1563874058117161205L;
    
    public DivideZeroException() {
    }// 實現預設建構方法
    
    public DivideZeroException(String msg) {
        super(msg);
    }// 實現有輸出資訊的建構方法
}
