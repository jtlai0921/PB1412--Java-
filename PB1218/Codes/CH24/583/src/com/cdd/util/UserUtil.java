package com.cdd.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserUtil {
    
    private Connection conn;
    
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // 載入資料函數庫驅動
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database24"; // 連接資料函數庫URL
        String userName = "sa"; // 連接資料函數庫的使用者名稱
        String passWord = "1"; // 連接資料函數庫密碼
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // 獲得資料函數庫連接
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 傳回Connection對像
    }

public boolean executeUpdate(User user) {
    conn = getConn(); // 獲得資料函數庫連接
    CallableStatement cs = null; // 定義CallableStatement對像
    String sql = "{call insertUser('" + user.getUserName() + "','"
            + user.getPassword() + "','" + user.getAge() + "','"
            + user.getSex() + "','" + user.getJob() + "')}";    //定義呼叫預儲程序的SQL敘述
    try {
        cs = conn.prepareCall(sql);     //實例化CallableStatement對像
        cs.executeUpdate();             //執行SQL敘述
        return true;
    } catch (SQLException e) {   
        e.printStackTrace();
        return false;
    }        
}
}
