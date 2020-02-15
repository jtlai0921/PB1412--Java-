package com.mingrisoft.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CatchExceptions {
    private static String URL = "jdbc:mysql://localhost:3306/db_database18";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USERNAME = "mr";
    private static String PASSWORD = "mingri";
    private static Connection conn;
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);// 載入驅動程式
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 建立連接
            return conn;
        } catch (ClassNotFoundException e) {// 捕捉類別為發現例外
            e.printStackTrace();
        } catch (SQLException e) {// 捕捉SQL例外
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        CatchExceptions.getConnection();
    }
}
