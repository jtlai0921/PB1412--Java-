package com.mingrisoft.exception;

public class ThrowsException {
    public static void throwsException() throws ClassNotFoundException {// �ߥX�ҥ~
        Class.forName("com.mysql.jdbc.Driver");
    }
    
    public static void main(String[] args) {
        try {// �����ҥ~
            ThrowsException.throwsException();// �I�s�ߥX�ҥ~����k
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
