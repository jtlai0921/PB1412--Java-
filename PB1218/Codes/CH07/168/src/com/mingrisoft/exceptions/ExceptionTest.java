package com.mingrisoft.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) {
        FileInputStream fis = null;// 建立一個檔案輸入流對像
        try {
            File file = new File("d:\\kira.txt");// 建立一個檔案對像
            fis = new FileInputStream(file);// 初始化檔案輸入流對像
        } catch (FileNotFoundException e) {// 捕捉例外
            e.printStackTrace();
        } finally {
            try {
                fis.close();// 釋放資源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
