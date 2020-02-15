package com.cdd.util;
import java.io.*;
public class Employ {
public static void main(String args[]) {
    File file = new File("Example8.txt");
    try {
        if (!file.exists())                      // 如果檔案不存在
            file.createNewFile();                // 建立新檔案
        InputStreamReader isr = new InputStreamReader(System.in);   //定義輸入流對像
        BufferedReader br = new BufferedReader(isr);            
        System.out.println("請輸入：");
        String str = br.readLine();             //讀取使用者輸入的資訊
        System.out.println("您輸入的內容是：" + str);
        FileWriter fos = new FileWriter(file, true);         // 建立檔案輸出流
        BufferedWriter bw = new BufferedWriter(fos);
        bw.write(str);                          //向檔案寫入資訊
        br.close();
        bw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
