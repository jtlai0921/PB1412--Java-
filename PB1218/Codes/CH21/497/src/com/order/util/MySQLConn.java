package com.order.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConn {
    
    Connection conn = null;    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 載入MySQL資料函數庫驅動
            String url = "jdbc:mysql://localhost:3306/db_database21"; // 定義與連接資料函數庫的url
            String user = "root"; // 定義連接資料函數庫的使用者名稱
            String passWord = "111"; // 定義連接資料函數庫的密碼
            conn = DriverManager.getConnection(url, user, passWord); // 連接連接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }    
    // 定義按指定按指定條件降序查詢資料方法    
    public List getOrderDesc() {
        List list = new ArrayList(); // 定義用於儲存傳回值的List集合
        conn = getConnection(); // 獲得資料函數庫連接
        try {
            Statement staement = conn.createStatement();
            String sql = "select id,name,sex,className,chinese from tb_student order by chinese limit 0,3"; // 定義查詢資料表中後3條記錄的SQL敘述
            ResultSet set = staement.executeQuery(sql); // 執行查詢敘述傳回查詢結果集
            while (set.next()) { // 循環檢查查詢結果集
                Student student = new Student(); // 定義與資料函數庫對應的JavaBean對像
                student.setId(set.getInt(1)); // 設定對像屬性值
                student.setName(set.getString("name"));
                student.setSex(set.getString("sex"));
                student.setClassName(set.getString("className"));
                student.setChinese(set.getFloat("chinese"));
                list.add(student); // 將JavaBean增加到集合中
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        MySQLConn mySqlConn = new MySQLConn();
        List list = mySqlConn.getOrderDesc();
        System.out.println("查詢語文成績排在後3名的同學資訊：");
        for (int i = 0; i < list.size(); i++) {
            Student student = (Student) list.get(i);
            System.out.println("編號為：" + student.getId() + "，姓名："
                    + student.getName() + "，性別：" + student.getSex() + "，語文成績："
                    + student.getChinese());
        }
    }
}
