package com.cdd.format;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GetFormat {
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
    
    // 從檢視中檢索資料

public List selectView() {
    conn = getConn(); // 獲得資料函數庫連接
    Statement cs = null; // 定義CallableStatement對像
    String sql = "Select * from v_emp"; // 定義查詢檢視的SQL敘述
    List list = new ArrayList(); // 定義儲存查詢結果的List集合
    try {
        cs = conn.createStatement(); // 實例化Statement對像
        ResultSet rest = cs.executeQuery(sql); // 執行SQL敘述
        while (rest.next()) { // 循環檢查查詢結果集
            Emp emp = new Emp();
            emp.setName(rest.getString(1));
            emp.setEdate(rest.getString(2));
            list.add(emp);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
   
    public static void main(String[] args) {
        GetFormat format = new GetFormat();
        List list = format.selectView();
        System.out.println("使用檢視重新格式化檢索出的資料");
        for(int i = 0;i<list.size();i++){
           Emp emp = (Emp)list.get(i);
            System.out.println("員工姓名："+emp.getName()+"  入司時間："+emp.getEdate());
       }
   }
   
}
