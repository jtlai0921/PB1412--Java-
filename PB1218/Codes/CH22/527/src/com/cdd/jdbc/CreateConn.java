package com.cdd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConn {
    
private Connection conn ;   //�w�qConnection�ﹳ
public Connection getConnection(){  //�w�q�s����ƨ�Ʈw��k
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  //���J��ƨ�Ʈw�X��
        System.out.println("��ƨ�Ʈw�X�ʸ��J���\�I");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=db_database22";  //�w�q�s����ƨ�ƮwURL
        String userName = "sa";
        String passWord = "";
        conn = DriverManager.getConnection(url,userName ,passWord);       //��o��ƨ�Ʈw�s��
        if(conn != null){
            System.out.println("�w���\���PSQLServer2005��ƨ�Ʈw�إ߳s���I");
        }
    } catch (Exception e) {          
        e.printStackTrace();
    }
    return conn;
}
    
    /**
     * @param args
     */
    
    public static void main(String[] args) {
        CreateConn conn = new CreateConn();
        conn.getConnection();        
    }
    
}
