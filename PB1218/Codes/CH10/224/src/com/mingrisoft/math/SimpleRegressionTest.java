package com.mingrisoft.math;

import org.apache.commons.math.stat.regression.SimpleRegression;

public class SimpleRegressionTest {
    public static void main(String[] args) {
        double[][] data = { { 54, 61 }, { 66, 80 }, { 68, 62 }, { 76, 86 }, { 78, 84 }, { 82, 76 }, { 85, 85 }, { 87, 82 }, { 90, 88 }, { 94, 82 }, { 90, 88 }, { 94, 96 } };
        SimpleRegression regression = new SimpleRegression();
        regression.addData(data);// �W�[�n���R�����
        System.out.println("�ײv�O�G" + regression.getSlope());
        System.out.println("�ײv�зǮt�O�G" + regression.getSlopeStdErr());
        System.out.println("�I�Z�O�G" + regression.getIntercept());
        System.out.println("�I�Z�зǮt�O�G" + regression.getInterceptStdErr());
        System.out.println("�~�t����M�O�G" + regression.getSumSquaredErrors());
    }
}
