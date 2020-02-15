package com.mingrisoft.math;

import java.util.Random;

import org.apache.commons.math.stat.Frequency;

public class FrequencyTest {
    public static void main(String[] args) {
        Frequency frequency = new Frequency();
        for (int i = 0; i < 100; i++) {
            frequency.addValue(new Random().nextInt(10));// 增加100個小於10的隨機數
        }
        System.out.println("頻度分佈直方圖");
        for (int i = 0; i < 10; i++) {// 對於0~9每個數值繪製直方圖
            System.out.print("數值" + i + "的頻度：");
            for (int j = 0; j < frequency.getCount(i); j++) {// 輸入不同個星號來表示不同的頻度
                System.out.print("*");
            }
            System.out.println("\t" + frequency.getCumFreq(i));// 輸出累計頻度
        }
    }
}
