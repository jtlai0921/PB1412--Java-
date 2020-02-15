package com.cdd.jdbc;

import java.sql.*;
import java.io.*;

public class CreateJavaDBJoin {
    
    private static final String DRIVERCLASS = "org.apache.derby.jdbc.EmbeddedDriver"; // 資料函數庫驅動
    private static final String URL = "jdbc:derby:db_database22";// 資料函數庫URL
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>(); // 建立用來儲存資料函數庫連接的線程
    private static Connection conn = null;// 資料函數庫連接
    
    static { // 透過靜態方法載入資料函數庫驅動，並且在資料函數庫不存在的情況下建立資料函數庫
        try {
            Class.forName(DRIVERCLASS); // 載入資料函數庫驅動
            System.out.println("資料函數庫驅動載入成功！！");
            File albumF = new File("db_database22");// 建立資料函數庫檔案對像
            if (!albumF.exists()) {// 判斷資料函數庫檔案是否存在
                String[] sqls = new String[1];// 定義建立資料函數庫的SQL敘述
                sqls[0] = "create table tb_album (name varchar(200) not null)";
            } else {
                conn = DriverManager.getConnection(URL + ";create=true");// 建立資料函數庫連接
                System.out.println("已成功的與JavaDB資料函數庫建立連接！！");
                threadLocal.set(conn);// 儲存資料函數庫連接
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected Connection getConnection() { // 建立資料函數庫連接的方法
        conn = (Connection) threadLocal.get(); // 從線程中獲得資料函數庫連接
        if (conn == null) { // 沒有可用的資料函數庫連接
            try {
                conn = DriverManager.getConnection(URL);// 建立新的資料函數庫連接
                threadLocal.set(conn); // 將資料函數庫連接儲存到線程中
                
            } catch (Exception e) {
                String[] infos = { "未能成功連接資料函數庫！", "請確認本軟件是否已經執行！" };
                
                e.printStackTrace();
            }
        }
        
        return conn;
    }
    
    protected boolean closeConnection() { // 關閉資料函數庫連接的方法
        boolean isClosed = true; // 預設關閉成功
        conn = (Connection) threadLocal.get(); // 從線程中獲得資料函數庫連接
        threadLocal.set(null); // 清空線程中的資料函數庫連接
        if (conn != null) { // 資料函數庫連接可用
            try {
                conn.close(); // 關閉資料函數庫連接
            } catch (SQLException e) {
                isClosed = false; // 關閉失敗
                e.printStackTrace();
            }
        }
        return isClosed;
    }
    
    public static void main(String[] args) {
        CreateJavaDBJoin javaDBJoin = new CreateJavaDBJoin();
        javaDBJoin.getConnection();
    }
    
}
