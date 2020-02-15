package com.mingrisoft.io;

import java.io.File;

import org.apache.commons.io.filefilter.SizeFileFilter;

public class SizeFileFilterTest {
    public static void main(String[] args) {
        File dir = new File("d:\\明日科技");// 建立一個檔案夾對像
        System.out.println("過濾前檔案夾中的檔案：");
        File[] files = dir.listFiles();// 獲得該檔案夾中所有檔案和子檔案夾
        for (File file : files) {// 輸出檔案夾中檔案的名字和大小
            System.out.println(file.getName() + "的大小是：" + file.length());
        }
        System.out.println("過濾後檔案夾中的檔案：");
        String[] fileNames = dir.list(new SizeFileFilter(1024 * 1024));// 過濾掉<1M的檔案
        for (int i = 0; i < fileNames.length; i++) {
            System.out.println(fileNames[i]);
        }
    }
}
