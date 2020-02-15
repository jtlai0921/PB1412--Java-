package com.cdd.substring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FindStaffer {

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

public List getBirthday() {
    conn = getConn(); // 獲得與資料函數庫的連接
    ResultSet rest;
    List list = new ArrayList<Staffer>();
    try {
        Statement statement = conn.createStatement(); // 獲得Statement對像
        String sql = "select id,sName,substring(code,7,8) as birthday ,code,degree,job from tb_staffer"; // 定義查詢敘述
        rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
        while (rest.next()) { // 循環檢查查詢結果集
            Staffer staffer = new Staffer();    //定義與資料函數庫對應的JavaBean方法
            staffer.setId(rest.getInt(1));      //設定對像屬性
            staffer.setsName(rest.getString(2));
            staffer.setBirthday(rest.getString(3));
            staffer.setCode(rest.getString(4));
            staffer.setDegree(rest.getString(5));
            staffer.setJob(rest.getString(6));
            list.add(staffer);                  //將對像增加到集合中
        }
        return list; // 傳回查詢結果
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}
