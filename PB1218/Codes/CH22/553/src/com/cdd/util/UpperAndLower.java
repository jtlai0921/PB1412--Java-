package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpperAndLower {
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
    
    public List getUpperAndLower() {
        List list = new ArrayList(); // 定義用於儲存傳回值的List集合
        conn = getConn(); // 獲得資料函數庫連接
        try {
            Statement staement = conn.createStatement();
            String sql = "select upper(FristName),lower(LastName),nationality,speciality from tb_abroad"; // 定義查詢資料的SQL敘述
            ResultSet set = staement.executeQuery(sql); // 執行查詢敘述傳回查詢結果集
            while (set.next()) { // 循環檢查查詢結果集
                Abord abord = new Abord(); // 定義與資料表對應的JavaBean對像
                abord.setFristName(set.getString(1)); // 設定對像屬性
                abord.setLastName(set.getString(2));
                abord.setNationality(set.getString(3));
                abord.setSpeciality(set.getString(4));
                list.add(abord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 傳回List集合
    }
}
