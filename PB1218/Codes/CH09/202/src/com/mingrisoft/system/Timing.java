package com.mingrisoft.system;

public class Timing {
    public static double round(double value) {
        return Math.round(value * 10.0) / 10.0;// 利用Math類別的round方法進行四捨五入計算
    }
    
    public static String getElapsedText(long elapsedMillis) {
        if (elapsedMillis < 60000) {
            double unit = round(elapsedMillis / 1000.0);// 將時間轉換成秒
            return unit + "秒";// 在轉換完的時間後增加單位
        } else if (elapsedMillis < 60000 * 60) {
            double unit = round(elapsedMillis / 60000.0);// 將時間轉換成分
            return unit + "分";// 在轉換完的時間後增加單位
        } else if (elapsedMillis < 60000 * 60 * 24) {
            double unit = round(elapsedMillis / (60000.0 * 60));// 將時間轉換成時
            return unit + "時";// 在轉換完的時間後增加單位
        } else {
            double unit = round(elapsedMillis / (60000.0 * 60 * 24));// 將時間轉換成天
            return unit + "天";// 在轉換完的時間後增加單位
        }
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println("程式開始執行時間：" + begin);
        for (int i = 0; i < 1000000000; i++) {
            Math.random();
        }
        long end = System.currentTimeMillis();
        System.out.println("程式結束執行時間：" + end);
        System.out.println("程式執行時間：" + getElapsedText(end - begin));
    }
}
