package com.cdd.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTrigger {
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

public void insertInfo(User user){
    conn = getConn();       //獲得資料函數庫連接
    try {
        PreparedStatement statement = conn.prepareStatement("insert into tb_user values(?,?,?,?,?)");   //定義增加資料的SQL敘述
        statement.setString(1, user.getUserName());     //設定預先處理敘述的參數值
        statement.setString(2, user.getPassword());
        statement.setInt(3, user.getAge());
        statement.setString(4,user.getSex());
        statement.setString(5, user.getJob());
        statement.executeUpdate();      //執行預先處理敘述
    } catch (Exception e) {           
        e.printStackTrace();
    }        
}
}
