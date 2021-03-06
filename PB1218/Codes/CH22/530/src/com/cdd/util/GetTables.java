package com.cdd.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTables {
    static Connection conn = null;
    
    // 獲得資料函數庫連接
    public static Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // 載入資料函數庫驅動
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database22"; // 連接資料函數庫URL
        String userName = "sa"; // 連接資料函數庫的使用者名稱
        String passWord = "1"; // 連接資料函數庫密碼
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // 獲得資料函數庫連接
            if (conn != null) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 傳回Connection對像
    }
    
    public static ResultSet GetRs() {
        try {
            String[] tableType = { "TABLE" }; // 指定要進行查詢的表型態
            Connection conn = getConn(); // 呼叫與資料函數庫建立連接方法
            DatabaseMetaData databaseMetaData = conn.getMetaData(); // 獲得DatabaseMetaData實例
            ResultSet resultSet = databaseMetaData.getTables(null, null, "%",
                    tableType);// 獲得資料函數庫中所有資料表集合
            return resultSet;
        } catch (SQLException e) {
            System.out.println("記錄數量獲得失敗！");
            return null;
        }
    }
    
    public static void main(String[] args) {
        ResultSet rst = GetRs();
        System.out.println("資料函數庫中的表有：");
        try {
            while (rst.next()) { // 檢查集合
                String tableName = rst.getString("TABLE_NAME");
                System.out.println(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
