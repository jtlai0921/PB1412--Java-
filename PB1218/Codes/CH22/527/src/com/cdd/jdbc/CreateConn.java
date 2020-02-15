package com.cdd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConn {
    
private Connection conn ;   //定義Connection對像
public Connection getConnection(){  //定義連接資料函數庫方法
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  //載入資料函數庫驅動
        System.out.println("資料函數庫驅動載入成功！");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=db_database22";  //定義連接資料函數庫URL
        String userName = "sa";
        String passWord = "";
        conn = DriverManager.getConnection(url,userName ,passWord);       //獲得資料函數庫連接
        if(conn != null){
            System.out.println("已成功的與SQLServer2005資料函數庫建立連接！");
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