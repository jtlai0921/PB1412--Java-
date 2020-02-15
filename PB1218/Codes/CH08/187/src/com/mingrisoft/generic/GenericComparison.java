package com.mingrisoft.generic;

public class GenericComparison {
    
    public static <T extends Comparable<T>> T getMin(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T min = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
            }
        }
        return min;
    }
}
