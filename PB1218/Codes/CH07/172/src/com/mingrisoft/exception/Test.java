package com.mingrisoft.exception;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[5];// 定義長度為5的陣列
        Arrays.fill(array, 5);// 將陣列中的元素給予值為5
        for (int i = 4; i > -1; i--) {// 檢查整個陣列
            if (i == 0) {// 如果除0
                throw new DivideZeroException("除零例外");// 如果除零就拋出有例外資訊的建構方法
            }// 如果不是除零就輸出結果
            System.out.println("array[" + i + "] / " + i + " = " + array[i] / i);
        }
    }
}
