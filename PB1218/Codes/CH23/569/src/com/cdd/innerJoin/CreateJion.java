package com.cdd.innerJoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateJion {
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

public ResultSet getJoin() {
    conn = getConn(); // 獲得與資料函數庫的連接
    ResultSet rest;
    try {
        Statement statement = conn.createStatement(); // 獲得Statement對像
        String sql = "select cName,tName from tb_course c inner join tb_teacher  t on c.id = t.cId "; // 定義查詢敘述
        rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
        return rest; // 傳回查詢結果
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        CreateJion createJion = new CreateJion();
        ResultSet rest = createJion.getJoin();
        System.out.println("內連接查詢某課程的教師資訊");
        try {
            while (rest.next()) {
                String cName = rest.getString(1);
                String tName = rest.getString(2);
                System.out.println(cName + "課的教師是：" + tName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
