package com.mingrisoft.enummap;

import static com.mingrisoft.enummap.Weeks.MONDAY;
import static com.mingrisoft.enummap.Weeks.SATURADAY;
import static com.mingrisoft.enummap.Weeks.SUNDAY;

import java.util.EnumMap;

public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap<Weeks, String> weeks = new EnumMap<Weeks, String>(Weeks.class);
        weeks.put(MONDAY, "�P���@");
        weeks.put(SUNDAY, "�P����");
        System.out.println("EnumMap������ȹ�ӼơG" + weeks.size());
        System.out.println("EnumMap������ȹ�G" + weeks);
        System.out.println("EnumMap���O�_�]�t��SATURADAY�G"
                + weeks.containsKey(SATURADAY));
        System.out.println("EnumMap���O�_�]�t�ȬP����G" + weeks.containsValue("�P����"));
        weeks.remove(MONDAY);
        System.out.println("EnumMap������ȹ�G" + weeks);
        System.out.println("EnumMap����MONDAY�������ȡG" + weeks.get(MONDAY));
    }
}
