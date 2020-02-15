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
        System.out.print("俱计じ");
        System.out.println(Arrays.toString(ints.toArray()));
        System.out.println("俱计い丁计" + getMiddle(ints));
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(1.1);
        doubles.add(2.2);
        doubles.add(3.3);
        System.out.print("疊翴じ");
        System.out.println(Arrays.toString(doubles.toArray()));
        System.out.println("疊翴い丁计" + getMiddle(doubles));
    }
}
