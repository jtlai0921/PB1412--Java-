package com.mingrisoft.generic;

public class GenericComparisonTest {
    public static void main(String[] args) {
        String[] books = { "Java�q�J�����q�]��2���^", "Java�s�{�_��", "�ӻ�Java", "���T��Java" };
        System.out.println("�����޷s�ѦC��G");
        for (String book : books) {
            System.out.println(book);
        }
        GenericComparison<String> gc = new GenericComparison<String>();
        String max = gc.getMax(books);
        System.out.println("���W�ٱƧǳ̫�@���ѡG");
        System.out.println(max);
    }
}
