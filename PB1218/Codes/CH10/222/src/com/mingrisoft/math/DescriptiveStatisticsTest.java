package com.mingrisoft.math;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

public class DescriptiveStatisticsTest {
    public static void main(String[] args) {
        DescriptiveStatistics ds = new DescriptiveStatistics(10);
        for (int i = 0; i < 10; i++) {
            ds.addValue(new Random().nextInt(10));// 向資料集中增加10個小於10的隨機變數
        }
        System.out.println("資料集中的全部元素：");
        System.out.println(Arrays.toString(ds.getValues()));
        System.out.println("資料集的算數平均數是：" + ds.getMean());
        System.out.println("資料集的幾何平均數是：" + ds.getGeometricMean());
        System.out.println("資料集的方差是：" + ds.getVariance());
        System.out.println("資料集的標準方差是：" + ds.getStandardDeviation());
        System.out.println("資料集的和是：" + ds.getSum());
        System.out.println("資料集的平方和是：" + ds.getSumsq());
        System.out.println("資料集的最大值是：" + ds.getMax());
        System.out.println("資料集的最小值是：" + ds.getMin());
        System.out.println("資料集的中位數是：" + ds.getPercentile(50));
        System.out.println("資料集的偏度是：" + ds.getSkewness());
        System.out.println("資料集的峰度是：" + ds.getKurtosis());
    }
}
