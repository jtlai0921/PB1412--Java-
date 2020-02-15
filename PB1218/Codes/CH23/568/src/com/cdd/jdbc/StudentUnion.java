package com.cdd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentUnion {
    private Connection conn;    
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

public List getMessageEmp() {
    conn = getConn(); // 獲得與資料函數庫的連接
    List list = new ArrayList<Student>();
    try {
        Statement statement = conn.createStatement(); // 獲得Statement對像
        String sql = "select * from tb_stu2006 union select * from tb_stu2007 union select * from tb_stu2008"; // 定義查詢敘述
        ResultSet rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
        while(rest.next()){              
            Student student = new Student();
            student.setId(rest.getString(1));
            student.setName(rest.getString(2));
            student.setSex(rest.getString(3));
            student.setSpciality(rest.getString(4));
            student.setAddress(rest.getString(5));
            list.add(student);
        }
        return list; // 傳回查詢結果
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
   
    
}
