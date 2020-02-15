package com.cdd.userView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserViewData {
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
    
    // 從檢視中檢索資料
    
    public List selectView() {
        conn = getConn(); // 獲得資料函數庫連接
        Statement cs = null; // 定義CallableStatement對像
        String sql = "Select * from v_ware"; // 定義查詢檢視的SQL敘述
        List list = new ArrayList(); // 定義儲存查詢結果的List集合
        try {
            cs = conn.createStatement(); // 實例化Statement對像
            ResultSet rest = cs.executeQuery(sql); // 執行SQL敘述
            while (rest.next()) { // 循環檢查查詢結果集
                Ware ware = new Ware();
                ware.setwName(rest.getString(1));
                ware.setProfit(rest.getString(2));
                list.add(ware);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
