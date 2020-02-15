package com.cdd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindLaborage {
    
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
    
    public ResultSet getMessageEmp() {
        conn = getConn(); // 獲得與資料函數庫的連接
        try {
            Statement statement = conn.createStatement(); // 獲得Statement對像
            String sql = "select distinct dName,laborage.name,laborage.laborage,lYear,lDate from tb_laborage laborage,tb_dept dept,tb_employee emp "
                    + "where laborage.name in(select name from tb_employee where job = '部門經理' "
                    + "and schoolAge = '本科' and dID =  dept.id )"; // 定義查詢敘述
            ResultSet rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
            return rest; // 傳回查詢結果
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        FindLaborage Dlaborage = new FindLaborage(); // 建立本類別對像
        ResultSet rest = Dlaborage.getMessageEmp(); // 呼叫查詢方法
        System.out.println("查詢本科的部門經理的月收入情況");
        try {
            while (rest.next()) { // 循環檢查查詢結果集
                String dName = rest.getString(1); // 獲得結果集中資訊
                String name = rest.getString(2);
                float laborage = rest.getFloat(3);
                int lYear = rest.getInt(4);
                int lDate = rest.getInt(5);
                System.out.println("姓名：" + name + " 部門：" + dName + " 薪水："
                        + laborage + " 年份：" + lYear + " 月份：" + lDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
