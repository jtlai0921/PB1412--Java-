package com.mingrisoft.thread;

public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread userThread = new Thread(new Worker()); // �إߨϥΪ̽u�{
        Thread daemonThread = new Thread(new Timer()); // �إߦu�@�u�{
        daemonThread.setDaemon(true); // �]�w�u�@�u�{
        userThread.start(); // �ҰʨϥΪ̽u�{
        daemonThread.start(); // �Ұʦu�@�u�{
    }
}
