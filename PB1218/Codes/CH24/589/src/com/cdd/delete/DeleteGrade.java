package com.cdd.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeleteGrade {
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
    
    // 查詢所有學生資訊
    public List executeGrade() {
        conn = getConn(); // 獲得資料函數庫連接
        Statement cs = null; // 定義CallableStatement對像
        String sql = "select * from tb_grade"; // 定義呼叫預儲程序的SQL敘述
        List list = new ArrayList();
        try {
            cs = conn.createStatement(); // 實例化Statement對像
            ResultSet rest = cs.executeQuery(sql); // 執行SQL敘述
            while (rest.next()) { // 循環檢查查詢結果集
                Grade grade = new Grade();
                grade.setId(rest.getInt(1));
                grade.setName(rest.getString(2));
                grade.setChinese(rest.getFloat("chinese"));
                grade.setEnglist(rest.getFloat("englist"));
                grade.setMath(rest.getFloat("math"));
                list.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // 查詢所有學生資訊
    public List executeStu() {
        conn = getConn(); // 獲得資料函數庫連接
        Statement cs = null; // 定義CallableStatement對像
        String sql = "select * from tb_stu"; // 定義呼叫預儲程序的SQL敘述
        List list = new ArrayList();
        try {
            cs = conn.createStatement(); // 實例化Statement對像
            ResultSet rest = cs.executeQuery(sql); // 執行SQL敘述
            while (rest.next()) { // 循環檢查查詢結果集
                Stu stu = new Stu();
                stu.setId(rest.getInt(1));
                stu.setName(rest.getString(2));
                stu.setSex(rest.getString(3));
                stu.setSpecialty(rest.getString(4));
                list.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // 刪除學產生績資訊
    
    public void deleteGrade(int id) {
        conn = getConn(); // 獲得資料函數庫連接
        try {
            Statement statement = conn.createStatement(); // 定義Statement方法
            statement.executeUpdate("delete from tb_grade where id=" + id); // 執行刪除操作
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
