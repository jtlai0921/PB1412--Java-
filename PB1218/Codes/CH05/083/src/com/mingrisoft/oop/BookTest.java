package com.mingrisoft.oop;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("�mJava�q�J�����q�]��2���^�n", "������", 59.8);
        System.out.println("�ѦW�G" + book.getTitle());
        System.out.println("�@�̡G" + book.getAuthor());
        System.out.println("����G" + book.getPrice() + "��");
    }
}
