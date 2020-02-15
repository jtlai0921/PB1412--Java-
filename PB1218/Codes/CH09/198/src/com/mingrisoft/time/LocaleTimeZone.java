package com.mingrisoft.time;

import java.util.TimeZone;

public class LocaleTimeZone {
    public static void main(String[] args) {
        TimeZone zone = TimeZone.getDefault();// 獲得目前時區
        System.out.println("目前主機所在時區：" + zone.getDisplayName());// 獲得時區的名字
        zone = TimeZone.getTimeZone("Asia/Taipei");// 獲得台北時區
        System.out.println("中國台北所在時區：" + zone.getDisplayName());
        System.out.println("時區的完整名稱：" + zone.getDisplayName(true, TimeZone.LONG));
        System.out.println("時區的縮寫名稱：" + zone.getDisplayName(true, TimeZone.SHORT));
    }
}
