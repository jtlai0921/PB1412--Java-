package com.mingrisoft.exception;

public class CatchException {
    public static void main(String[] args) {
        try {// �w�qtry��
            System.out.println("�i�Jtry��");
            @SuppressWarnings("unused")
            Class<?> clazz = Class.forName("");// �o��@�ӪŪ�Class�ﹳ
            System.out.println("���}try��");
        } catch (ClassNotFoundException e) {// �w�qcatch��
            System.out.println("�i�Jcatch��");
            e.printStackTrace();
            System.out.println("���}catch��");
        } finally {// �w�qfinally��
            System.out.println("�i�Jfinally��");
        }
    }
}
