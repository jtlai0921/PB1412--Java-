package com.mingrisoft.lang;

import org.apache.commons.lang.math.Fraction;

public class FractionTest {
    public static void main(String[] args) {
        Fraction fraction1 = Fraction.getFraction(1, 3);// 建立小數1/3
        Fraction fraction2 = Fraction.getFraction(1, 5);// 建立小數1/5
        Fraction addition = fraction1.add(fraction2);// 計算1/3 + 1/5
        System.out.println("1/3 + 1/5 = " + addition);
        Fraction subtraction = fraction1.subtract(fraction2);// 計算1/3 - 1/5
        System.out.println("1/3 - 1/5 = " + subtraction);
        Fraction multiplication = fraction1.multiplyBy(fraction2);// 計算1/3 * 1/5
        System.out.println("1/3 * 1/5 = " + multiplication);
        Fraction division = fraction1.divideBy(fraction2);// 計算1/3 / 1/5
        System.out.println("1/3 / 1/5 = " + division);
        Fraction invert = fraction1.invert();// 計算1/3的倒數
        System.out.println("1/3的倒數是：" + invert);
        Fraction pow = fraction1.pow(2); // 計算1/3的平方
        System.out.println("1/3的平方是：" + pow);
    }
}
