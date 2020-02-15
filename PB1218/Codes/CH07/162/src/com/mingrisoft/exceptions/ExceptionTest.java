package com.mingrisoft.exceptions;

public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println("-1.0 / 0 = " + (-1.0 / 0));// 示範負浮點數除0
        System.out.println("+1.0 / 0 = " + (+1.0 / 0));// 示範正浮點數除0
        System.out.println("-1 / 0 = " + (-1 / 0));// 示範負整數除0
        System.out.println("+1 / 0 = " + (-1 / 0));// 示範正整數除0
    }
}
