package com.mingrisoft.time;

import java.util.TimeZone;

public class LocaleTimeZone {
    public static void main(String[] args) {
        TimeZone zone = TimeZone.getDefault();// ��o�ثe�ɰ�
        System.out.println("�ثe�D���Ҧb�ɰϡG" + zone.getDisplayName());// ��o�ɰϪ��W�r
        zone = TimeZone.getTimeZone("Asia/Taipei");// ��o�x�_�ɰ�
        System.out.println("����x�_�Ҧb�ɰϡG" + zone.getDisplayName());
        System.out.println("�ɰϪ�����W�١G" + zone.getDisplayName(true, TimeZone.LONG));
        System.out.println("�ɰϪ��Y�g�W�١G" + zone.getDisplayName(true, TimeZone.SHORT));
    }
}
