package com.mingrisoft.generic;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        System.out.println("�V���|���W�[�r��G");
        System.out.println("���T��Java");
        System.out.println("�ӻ�Java");
        System.out.println("Java�q�J�����q(��2��)");
        stack.push("���T��Java");  //�V���|���W�[�r��
        stack.push("�ӻ�Java");   //�V���|���W�[�r��
        stack.push("Java�q�J�����q(��2��)"); //�V���|���W�[�r��
        System.out.println("�q���|�����X�r��G");
        while (!stack.empty()) {
            System.out.println((String) stack.pop());//�R�����|�����������öi���X
        }
    }
}

