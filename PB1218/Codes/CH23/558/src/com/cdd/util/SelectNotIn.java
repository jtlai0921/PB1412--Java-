package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectNotIn {
    Connection conn = null;
    
    // 獲得資料函數庫連接
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
            if (conn != null) {
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 傳回Connection對像
    }

public List getNotIn() {
    List list = new ArrayList(); // 定義用於儲存傳回值的List集合
    conn = getConn(); // 獲得資料函數庫連接
    try {
        Statement staement = conn.createStatement();
        String sql = "select * from tb_student where name not in (select name from tb_grade)"; // 定義查詢資料的SQL敘述
        ResultSet set = staement.executeQuery(sql); // 執行查詢敘述傳回查詢結果集
        while (set.next()) { // 循環檢查查詢結果集
            Student student = new Student();        //定義與資料函數庫對應的JavaBean對像
            student.setId(set.getInt(1));           //設定對像屬性
            student.setName(set.getString(2));
            student.setCollege(set.getString(3));
            student.setSpeciality(set.getString(4));
            student.setAddress(set.getString(5));
            list.add(student);                  //將對像增加到集合中
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // 傳回List集合
}
    
    public static void main(String[] args) {
        SelectNotIn notin = new SelectNotIn();
        List list = notin.getNotIn();
        System.out.println("查詢沒有成績的學生資訊：");
        for (int i = 0; i < list.size(); i++) {
            Student student = (Student) list.get(i);
            System.out.println("編號：" + student.getId() +"  姓名："+ student.getName()
                    +"  學院："+ student.getCollege() +"  專業："+ student.getSpeciality()
                    +"  地址："+ student.getAddress());
        }
    }
}
