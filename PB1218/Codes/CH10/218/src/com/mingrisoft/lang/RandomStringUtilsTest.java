package com.mingrisoft.lang;

import org.apache.commons.lang.RandomStringUtils;

public class RandomStringUtilsTest {
    public static void main(String[] args) {
        System.out.println("���ͪ��׬�5���Ѧr���զ����r��");
        String randomString = RandomStringUtils.randomAlphabetic(5); // ��o�H���r��
        System.out.println(randomString);
        System.out.println("���ͪ��׬�5���Ѧr���M�Ʀr�զ����r��");
        randomString = RandomStringUtils.randomAlphanumeric(5); // ��o�H���r��
        System.out.println(randomString);
        System.out.println("���ͪ��׬�5����ASCII�g�{���b32~126���r�Ųզ����r��");
        randomString = RandomStringUtils.randomAscii(5); // ��o�H���r��
        System.out.println(randomString);
        System.out.println("���ͪ��׬�5���ѼƦr�զ����r��");
        randomString = RandomStringUtils.randomNumeric(5); // ��o�H���r��
        System.out.println(randomString);
    }
}
