package com.mingrisoft.lang;

import org.apache.commons.lang.RandomStringUtils;

public class RandomStringUtilsTest {
    public static void main(String[] args) {
        System.out.println("產生長度為5的由字母組成的字串");
        String randomString = RandomStringUtils.randomAlphabetic(5); // 獲得隨機字串
        System.out.println(randomString);
        System.out.println("產生長度為5的由字母和數字組成的字串");
        randomString = RandomStringUtils.randomAlphanumeric(5); // 獲得隨機字串
        System.out.println(randomString);
        System.out.println("產生長度為5的由ASCII寫程式在32~126間字符組成的字串");
        randomString = RandomStringUtils.randomAscii(5); // 獲得隨機字串
        System.out.println(randomString);
        System.out.println("產生長度為5的由數字組成的字串");
        randomString = RandomStringUtils.randomNumeric(5); // 獲得隨機字串
        System.out.println(randomString);
    }
}
