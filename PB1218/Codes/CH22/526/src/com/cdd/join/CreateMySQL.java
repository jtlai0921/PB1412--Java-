package com.cdd.join;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateMySQL {
    Connection conn = null;
    
public Connection getConnection() {
    try {
        Class.forName("com.mysql.jdbc.Driver"); // 載入MySQL資料函數庫驅動
        System.out.println("資料函數庫驅動載入成功！！");
        String url = "jdbc:mysql://localhost:3306/db_database22"; // 定義與連接資料函數庫的url
        String user = "root"; // 定義連接資料函數庫的使用者名稱
        String passWord = "111"; // 定義連接資料函數庫的密碼
        conn = DriverManager.getConnection(url, user, passWord); // 連接連接
        System.out.println("已成功的與MySQL資料函數庫建立連接！！");
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