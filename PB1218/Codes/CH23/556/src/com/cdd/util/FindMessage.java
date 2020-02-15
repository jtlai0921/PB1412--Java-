package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class FindMessage {
  private Connection conn; // 定義Connection對像
    
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
    /**
     * @param args
     */
    
public ResultSet getMessage() {
    ResultSet rest = null;
    conn = getConn(); // 獲得與資料函數庫的連接
    try {
        Statement statement = conn.createStatement(); // 獲得Statement對像
        String sql = "select name,college,address from tb_student I where exists " +
        		"(select name from tb_grade M where M.name=I.name and english >90)"; // 定義查詢敘述
        rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集           
    } catch (Exception e) {
        e.printStackTrace();
    }
    return rest; // 傳回查詢結果
}    
    /**
     * @param args
     */
    public static void main(String[] args) {
       FindMessage findMessage = new FindMessage();
       ResultSet rest = findMessage.getMessage();
       System.out.println("查詢英文成績在90分以上的學生資訊：");
       try {
        while(rest.next()){
               String name = rest.getString(1);
               String college = rest.getString(2);
               String address = rest.getString(3);
               System.out.println("姓名為："+name+" 學院為："+college+" 地址為："+address);
           }
    } catch (Exception e) {       
        e.printStackTrace();
    }
    }
    
}
