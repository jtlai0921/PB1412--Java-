package com.mingrisoft.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static void copySingleFile(File source, File target) throws IOException {
        FileInputStream input = new FileInputStream(source);// 獲得輸入流
        FileOutputStream output = new FileOutputStream(target);// 獲得輸出流
        byte[] b = new byte[1024 * 5];
        int length;
        while ((length = input.read(b)) != -1) {// 利用循環讀取輸入流中的全部資料
            output.write(b, 0, length);// 將輸入流中的內容寫入到輸出流中
        }
        output.flush();// 更新輸出流
        output.close();// 釋放輸出流資源
        input.close();// 釋放輸入流資源
    }
    
    public static void copyDirectory(File source, File target) throws IOException {
        File[] files = source.listFiles();// 將源檔案夾轉換成File陣列
        for (File file : files) {
            if (file.isFile()) {// 如果是一個檔案就呼叫複製檔案的方法
                copySingleFile(file, new File(target.getAbsolutePath() + "/" + file.getName()));
            } else if (file.listFiles().length == 0) {// 如果是一個空檔案夾就呼叫建立檔案夾的方法
                new File(target.getAbsolutePath() + "/" + file.getName()).mkdir();
            } else {// 如果是一個非空檔案夾就呼叫自身，進行迭代
                new File(target.getAbsolutePath() + "/" + file.getName()).mkdir();
                copyDirectory(file, new File(target.getAbsolutePath() + "/" + file.getName()));
            }
        }
    }
    
}
