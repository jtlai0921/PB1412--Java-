package com.mingrisoft.exceptions;

import java.util.Arrays;

public class ExceptionTest {
    public static void main(String[] args) {
        int[] array = new int[5]; // 聲明一個長度為5的整數陣列
        Arrays.fill(array, 8); // 將新聲明的陣列所有元素給予值為8
        for (int i = 0; i < 6; i++) {// 檢查輸出所有陣列元素
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }
}
