package com.cdd.backUp;

import java.sql.*;
import java.util.*;

public class BackupData {
    public Connection Con() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection Con = DriverManager.getConnection(
                    "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=master",
                    "sa", "1");
            return Con;
        } catch (Exception e) {
            return null;
        }
    }
    
    // 獲得所有資料函數庫名稱
    
public List getDatabase() {
    List list = new ArrayList(); // 定義List集合對像
    Connection con = Con(); // 獲得資料函數庫連接
    Statement st; // 定義Statement對像
    try {
        st = con.createStatement(); // 實例化Statement對像
        ResultSet rs = st.executeQuery("select name from dbo.sysdatabases"); // 指定查詢所有資料函數庫方法
        while (rs.next()) { // 循環檢查查詢結果集
            list.add(rs.getString(1)); // 將查詢資料增加到List集合中
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // 傳回查詢結果
}
    
    // 定義查詢備份資料函數庫方法

public void getBak(String databaseName, String databasePath) {
    Connection con = Con();           //獲得資料函數庫連接
    Statement st;
    try {
        st = con.createStatement();     //實例化Statement對像
        st.executeUpdate("backup database " + databaseName + " to disk='"
                + databasePath + "'");      //指定資料函數庫備份SQL敘述
        con.close();                //關閉連接
    } catch (SQLException e) {          
        e.printStackTrace();
    }        
}
    
}
