package com.mingrisoft.exceptions;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");// ���JMySQL�X�ʵ{��
        } catch (ClassNotFoundException e) {// �����ҥ~
            e.printStackTrace();// �C�L����|��T
        }
    }
}
