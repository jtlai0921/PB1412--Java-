package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class BatchAffair {
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
    //獲得全部使用者編號方法
    public List selectIds() {
        conn = getConn(); // 獲得資料函數庫連接
        Statement cs = null; // 定義CallableStatement對像
        String sql = "Select accoutNumber from tb_transition"; // 定義查詢檢視的SQL敘述
        List list = new ArrayList(); // 定義儲存查詢結果的List集合
        try {
            cs = conn.createStatement(); // 實例化Statement對像
            ResultSet rest = cs.executeQuery(sql); // 執行SQL敘述
            while (rest.next()) { // 循環檢查查詢結果集
                String accoutNumber = rest.getString(1);                
                list.add(accoutNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //設定轉賬方法

public void Batch(String incomeId, String goId, float money) throws SQLException {
    try {
        conn = getConn(); // 獲得資料函數庫連接
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
       
        Statement cs = null; // 定義Statement對像            
        cs = conn.createStatement(); // 實例化Statement對像
        cs.addBatch("update tb_transition set deposit = deposit-" + money
                + " ,transition = transition-" + money
                + " where accoutNumber = " + goId);             //定義修改轉賬表中資料方法
        cs.addBatch("update tb_transition set deposit = deposit+" + money
                + " ,shift = shift+" + money + " where accoutNumber = "
                + incomeId);
        cs.executeBatch(); // 批次執行SQL敘述
        cs.close(); // 將Statement對像關閉
        conn.commit();
        conn.setAutoCommit(autoCommit);
        conn.close();
    } catch (Exception e) {
        conn.rollback();
        e.printStackTrace();        
    }
}
    
}
