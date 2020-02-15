package com.mingrisoft.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UsefulArray {
    
    public static Object increaseArray(Object array) {
        Class<?> clazz = array.getClass();// 獲得代表陣列的Class對像
        if (clazz.isArray()) {// 如果輸入是一個陣列
            Class<?> componentType = clazz.getComponentType();// 獲得陣列元素的型態
            int length = Array.getLength(array);// 獲得輸入的陣列的長度
            Object newArray = Array.newInstance(componentType, length + 5);// 新增陣列
            System.arraycopy(array, 0, newArray, 0, length);// 複製原來陣列中的所有資料
            return newArray;// 傳回新增陣列
        }
        return null;// 如果輸入的不是陣列就傳回空
    }
    
    public static void main(String[] args) {
        int[] intArray = new int[10];
        System.out.println("整數陣列原始長度是：" + intArray.length);
        Arrays.fill(intArray, 8);
        System.out.println("整數陣列的內容：");
        System.out.println(Arrays.toString(intArray));
        int[] newIntArray = (int[]) increaseArray(intArray);
        System.out.println("整數陣列擴充後長度是：" + newIntArray.length);
        System.out.println("整數陣列的內容：");
        System.out.println(Arrays.toString(newIntArray));
    }
}
