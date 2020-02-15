package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BallotUtil {
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
    
    // 定義增加選票表中字段方法
    
    public void addField(String fieldName, String type) {
        conn = getConn(); // 獲得資料函數庫連接
        try {
            Statement statement = conn.createStatement(); // 獲得Statement方法
            String sql = "alter table tb_ballot add " + fieldName + " " + type; // 向資料表中增加字段
            statement.executeUpdate(sql); // 執行更新資料表SQL敘述
            conn.close(); // 關閉資料函數庫連接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 定義刪除選票表中字段方法
    
    public void deleteField(String fieldName) {
        conn = getConn(); // 獲得資料函數庫連接
        try {
            Statement statement = conn.createStatement();
            String sql = "alter table tb_ballot drop column " + fieldName; // 定義從資料函數庫中刪除字段SLQ敘述
            statement.executeUpdate(sql); // 執行刪除操作
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 定義獲得資料表中所有字段方法
    public List getField() {
        List list = new ArrayList();
        conn = getConn();
        try {
            Statement ps = conn.createStatement();
            ResultSet rest = ps.executeQuery("select * from tb_ballot");
            ResultSetMetaData rsme = rest.getMetaData();
            int columnCount = rsme.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String cName = rsme.getColumnName(i);
                list.add(cName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
}
