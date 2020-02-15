package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WareUtil {
    private Connection conn;    
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // 載入資料函數庫驅動
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database23"; // 連接資料函數庫URL
        String userName = "sa"; // 連接資料函數庫的使用者名稱
        String passWord = "1"; // 連接資料函數庫密碼
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // 獲得資料函數庫連接
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 傳回Connection對像
    }    
    public List getWare() {
        conn = getConn(); // 獲得與資料函數庫的連接
        ResultSet rest;
        List list = new ArrayList();
        try {
            Statement statement = conn.createStatement(); // 獲得Statement對像
            String sql = "select id,wName,price,convert(varchar(30),price/(select sum(price) from tb_ware) * 100)+'%' as percente from tb_ware"; // 定義查詢敘述
            rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
            while (rest.next()) { // 循環檢查查詢結果集
                Ware ware = new Ware(); // 定義與資料表對應的JavaBean對像
                ware.setId(rest.getInt(1)); // 設定對像屬性
                ware.setwName(rest.getString(2));
                ware.setPrice(rest.getFloat(3));
                ware.setPercent(rest.getString(4));
                list.add(ware); // 像集合中增加對像
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 傳回集合
    }
}
