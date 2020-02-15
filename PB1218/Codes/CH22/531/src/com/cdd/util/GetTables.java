package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetTables {
    Connection conn = null;
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 載入MySQL資料函數庫驅動
            String url = "jdbc:mysql://localhost:3306/db_database21"; // 定義與連接資料函數庫的url
            String user = "root"; // 定義連接資料函數庫的使用者名稱
            String passWord = "111"; // 定義連接資料函數庫的密碼
            conn = DriverManager.getConnection(url, user, passWord); // 連接連接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    // 顯示資料函數庫
public ResultSet listDB() {
    String sql = "show tables;"; // 定義查詢資料SQL敘述
    try {
        conn = getConnection(); // 獲得資料函數庫連接
        Statement stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY); // 實例化Statement對像
        ResultSet rs = stmt.executeQuery(sql); // 執行查詢SQL敘述
        return rs;              //傳回查詢結果
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return null;
    }
}
    
    public static void main(String[] args) {
        GetTables tables = new GetTables();
        ResultSet rest = tables.listDB();
        System.out.println("資料函數庫db_database21下的資料表有：");
        try {
            while (rest.next()) {
                System.out.println(rest.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
