package com.mingrisoft.math;

import java.util.Arrays;

import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.RealMatrix;

public class RealMatrixTest {
    public static void main(String[] args) {
        double[][] matrixData1 = { { 1, 2 }, { 3, 4 } };
        RealMatrix m = new Array2DRowRealMatrix(matrixData1);// 利用二維陣列初始化矩陣
        System.out.println("矩陣m中的元素：");
        System.out.println(Arrays.deepToString(m.getData()));// 利用工具類別輸出矩陣中元素
        double[][] matrixData2 = { { 1, 2 }, { 3, 4 } };
        RealMatrix n = new Array2DRowRealMatrix(matrixData2);// 利用二維陣列初始化矩陣
        System.out.println("矩陣n中的元素：");
        System.out.println(Arrays.deepToString(n.getData()));// 利用工具類別輸出矩陣中元素
        RealMatrix addition = m.add(n);// 進行矩陣加法運算
        System.out.println("矩陣addition中的元素：");
        System.out.println(Arrays.deepToString(addition.getData()));
        RealMatrix subtraction = m.subtract(n);// 進行矩陣減法運算
        System.out.println("矩陣subtraction中的元素：");
        System.out.println(Arrays.deepToString(subtraction.getData()));
        RealMatrix multiplication = m.multiply(n);// 進行矩陣乘法運算
        System.out.println("矩陣multiplication中的元素：");
        System.out.println(Arrays.deepToString(multiplication.getData()));
        RealMatrix transposition = m.multiply(n);// 進行矩陣轉置運算
        System.out.println("矩陣m轉置後新矩陣中的元素：");
        System.out.println(Arrays.deepToString(transposition.getData()));
    }
}
