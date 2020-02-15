package com.mingrisoft.lang;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

public class ArrayUtilsTest {
    public static void main(String[] args) {
        int[] array0 = new int[5]; // ミ5int篈皚
        Arrays.fill(array0, 8); // 盢皚いじ场﹍て8
        System.out.println("皚いじ琌");
        System.out.println(Arrays.toString(array0)); // 块皚い场じ
        System.out.println("皚程糤じ10");
        int[] array1 = ArrayUtils.add(array0, 10); // 皚程糤じ10
        System.out.println("皚いじ琌");
        System.out.println(Arrays.toString(array1)); // 块穝皚い场じ
        System.out.println("皚秨繷糤じ10");
        int[] array2 = ArrayUtils.add(array0, 0, 10); // 皚秨繷糤じ10
        System.out.println("皚いじ琌");
        System.out.println(Arrays.toString(array2)); // 块穝皚い场じ
        System.out.println("盢穝玻ネㄢ皚ㄖ");
        int[] array3 = ArrayUtils.addAll(array1, array2);// ㄖ穝玻ネㄢ皚
        System.out.println("皚いじ琌");
        System.out.println(Arrays.toString(array3)); // 块穝皚い场じ
    }
}
