package com.mingrisoft.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardsTest {
    public static Object getMiddle(List<? extends Number> list) {
        return list.get(list.size() / 2);
    }
    
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        System.out.print("��ƦC�������G");
        System.out.println(Arrays.toString(ints.toArray()));
        System.out.println("��ƦC�������ơG" + getMiddle(ints));
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(1.1);
        doubles.add(2.2);
        doubles.add(3.3);
        System.out.print("�B�I�C�������G");
        System.out.println(Arrays.toString(doubles.toArray()));
        System.out.println("�B�I�C�������ơG" + getMiddle(doubles));
    }
}
