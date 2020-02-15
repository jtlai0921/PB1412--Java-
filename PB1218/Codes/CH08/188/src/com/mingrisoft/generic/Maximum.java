package com.mingrisoft.generic;

public interface Maximum<T extends Comparable<T>> {
    T getMax(T[] array);
}
