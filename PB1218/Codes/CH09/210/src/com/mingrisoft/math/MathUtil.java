package com.mingrisoft.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtil {
    public static void main(String[] args) {
        BigDecimal number1 = new BigDecimal(1.2345); // 聲明高精度浮點數number1
        BigDecimal number2 = new BigDecimal(5.4321); // 聲明高精度浮點數number2
        BigDecimal addition = number1.add(number2); // 計算number1加number2
        BigDecimal subtraction = number1.subtract(number2); // 計算number1減number2
        BigDecimal multiplication = number1.multiply(number2); // 計算number1乘number2
        // 以四捨五入的方式獲得高精度除法運算的結果
        BigDecimal division = number1.divide(number2, RoundingMode.HALF_UP);
        System.out.println("高精度浮點數number1：" + number1);
        System.out.println("高精度浮點數number2：" + number2);
        System.out.println("高精度浮點數加法：" + addition);
        System.out.println("高精度浮點數減法：" + subtraction);
        System.out.println("高精度浮點數乘法：" + multiplication);
        System.out.println("高精度浮點數除法：" + division);
    }
}
