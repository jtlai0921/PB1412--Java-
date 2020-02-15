package com.mingrisoft.math;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.TDistributionImpl;

public class TDistributionImplTest {
    public static void main(String[] args) throws MathException {
        TDistributionImpl t = new TDistributionImpl(5);// 新增一個自由度為5的T分佈
        System.out.println("目前T分佈的自由度：" + t.getDegreesOfFreedom());
        double upperTail = t.cumulativeProbability(0.7267);
        System.out.println("計算域大於0.7267的置信度：" + upperTail);
        System.out.println("計算0點的機率密度：" + t.density(0));
        double domain = t.inverseCumulativeProbability(0.75);
        System.out.println("計算置信度大於0.75的域值：" + domain);
    }
}
