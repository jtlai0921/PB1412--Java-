package com.cdd.encrypt;

import java.io.*;
import java.nio.channels.FileLock;

class EncryptInput {
    
    public static void fileLock(String file) {
        FileOutputStream fous = null; // 建立FileOutputStream對像
        FileLock lock = null; // 建立FileLock對像
        try {
            fous = new FileOutputStream(file); // 實例化FileOutputStream對像
            lock = fous.getChannel().tryLock(); // 獲得檔案鎖定
            Thread.sleep(60 * 1000); // 線程鎖定1分鐘
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String file = "C://count.txt"; // 建立檔案對像
        fileLock(file); // 呼叫檔案鎖定方法
    }
}
