package com.cdd.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TransferUpdate {
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
    //查詢所有學產生績資訊
    public List executeTeacher() {
        conn = getConn(); // 獲得資料函數庫連接
        Statement cs = null; // 定義CallableStatement對像
        String sql = "select * from tb_teacher"; // 定義呼叫預儲程序的SQL敘述
        List list = new ArrayList();
        try {
            cs = conn.createStatement(); // 實例化Statement對像
            ResultSet rest = cs.executeQuery(sql); // 執行SQL敘述
            while (rest.next()) { // 循環檢查查詢結果集
                Teacher teacher = new Teacher();
                teacher.setId(rest.getInt(1));
                teacher.settName(rest.getString(2));
                teacher.setCourse(rest.getString(3));
                list.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return list;
    }
    //查詢指定編號的教師資訊
    public Teacher selectTeacher(int id) {
        conn = getConn(); // 獲得資料函數庫連接
        Statement cs = null; // 定義CallableStatement對像
        String sql = "select * from tb_teacher where id ="+id; // 定義呼叫預儲程序的SQL敘述
        Teacher teacher = new Teacher();
        try {
            cs = conn.createStatement(); // 實例化Statement對像
            ResultSet rest = cs.executeQuery(sql); // 執行SQL敘述
            while (rest.next()) { // 循環檢查查詢結果集               
                teacher.setId(rest.getInt(1));
                teacher.settName(rest.getString(2));
                teacher.setCourse(rest.getString(3));               
            }
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return teacher;
    }

public void updateTeacher(Teacher teacher){
    conn = getConn();       //獲得資料函數庫連接
    try {
        PreparedStatement statement = conn.prepareStatement("update tb_teacher set tName=?,course = ? where id = ?") ;  //定義PreparedStatement對像
        statement.setString(1, teacher.gettName());     //設定預先處理敘述的參數
        statement.setString(2, teacher.getCourse());
        statement.setInt(3, teacher.getId());
        statement.executeUpdate();      //執行刪除操作      
    } catch (SQLException e) {          
        e.printStackTrace();
    }        
}
   
}
