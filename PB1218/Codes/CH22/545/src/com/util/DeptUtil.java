package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeptUtil {
    Connection conn = null;    
    // 獲得資料函數庫連接
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // 載入資料函數庫驅動
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database22"; // 連接資料函數庫URL
        String userName = "sa"; // 連接資料函數庫的使用者名稱
        String passWord = "1"; // 連接資料函數庫密碼
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // 獲得資料函數庫連接
            if (conn != null) {
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 傳回Connection對像
    }
    
public void insertDept(Dept dept) {
    conn = getConn(); // 獲得資料函數庫連接
    try {
        PreparedStatement statement = conn
                .prepareStatement("insert into tb_dept values(?,?,?)"); // 定義插入資料函數庫的預先處理敘述
        statement.setString(1,dept.getDid() ); // 設定預先處理敘述的參數值
        statement.setString(2,dept.getdName());
        statement.setString(3, dept.getPriName());      
        statement.executeUpdate(); // 執行預先處理敘述
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public List selectDept() {
        conn = getConn(); // 獲得資料函數庫連接
        Statement statment;
        List list = new ArrayList<Dept>();
        try {
            statment = conn.createStatement(); // 獲得Statement對像
            String sql = "select * from tb_dept"; // 定義查詢SQL敘述
            ResultSet rest = statment.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
            while (rest.next()) { // 循環檢查查詢結果集
              Dept dept = new Dept();
              dept.setDid(rest.getString(1));
              dept.setdName(rest.getString(2));
              dept.setPriName(rest.getString(3));
              list.add(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 傳回查詢結果
    }
}
