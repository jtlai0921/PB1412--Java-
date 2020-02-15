package com.mingrisoft.math;

import java.util.Arrays;

import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.RealMatrix;

public class RealMatrixTest {
    public static void main(String[] args) {
        double[][] matrixData1 = { { 1, 2 }, { 3, 4 } };
        RealMatrix m = new Array2DRowRealMatrix(matrixData1);// �Q�ΤG���}�C��l�Ưx�}
        System.out.println("�x�}m���������G");
        System.out.println(Arrays.deepToString(m.getData()));// �Q�Τu�����O��X�x�}������
        double[][] matrixData2 = { { 1, 2 }, { 3, 4 } };
        RealMatrix n = new Array2DRowRealMatrix(matrixData2);// �Q�ΤG���}�C��l�Ưx�}
        System.out.println("�x�}n���������G");
        System.out.println(Arrays.deepToString(n.getData()));// �Q�Τu�����O��X�x�}������
        RealMatrix addition = m.add(n);// �i��x�}�[�k�B��
        System.out.println("�x�}addition���������G");
        System.out.println(Arrays.deepToString(addition.getData()));
        RealMatrix subtraction = m.subtract(n);// �i��x�}��k�B��
        System.out.println("�x�}subtraction���������G");
        System.out.println(Arrays.deepToString(subtraction.getData()));
        RealMatrix multiplication = m.multiply(n);// �i��x�}���k�B��
        System.out.println("�x�}multiplication���������G");
        System.out.println(Arrays.deepToString(multiplication.getData()));
        RealMatrix transposition = m.multiply(n);// �i��x�}��m�B��
        System.out.println("�x�}m��m��s�x�}���������G");
        System.out.println(Arrays.deepToString(transposition.getData()));
    }
}
