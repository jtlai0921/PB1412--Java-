package com.cdd.join;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateMySQL {
    Connection conn = null;
    
public Connection getConnection() {
    try {
        Class.forName("com.mysql.jdbc.Driver"); // ���JMySQL��ƨ�Ʈw�X��
        System.out.println("��ƨ�Ʈw�X�ʸ��J���\�I�I");
        String url = "jdbc:mysql://localhost:3306/db_database22"; // �w�q�P�s����ƨ�Ʈw��url
        String user = "root"; // �w�q�s����ƨ�Ʈw���ϥΪ̦W��
        String passWord = "111"; // �w�q�s����ƨ�Ʈw���K�X
        conn = DriverManager.getConnection(url, user, passWord); // �s���s��
        System.out.println("�w���\���PMySQL��ƨ�Ʈw�إ߳s���I�I");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return conn;
}
    
    public static void main(String[] args) {
        CreateMySQL mySQL = new CreateMySQL();
        mySQL.getConnection();
    }
}
