package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpdateStu {
    // 獲得資料函數庫連接
    private Connection conn;
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
    //定義更新tb_stu表方法

public void updateStu(Stu stu){
    conn = getConn();   //獲得資料函數庫連接
    try {
        PreparedStatement statement = conn.prepareStatement("update tb_stu set name = ?,sex = ?,grade = ?,specialty = ? where id = ?");//定義更新SQL敘述
        statement.setString(1, stu.getName());  //設定預先處理敘述參數
        statement.setString(2, stu.getSex());
        statement.setString(3,stu.getGrade());
        statement.setString(4, stu.getSpecialty());
        statement.setInt(5, stu.getId());
        statement.execute();    //執行預先處理敘述
    } catch (Exception e) {            
        e.printStackTrace();
    }        
}
    
    //定義查詢所有同學資訊方法
    public List selectStu(){
        conn = getConn();
        Statement statement;
        List list = new ArrayList<Stu>();
        try {
            statement = conn.createStatement();
            ResultSet rest = statement.executeQuery("select * from tb_stu");
            while(rest.next()){
                Stu stu = new Stu();
                stu.setId(rest.getInt(1));
                stu.setName(rest.getString(2));
                stu.setGrade(rest.getString("grade"));
                stu.setSex(rest.getString(3));
                stu.setSpecialty(rest.getString(4));
                list.add(stu);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return list;        
    }
    //定義按照指定編號查詢學生資訊方法
    public Stu selectStu(int id){
        conn = getConn();
        Statement statement;
        Stu stu = new Stu();
        try {         
            statement = conn.createStatement();
            ResultSet rest = statement.executeQuery("select * from tb_stu where id = "+id);
            while(rest.next()){              
                stu.setId(rest.getInt(1));
                stu.setName(rest.getString(2));
                stu.setGrade(rest.getString("grade"));
                stu.setSex(rest.getString(3));
                stu.setSpecialty(rest.getString(4));          
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return stu;        
    }
}
