package com.cdd.useAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FinMaxEmpLaborage {
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
    
    public List getLaborage() {
        conn = getConn(); // 獲得與資料函數庫的連接
        ResultSet rest;
        List list = new ArrayList<Emp>();
        try {
            Statement statement = conn.createStatement(); // 獲得Statement對像
            String sql = "select eName,headship,laborage from tb_emp  where laborage > all(select laborage from tb_emp where dept = '質量部')"; // 定義查詢敘述
            rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
            while (rest.next()) { // 循環檢查查詢結果集
                Emp emp = new Emp(); // 定義域資料表對應的JavaBean對像
                emp.seteName(rest.getString(1)); // 設定對像屬性
                emp.setHeadship(rest.getString(2));
                emp.setLaborage(rest.getFloat(3));
                list.add(emp); // 向集合中增加對像
            }
            return list; // 傳回查詢結果
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        FinMaxEmpLaborage maxLaborage = new FinMaxEmpLaborage();
        List list = maxLaborage.getLaborage();
        System.out.println("查詢比質量部中所有員工薪水都高的員工薪水情況：");
        for (int i = 0; i < list.size(); i++) {
            Emp emp = (Emp) list.get(i);
            System.out.println("姓名：" + emp.geteName() + "  部門："
                    + emp.getHeadship() + "  薪水：" + emp.getLaborage());
        }
    }
}
