package com.cdd.jdbc;

import java.sql.*;

public class CreateJoin {
    Connection conn = null;
static {
    try {
        Class.forName("net.sourceforge.jtds.jdbc.Driver"); // 載入資料函數庫驅動
        System.out.println("資料函數庫驅動載入成功！");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
    
public Connection getConn() {
    String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database22"; // 連接資料函數庫URL
    String userName = "sa"; // 連接資料函數庫的使用者名稱
    String passWord = "1"; // 連接資料函數庫密碼
    try {
        conn = DriverManager.getConnection(url, userName, passWord); // 獲得資料函數庫連接
        if (conn != null) {
            System.out.println("已成功的與SQLServer2000資料函數庫建立連接！");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return conn; // 傳回Connection對像
}
    
    public static void main(String[] args) {
        CreateJoin join = new CreateJoin();
        Connection conn = join.getConn();
    }
    
}
