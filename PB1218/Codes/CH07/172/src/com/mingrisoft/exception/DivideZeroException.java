package com.mingrisoft.exception;

public class DivideZeroException extends ArithmeticException {// �۩w�q�ҥ~���O
    private static final long serialVersionUID = 1563874058117161205L;
    
    public DivideZeroException() {
    }// ��{�w�]�غc��k
    
    public DivideZeroException(String msg) {
        super(msg);
    }// ��{����X��T���غc��k
}
