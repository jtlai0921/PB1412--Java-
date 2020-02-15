package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CopyDate {
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
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 傳回Connection對像
    }
    
    public List getExcellenceStu() {
        conn = getConn(); // 獲得與資料函數庫的連接
        ResultSet rest;
        List list = new ArrayList();
        try {
            Statement statement = conn.createStatement(); // 獲得Statement對像
            String sql = "select * from tb_stu"; // 定義查詢敘述
            rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
            while (rest.next()) { // 循環檢查查詢結果集
                ExcellenceStu excellenceStu = new ExcellenceStu();
                excellenceStu.setId(rest.getInt(1));
                excellenceStu.setName(rest.getString(2));
                excellenceStu.setSex(rest.getString(3));
                excellenceStu.setSpecialty(rest.getString(4));
                excellenceStu.setGrade(rest.getString(5));
                list.add(excellenceStu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 傳回集合
    }
    
    public void insertStu(int id) {
        conn = getConn(); // 獲得與資料函數庫的連接
        try {
            Statement statement = conn.createStatement(); // 獲得Statement對像
            String sql = "insert into tb_excellenceStu select name,sex,specialty,grade from tb_stu where id = "
                    + id; // 定義插入資料的SQL敘述
            statement.executeUpdate(sql); // 執行插入敘述
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
