package com.mingrisoft.oop;

import java.util.Scanner;

public class TemperatureConverter {
    
    public double toFahrenheit(double centigrade) {
        double fahrenheit = 1.8 * centigrade + 32;
        return fahrenheit;
    }
    
    public static void main(String[] args) {
        System.out.println("請輸入要轉換的溫度（單位：攝氏度）");
        Scanner in = new Scanner(System.in);
        double centigrade = in.nextDouble();
        TemperatureConverter tc = new TemperatureConverter();
        double fahrenheit = tc.toFahrenheit(centigrade);
        System.out.println("轉換完成的溫度（單位：華氏度）：" + fahrenheit);
    }
}
