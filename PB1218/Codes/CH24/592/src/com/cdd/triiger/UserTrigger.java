package com.cdd.triiger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
    public int insertGrade(Grade grade) {
        conn = getConn(); // 獲得資料函數庫連接
        PreparedStatement cs = null; // 定義PreparedStatement對像
        int count = 0;
        try {
            String sql = "insert into tb_grade values(?,?,?,?)"; // 定義插入SQL敘述
            cs = conn.prepareStatement(sql);
            cs.setString(1, grade.getName()); // 設定預先處理敘述參數
            cs.setFloat(2, grade.getMath());
            cs.setFloat(3, grade.getEnglist());
            cs.setFloat(4, grade.getChinese());
            count = cs.executeUpdate(); // 執行預先處理敘述，實現插入操作
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
}
