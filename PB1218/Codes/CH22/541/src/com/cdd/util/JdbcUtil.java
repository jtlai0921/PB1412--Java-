package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
    static Connection conn = null;
    
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
    
    public void insertEmp(Emp emp) {
        conn = getConn(); // 獲得資料函數庫連接
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into tb_emp values(?,?,?,?,?,?)"); // 定義插入資料函數庫的預先處理敘述
            statement.setString(1, emp.getName()); // 設定預先處理敘述的參數值
            statement.setString(2, emp.getSex());
            statement.setInt(3, emp.getAge());
            statement.setString(4, emp.getDept());
            statement.setString(5, emp.getPhone());
            statement.setString(6, emp.getRemark());
            statement.executeUpdate(); // 執行預先處理敘述
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
