package com.mingrisoft.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class OutputRedirect {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\debug.txt");// 建立一個檔案來儲存重新導向後輸出的文字資訊
        PrintStream out = new PrintStream(file);
        PrintStream cloneOut = System.out;// 使用變數儲存主控台輸出
        System.setOut(out);// 將標準輸出重新導向到PrintStream
        System.out.println("明日科技新書快遞：");// 利用標準輸出輸出敘述
        System.out.println("Java從入門到精通（第2版）");// 利用標準輸出輸出敘述
        System.out.println("視訊學Java");// 利用標準輸出輸出敘述
        System.out.println("細說Java");// 利用標準輸出輸出敘述
        out.close();// 關閉PrintStream
        System.setOut(cloneOut);// 將標準輸出重新導向到主控台
        BufferedReader in = new BufferedReader(new FileReader(file));// 讀取檔案
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);// 在主控台上輸出檔案
        }
        in.close();// 關閉輸入流
    }
}
