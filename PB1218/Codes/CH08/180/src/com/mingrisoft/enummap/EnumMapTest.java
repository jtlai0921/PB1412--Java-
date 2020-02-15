package com.mingrisoft.enummap;

import static com.mingrisoft.enummap.Weeks.MONDAY;
import static com.mingrisoft.enummap.Weeks.SATURADAY;
import static com.mingrisoft.enummap.Weeks.SUNDAY;

import java.util.EnumMap;

public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap<Weeks, String> weeks = new EnumMap<Weeks, String>(Weeks.class);
        weeks.put(MONDAY, "星期一");
        weeks.put(SUNDAY, "星期日");
        System.out.println("EnumMap中的鍵值對個數：" + weeks.size());
        System.out.println("EnumMap中的鍵值對：" + weeks);
        System.out.println("EnumMap中是否包含鍵SATURADAY："
                + weeks.containsKey(SATURADAY));
        System.out.println("EnumMap中是否包含值星期日：" + weeks.containsValue("星期日"));
        weeks.remove(MONDAY);
        System.out.println("EnumMap中的鍵值對：" + weeks);
        System.out.println("EnumMap中鍵MONDAY對應的值：" + weeks.get(MONDAY));
    }
}
