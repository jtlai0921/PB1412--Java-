package com.cdd.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BatchInsert {
  Connection conn = null;
    
    // 獲得資料函數庫連接
    public Connection getConn() {
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
    
public void insertStu(String sql){
    conn = getConn();                       //獲得資料函數庫連接
    try {
        Statement statement = conn.createStatement();   //建立Statement對像
        statement.executeUpdate(sql);       //執行插入SQL敘述
    } catch (Exception e) {           
        e.printStackTrace();
    }        
}

public static void main(String[] args) {
    BatchInsert insert = new BatchInsert();     //建立本類別對像
    String sql = "insert tb_stu select '雙雙','女','生物科學','08d02' " +
    		"union all select '王爽','女','計算機應用','08d02' " +
    		"union all select '朱莉','女','英語','07d02'";     //定義插入的SQL敘述
    insert.insertStu(sql);          //呼叫插入資料方法
}
}
