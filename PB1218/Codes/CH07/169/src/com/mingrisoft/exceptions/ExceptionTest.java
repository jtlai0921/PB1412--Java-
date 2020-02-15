package com.mingrisoft.exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExceptionTest {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/db_database";// MySQL資料函數庫的URL
        String DRIVER = "com.mysql.jdbc.Driver";// MySQL資料函數庫的驅動
        String USERNAME = "mr";// 資料函數庫的使用者名稱
        Connection connection = null;
        try {
            Class.forName(DRIVER);// 載入驅動
            connection = DriverManager.getConnection(URL, USERNAME, "");// 建立連接
        } catch (SQLException e) {// 捕捉SQLException
            e.printStackTrace();
        } catch (ClassNotFoundException e) {// 捕捉ClassNotFoundException
            e.printStackTrace();
        } finally {
            try {
                connection.close();// 釋放資源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
