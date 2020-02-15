package com.cdd.patindex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreatePatindex {
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

public List getPatindex(String address) {
    conn = getConn(); // 獲得與資料函數庫的連接
    ResultSet rest;
    List list = new ArrayList<Order>();
    try {
        Statement statement = conn.createStatement(); // 獲得Statement對像
        String sql = "select * from tb_order where patindex('" + address
                + "%',address)>0"; // 定義查詢敘述
        rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
        while (rest.next()) {           //循環檢查查詢結果集
            Order order = new Order();      //定義與資料表對應的JavaBean對像
            order.setId(rest.getInt(1));        //設定對像屬性
            order.setName(rest.getString(2));
            order.setAddress(rest.getString(3));
            order.setPhone(rest.getString(4));
            list.add(order);
        }
        return list; // 傳回查詢結果
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    
}
