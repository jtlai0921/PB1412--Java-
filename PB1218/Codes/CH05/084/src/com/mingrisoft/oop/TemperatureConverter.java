package com.mingrisoft.oop;

import java.util.Scanner;

public class TemperatureConverter {
    
    public double toFahrenheit(double centigrade) {
        double fahrenheit = 1.8 * centigrade + 32;
        return fahrenheit;
    }
    
    public static void main(String[] args) {
        System.out.println("�п�J�n�ഫ���ūס]���G���ס^");
        Scanner in = new Scanner(System.in);
        double centigrade = in.nextDouble();
        TemperatureConverter tc = new TemperatureConverter();
        double fahrenheit = tc.toFahrenheit(centigrade);
        System.out.println("�ഫ�������ūס]���G�ؤ�ס^�G" + fahrenheit);
    }
}
