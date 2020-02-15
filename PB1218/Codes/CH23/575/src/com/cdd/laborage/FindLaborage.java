package com.cdd.laborage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    
    public List getPatindex() {
        conn = getConn(); // 獲得與資料函數庫的連接
        ResultSet rest;
        List list = new ArrayList<FindLaborage>();
        try {
            Statement statement = conn.createStatement(); // 獲得Statement對像
            String sql = "select id,name,Base,round(Subsidy,0) as subsidy, round(deduct,0) as deduct from tb_particularLaborage"; // 定義查詢敘述
            rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
            while (rest.next()) { // 循環檢查查詢結果集
                ParticularLaborage laborage = new ParticularLaborage(); // 定義域資料表對應的JavaBean對像
                laborage.setId(rest.getInt(1)); // 設定對像屬性
                laborage.setName(rest.getString(2));
                laborage.setBase(rest.getFloat(3));
                laborage.setSubsidy(rest.getFloat(4));
                laborage.setDeduct(rest.getFloat(5));
                list.add(laborage); // 向集合中增加對像
            }
            return list; // 傳回查詢結果
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        FindLaborage findLaborage = new FindLaborage();
        List list = findLaborage.getPatindex();
        System.out.println("將資料進行四捨五入：");
        for (int i = 0; i < list.size(); i++) {
            ParticularLaborage particularLaborage = (ParticularLaborage) list
                    .get(i);
            int id = particularLaborage.getId();
            String name = particularLaborage.getName();
            float base = particularLaborage.getBase();
            float subsidy = particularLaborage.getSubsidy();
            float deduct = particularLaborage.getDeduct();
            System.out.println("編號：" + id + " 姓名：" + name + "  基本薪水：" + base
                    + " 津貼：" + subsidy + " 扣除：" + deduct);
        }
    }
}
