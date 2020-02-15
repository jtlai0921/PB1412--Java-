package com.mingrisoft.configuration;

import java.net.URL;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class XMLConfigurationTest {
    public static void main(String[] args) throws ConfigurationException {
        URL resource = new XMLConfigurationTest().getClass().getResource("Book.xml");
        XMLConfiguration config = new XMLConfiguration(resource);
        String bookName = config.getString("Java圖書.書名");// 獲得書名
        String author = config.getString("Java圖書.作者"); // 獲得作者
        String press = config.getString("Java圖書.出版社"); // 獲得出版社
        String ISBN = config.getString("Java圖書.ISBN"); // 獲得ISBN
        double price = config.getDouble("Java圖書.價格"); // 獲得價格
        int pages = config.getInt("Java圖書.頁數");// 獲得頁數
        String time = config.getString("Java圖書.出版時間");// 獲得出版時間
        System.out.println("圖書資訊");
        System.out.println("書名：" + bookName);
        System.out.println("作者：" + author);
        System.out.println("出版社：" + press);
        System.out.println("ISBN：" + ISBN);
        System.out.println("價格：" + price + "元");
        System.out.println("頁數：" + pages);
        System.out.println("出版時間：" + time);
    }
}
