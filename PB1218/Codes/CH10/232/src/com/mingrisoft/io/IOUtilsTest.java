package com.mingrisoft.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;

public class IOUtilsTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        FileOutputStream out = null;
        FileInputStream in = null;
        try {
            out = new FileOutputStream("d:\\明日科技.txt"); // 建立檔案輸出流對像
            in = new FileInputStream("d:\\明日科技.txt"); // 建立檔案輸入流對像
            System.out.println("向檔案中寫入5個隨機字串");
            for (int i = 0; i < 5; i++) {// 向檔案中寫入5個隨機字串
                IOUtils.write(RandomStringUtils.randomAlphanumeric(5) + "\n", out);
            }
            System.out.println("輸出檔案中的隨機字串");
            List<String> list = IOUtils.readLines(in);// 從檔案中讀取字串
            for (String string : list) {
                System.out.println(string);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out); // 釋放資源
            IOUtils.closeQuietly(in); // 釋放資源
        }
    }
}
