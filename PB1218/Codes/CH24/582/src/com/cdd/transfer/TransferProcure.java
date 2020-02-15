package com.cdd.transfer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferProcure {
    
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

public String executeQuery(String userName,String passWord){
    String message = "驗證失敗";            //定義儲存傳回值的字串對像
    conn = getConn();                      //獲得資料函數庫連接
    CallableStatement cs = null;            //定義CallableStatement對像
    String sql = "{call validateSelect('"+userName+"','"+passWord+"')}";    //定義呼叫儲存過程敘述
    try {
        cs = conn.prepareCall(sql);         //呼叫儲存過程
        ResultSet rest = cs.executeQuery(); //獲得結果集
        while(rest.next()){                 //循環檢查結果集對像
            message = "驗證成功";            //設定對像資訊   
        }            
    } catch (SQLException e) {          
        e.printStackTrace();
    }
    return message;                          //傳回String對像
}

}
