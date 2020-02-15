package com.mingrisoft.math;

import org.apache.commons.math.stat.regression.SimpleRegression;

public class SimpleRegressionTest {
    public static void main(String[] args) {
        double[][] data = { { 54, 61 }, { 66, 80 }, { 68, 62 }, { 76, 86 }, { 78, 84 }, { 82, 76 }, { 85, 85 }, { 87, 82 }, { 90, 88 }, { 94, 82 }, { 90, 88 }, { 94, 96 } };
        SimpleRegression regression = new SimpleRegression();
        regression.addData(data);// 增加要分析的資料
        System.out.println("斜率是：" + regression.getSlope());
        System.out.println("斜率標準差是：" + regression.getSlopeStdErr());
        System.out.println("截距是：" + regression.getIntercept());
        System.out.println("截距標準差是：" + regression.getInterceptStdErr());
        System.out.println("誤差平方和是：" + regression.getSumSquaredErrors());
    }
}
