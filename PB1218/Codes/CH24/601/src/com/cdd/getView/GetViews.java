package com.cdd.getView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetViews {
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
    

public List selectView() {
    conn = getConn(); // 獲得資料函數庫連接
    Statement cs = null; // 定義Statement對像
    String sql = "Select name from Sysobjects where xtype='V' and status > 0"; // 定義獲得所有檢視的SQL敘述
    List list = new ArrayList(); // 定義儲存查詢結果的List集合
    try {
        cs = conn.createStatement(); // 實例化Statement對像
        ResultSet rest = cs.executeQuery(sql); // 執行SQL敘述
        while (rest.next()) { // 循環檢查查詢結果集
            String name = rest.getString(1);
            list.add(name);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    public static void main(String[] args) {
        GetViews getViews = new GetViews();
        List list = getViews.selectView();
        for(int i = 0;i<list.size();i++){
            String name = list.get(i).toString();
            System.out.println(name);
        }
    }
}
