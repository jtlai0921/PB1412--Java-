package com.mingrisoft.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

public class QueryRunnerTest {
    // 定義JDBC相關參數
    private static String URL = "jdbc:mysql://localhost:3306/db_database18";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USERNAME = "root";
    private static String PASSWORD = "111";
    private static Connection conn;
    
    public static Connection getConnection() {// 用於獲得資料函數庫連接的工具方法
        try {
            DbUtils.loadDriver(DRIVER);// 載入驅動
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 建立連接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static int operate(String sql, Object... params) {// 用於執行有參數的SQL敘述
        int result = 0;
        QueryRunner runner = new QueryRunner();
        try {
            result = runner.update(getConnection(), sql, params);// 執行SQL敘述
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);// 關閉連接
        }
        return result;
    }
    
    public static void main(String[] args) {
        String sql = "insert into users(username, password) values (?, ?)";
        Object[] params = { "mrsoft", "Java" };
        operate(sql, params);// 向資料函數庫中插入一條資料
    }
}
