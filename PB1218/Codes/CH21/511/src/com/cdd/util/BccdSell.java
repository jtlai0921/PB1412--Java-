package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BccdSell {
    Connection conn = null;
    
    // 獲得資料函數庫連接
    
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // 載入資料函數庫驅動
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database21"; // 連接資料函數庫URL
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
    
public List getBccdSell() {
    List list = new ArrayList(); // 定義用於儲存傳回值的List集合
    conn = getConn(); // 獲得資料函數庫連接    
    try {
        Statement staement = conn.createStatement();
        String sql = "select * from tb_emp where convert(varchar(10),ddate,21) " +
        		"like (select convert(varchar(10),ddate,21) from tb_emp where name = '张静')"; // 定義查詢資料的SQL敘述
        ResultSet set = staement.executeQuery(sql); // 執行查詢敘述傳回查詢結果集
        while (set.next()) { // 循環檢查查詢結果集
            Emp emp = new Emp();
            emp.setId(set.getInt(1));
            emp.setName(set.getString(2));
            emp.setSex(set.getString("sex"));
            emp.setDdate(set.getString("ddate"));
            emp.setDept(set.getString("dept"));
            list.add(emp);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // 傳回List集合
}
    
    public static void main(String[] args) {
        BccdSell sell = new BccdSell();
        List list = sell.getBccdSell();
        System.out.println("與張靜同一天入司的員工有：");
        for(int i = 0;i<list.size();i++){
            Emp emp = (Emp)list.get(i);
            System.out.println("姓名： "+emp.getName()+"  ，性別："+emp.getSex()+" ，部門："+emp.getDept()+"   ，入司時間："+emp.getDdate());
         }
    }
}
