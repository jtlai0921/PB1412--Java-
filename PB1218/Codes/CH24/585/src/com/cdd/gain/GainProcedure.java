package com.cdd.gain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GainProcedure {
    
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
    
    // 定義獲得資料函數庫中所有儲存過程方法

public List executeGain() {
    conn = getConn(); // 獲得資料函數庫連接
    Statement cs = null; 
    String sql = "select name from sysobjects where xtype = 'p' and status > 0"; // 定義呼叫預儲程序的SQL敘述
    List list = new ArrayList(); // 定義用於傳回值的集合對像
    try {
        cs = conn.createStatement();
        ResultSet rest = cs.executeQuery(sql); // 執行SQL敘述
        while (rest.next()) { // 循環檢查查詢結果集
            String name = rest.getString(1);    //獲得查詢結果集中資料
            list.add(name);             //將資料增加到集合中
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;            //傳回查詢結果集
}
    
  
}
