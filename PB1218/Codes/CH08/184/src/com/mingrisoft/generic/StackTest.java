package com.mingrisoft.generic;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        System.out.println("向堆疊中增加字串：");
        System.out.println("視訊學Java");
        System.out.println("細說Java");
        System.out.println("Java從入門到精通(第2版)");
        stack.push("視訊學Java");  //向堆疊中增加字串
        stack.push("細說Java");   //向堆疊中增加字串
        stack.push("Java從入門到精通(第2版)"); //向堆疊中增加字串
        System.out.println("從堆疊中取出字串：");
        while (!stack.empty()) {
            System.out.println((String) stack.pop());//刪除堆疊中全部元素並進行輸出
        }
    }
}

