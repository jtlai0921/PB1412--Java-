package com.mingrisoft.math;

import org.apache.commons.math.complex.Complex;

public class ComplexTest {
    public static void main(String[] args) {
        Complex complex1 = new Complex(1.0, 3.0); // 複數的初始化
        System.out.println("複數complex1是：" + getComplex(complex1));
        Complex complex2 = new Complex(2.0, 5.0); // 複數的初始化
        System.out.println("複數complex2是：" + getComplex(complex2));
        Complex addition = complex1.add(complex2); // 複數的加法運算
        System.out.println("加法運算的結果是：" + getComplex(addition));
        Complex subtraction = complex1.subtract(complex2); // 複數的減法運算
        System.out.println("減法運算的結果是：" + getComplex(subtraction));
        Complex multiplication = complex1.multiply(complex2); // 複數的乘法運算
        System.out.println("乘法運算的結果是：" + getComplex(multiplication));
        Complex division = complex1.divide(complex2); // 複數的除法運算
        System.out.println("除法運算的結果是：" + getComplex(division));
    }
    
    public static String getComplex(Complex complex) {// 自定義輸出複數的方法
        return complex.getReal() + "+" + complex.getImaginary() + "i";
    }
}
