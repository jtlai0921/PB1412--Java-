package com.mingrisoft.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtil {
    public static void main(String[] args) {
        BigDecimal number1 = new BigDecimal(1.2345); // �n������ׯB�I��number1
        BigDecimal number2 = new BigDecimal(5.4321); // �n������ׯB�I��number2
        BigDecimal addition = number1.add(number2); // �p��number1�[number2
        BigDecimal subtraction = number1.subtract(number2); // �p��number1��number2
        BigDecimal multiplication = number1.multiply(number2); // �p��number1��number2
        // �H�|�ˤ��J���覡��o����װ��k�B�⪺���G
        BigDecimal division = number1.divide(number2, RoundingMode.HALF_UP);
        System.out.println("����ׯB�I��number1�G" + number1);
        System.out.println("����ׯB�I��number2�G" + number2);
        System.out.println("����ׯB�I�ƥ[�k�G" + addition);
        System.out.println("����ׯB�I�ƴ�k�G" + subtraction);
        System.out.println("����ׯB�I�ƭ��k�G" + multiplication);
        System.out.println("����ׯB�I�ư��k�G" + division);
    }
}
