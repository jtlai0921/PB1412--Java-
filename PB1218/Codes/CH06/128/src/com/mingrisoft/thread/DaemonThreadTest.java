package com.mingrisoft.thread;

public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread userThread = new Thread(new Worker()); // 建立使用者線程
        Thread daemonThread = new Thread(new Timer()); // 建立守護線程
        daemonThread.setDaemon(true); // 設定守護線程
        userThread.start(); // 啟動使用者線程
        daemonThread.start(); // 啟動守護線程
    }
}
