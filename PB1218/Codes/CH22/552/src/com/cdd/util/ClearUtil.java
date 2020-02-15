package com.cdd.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClearUtil {
    // 獲得資料函數庫連接
    private Connection conn;
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

public void deleteDate(String dataName){
    conn = getConn();   //獲得資料函數庫連接
    try {
        Statement statement = conn.createStatement();   //獲得Statement對像
        statement.executeUpdate("TRUNCATE TABLE  "+dataName);               //指定刪除敘述
    } catch (Exception e) {       
        e.printStackTrace();
    }
    
}
    //定義查詢資料函數庫中所有資料表方法
    public List GetRs() {
        List list = new ArrayList<String>();
        try {            
            String[] tableType = { "TABLE" }; // 指定要進行查詢的表型態
            Connection conn = getConn(); // 呼叫與資料函數庫建立連接方法
            DatabaseMetaData databaseMetaData = conn.getMetaData(); // 獲得DatabaseMetaData實例
            ResultSet resultSet = databaseMetaData.getTables(null, null, "%",
                    tableType);// 獲得資料函數庫中所有資料表集合
            while(resultSet.next()){
                String tableName = resultSet.getString("TABLE_NAME");
                list.add(tableName);
            }          
        } catch (SQLException e) {
            System.out.println("記錄數量獲得失敗！");
          
        }
        return list;
    }
    
    public static void main(String[] args) {
        ClearUtil util = new ClearUtil();
        util.deleteDate("tb_empess");
    }
    
}
