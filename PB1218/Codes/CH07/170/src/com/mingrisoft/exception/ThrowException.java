package com.mingrisoft.exception;

public class ThrowException {
    public static void throwException() {
        throw new UnsupportedOperationException("��k�|����{");// �ߥX�ҥ~
    }
    
    public static void main(String[] args) {
        ThrowException.throwException();// �I�s�ߥX�ҥ~����k
    }
}
