package com.mingrisoft.configuration;

import java.net.URL;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class XMLConfigurationTest {
    public static void main(String[] args) throws ConfigurationException {
        URL resource = new XMLConfigurationTest().getClass().getResource("Book.xml");
        XMLConfiguration config = new XMLConfiguration(resource);
        String bookName = config.getString("Java�Ϯ�.�ѦW");// ��o�ѦW
        String author = config.getString("Java�Ϯ�.�@��"); // ��o�@��
        String press = config.getString("Java�Ϯ�.�X����"); // ��o�X����
        String ISBN = config.getString("Java�Ϯ�.ISBN"); // ��oISBN
        double price = config.getDouble("Java�Ϯ�.����"); // ��o����
        int pages = config.getInt("Java�Ϯ�.����");// ��o����
        String time = config.getString("Java�Ϯ�.�X���ɶ�");// ��o�X���ɶ�
        System.out.println("�ϮѸ�T");
        System.out.println("�ѦW�G" + bookName);
        System.out.println("�@�̡G" + author);
        System.out.println("�X�����G" + press);
        System.out.println("ISBN�G" + ISBN);
        System.out.println("����G" + price + "��");
        System.out.println("���ơG" + pages);
        System.out.println("�X���ɶ��G" + time);
    }
}
