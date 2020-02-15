package com.mingrisoft.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();// 建立Runtime對像
        run.gc();// 執行垃圾回收器，這樣可以減少誤差
        long freeMemory = run.freeMemory();// 獲得目前虛擬機的空閒記憶體
        long currentTime = System.currentTimeMillis();// 獲得目前虛擬機的時間
        for (int i = 0; i < 10000; i++) {// 獨立執行1000個線程
            new Thread(new TempThread()).start();
        }
        System.out.println("獨立執行1000個線程所佔用的記憶體：" + (freeMemory - run.freeMemory()) + "字節");// 檢視記憶體的變化
        System.out.println("獨立建立1000個線程所消耗的時間：" + (System.currentTimeMillis() - currentTime) + "毫秒");// 檢視時間的變化
        
        run.gc();// 執行垃圾回收器
        freeMemory = run.freeMemory();// 獲得目前虛擬機的空閒記憶體
        currentTime = System.currentTimeMillis();// 獲得目前虛擬機的時間
        ExecutorService executorService = Executors.newFixedThreadPool(2);// 建立線程池
        for (int i = 0; i < 1000; i++) {// 使用線程池執行1000個線程
            executorService.submit(new TempThread());
        }
        System.out.println("使用連接池執行1000個線程所佔用的記憶體：" + (freeMemory - run.freeMemory()) + "字節");// 檢視記憶體的變化
        System.out.println("使用連接池建立1000個線程所消耗的時間：" + (System.currentTimeMillis() - currentTime) + "毫秒");// 檢視時間的變化
    }
}
