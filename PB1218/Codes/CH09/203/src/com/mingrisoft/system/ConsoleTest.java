package com.mingrisoft.system;

import java.io.Console;
import java.util.Arrays;

public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console();// 獲得Console對像
        String username = console.readLine("請輸入使用者名稱："); // 獲得使用者名稱
        char[] password = console.readPassword("請輸入密碼："); // 獲得密碼
        System.out.println("您的使用者名稱是：" + username);// 輸出使用者名稱
        System.out.print("您的密碼是：");
        for (char c : password) {
            System.out.print(c);// 輸出密碼
        }
        Arrays.fill(password, 'a');// 將儲存密碼的陣列元素全部複製為』a』
    }
}
