package com.mingrisoft.math;

import java.math.BigInteger;

public class MathUtil {
    public static void main(String[] args) {
        BigInteger number1 = new BigInteger("12345"); // 聲明高精度整數number1
        BigInteger number2 = new BigInteger("54321"); // 聲明高精度整數number2
        BigInteger addition = number1.add(number2); // 計算number1加number2
        BigInteger subtraction = number1.subtract(number2); // 計算number1減number2
        BigInteger multiplication = number1.multiply(number2); // 計算number1乘number2
        BigInteger division = number1.divide(number2); // 計算number1除number2
        System.out.println("高精度整數number1：" + number1);
        System.out.println("高精度整數number2：" + number2);
        System.out.println("高精度整數加法：" + addition);
        System.out.println("高精度整數減法：" + subtraction);
        System.out.println("高精度整數乘法：" + multiplication);
        System.out.println("高精度整數除法：" + division);
    }
}
