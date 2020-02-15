package com.mingrisoft.lang;

import org.apache.commons.lang.math.Fraction;

public class FractionTest {
    public static void main(String[] args) {
        Fraction fraction1 = Fraction.getFraction(1, 3);// �إߤp��1/3
        Fraction fraction2 = Fraction.getFraction(1, 5);// �إߤp��1/5
        Fraction addition = fraction1.add(fraction2);// �p��1/3 + 1/5
        System.out.println("1/3 + 1/5 = " + addition);
        Fraction subtraction = fraction1.subtract(fraction2);// �p��1/3 - 1/5
        System.out.println("1/3 - 1/5 = " + subtraction);
        Fraction multiplication = fraction1.multiplyBy(fraction2);// �p��1/3 * 1/5
        System.out.println("1/3 * 1/5 = " + multiplication);
        Fraction division = fraction1.divideBy(fraction2);// �p��1/3 / 1/5
        System.out.println("1/3 / 1/5 = " + division);
        Fraction invert = fraction1.invert();// �p��1/3���˼�
        System.out.println("1/3���˼ƬO�G" + invert);
        Fraction pow = fraction1.pow(2); // �p��1/3������
        System.out.println("1/3������O�G" + pow);
    }
}
