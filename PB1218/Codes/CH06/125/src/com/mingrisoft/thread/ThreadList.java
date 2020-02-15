package com.mingrisoft.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadList {
    private static ThreadGroup getRootThreadGroups() {//獲得根線程組
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();//獲得目前線程組
        while (true) {
            if (rootGroup.getParent() != null) {//如果getParent()傳回值非空則不是根線程組
                rootGroup = rootGroup.getParent();//獲得父線程組
            } else {
                break;//如果到達根線程組則退出循環
            }
        }
        return rootGroup;//傳回根線程組
    }
    public static List<String> getThreads(ThreadGroup group) {//獲得指定線程組中所有線程名
        List<String> threadList = new ArrayList<String>();      //建立儲存線程名的列表
        Thread[] threads = new Thread[group.activeCount()]; //根據活動線程數建立線程陣列
        int count = group.enumerate(threads, false);//複製線程到線程陣列
        for (int i = 0; i < count; i++) {//檢查線程陣列將線程名及其所在組儲存到列表中
            threadList.add(group.getName() + "線程組：" + threads[i].getName());
        }
        return threadList;//傳回列表
    }
    public static List<String> getThreadGroups(ThreadGroup group) {//獲得線程組中所有線程
        List<String> threadList = getThreads(group);    //獲得指定線程組中線程名
        ThreadGroup[] groups = new ThreadGroup[group.activeGroupCount()];//建立線程組陣列
        int count = group.enumerate(groups, false); //複製子線程組到線程組資料
        for (int i = 0; i < count; i++) {//檢查所有子線程組
            threadList.addAll(getThreads(groups[i]));// 利用getThreads()方法獲得線程名列表
        }
        return threadList;//傳回所有線程名
    }
    public static void main(String[] args) {
        for (String string : getThreadGroups(getRootThreadGroups())) {
            System.out.println(string);//檢查輸出列表中的字串
        }
    }
}
