package com.mingrisoft.generic;

public class GenericComparisonTest {
    public static void main(String[] args) {
        String[] books = { "Java�q�J�����q�]��2���^", "Java�s�{�_��", "�ӻ�Java", "���T��Java" };
        System.out.println("�����޷s�ѦC��G");
        for (String book : books) {
            System.out.println(book);
        }
        String min = GenericComparison.getMin(books);
        System.out.println("���W�ٱƧǪ��Ĥ@���ѡG");
        System.out.println(min);
    }
}
