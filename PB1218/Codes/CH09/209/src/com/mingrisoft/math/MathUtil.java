package com.mingrisoft.math;

import java.math.BigInteger;

public class MathUtil {
    public static void main(String[] args) {
        BigInteger number1 = new BigInteger("12345"); // �n������׾��number1
        BigInteger number2 = new BigInteger("54321"); // �n������׾��number2
        BigInteger addition = number1.add(number2); // �p��number1�[number2
        BigInteger subtraction = number1.subtract(number2); // �p��number1��number2
        BigInteger multiplication = number1.multiply(number2); // �p��number1��number2
        BigInteger division = number1.divide(number2); // �p��number1��number2
        System.out.println("����׾��number1�G" + number1);
        System.out.println("����׾��number2�G" + number2);
        System.out.println("����׾�ƥ[�k�G" + addition);
        System.out.println("����׾�ƴ�k�G" + subtraction);
        System.out.println("����׾�ƭ��k�G" + multiplication);
        System.out.println("����׾�ư��k�G" + division);
    }
}
