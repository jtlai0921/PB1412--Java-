package com.mingrisoft.math;

import org.apache.commons.math.complex.Complex;

public class ComplexTest {
    public static void main(String[] args) {
        Complex complex1 = new Complex(1.0, 3.0); // �Ƽƪ���l��
        System.out.println("�Ƽ�complex1�O�G" + getComplex(complex1));
        Complex complex2 = new Complex(2.0, 5.0); // �Ƽƪ���l��
        System.out.println("�Ƽ�complex2�O�G" + getComplex(complex2));
        Complex addition = complex1.add(complex2); // �Ƽƪ��[�k�B��
        System.out.println("�[�k�B�⪺���G�O�G" + getComplex(addition));
        Complex subtraction = complex1.subtract(complex2); // �Ƽƪ���k�B��
        System.out.println("��k�B�⪺���G�O�G" + getComplex(subtraction));
        Complex multiplication = complex1.multiply(complex2); // �Ƽƪ����k�B��
        System.out.println("���k�B�⪺���G�O�G" + getComplex(multiplication));
        Complex division = complex1.divide(complex2); // �Ƽƪ����k�B��
        System.out.println("���k�B�⪺���G�O�G" + getComplex(division));
    }
    
    public static String getComplex(Complex complex) {// �۩w�q��X�Ƽƪ���k
        return complex.getReal() + "+" + complex.getImaginary() + "i";
    }
}
