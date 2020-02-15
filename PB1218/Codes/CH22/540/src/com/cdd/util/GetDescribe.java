package com.cdd.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetDescribe {
    Connection conn = null;
    
    // 獲得資料函數庫連接
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
    //定義獲得字段的描述資訊方法

public List getDescribe(String tableName) {
    conn = getConn();           //獲得資料函數庫連接
    List list = new ArrayList();    //定義List集合對像
    try {
        Statement stmt = conn.createStatement();    //獲得Statement對像
        ResultSet rest = stmt
                .executeQuery("select c.name,b.value FROM sysobjects a,sysproperties b,syscolumns " +
                		"c where a.name='"+tableName+"' and a.id=b.id and b.id=c.id and b.smallid=c.colorder");   //執行查詢敘述
        while(rest.next()){ //循環檢查查詢結果集
            Describe describe = new Describe(); //定義定義的JavaBean對像
            describe.setName(rest.getString(1));    //設定對像屬性
            describe.setValue(rest.getString(2));   
            list.add(describe);             //向集合中增加對像
        }
    } catch (Exception e) {
        e.printStackTrace();
    } 
    return list;
}    
    
    //主方法
    public static void main(String[] args) {
        GetDescribe getDescribe = new GetDescribe();
        List list = getDescribe.getDescribe("tb_book");
        System.out.println("資料表tb_book的字段與描述資訊為：");
        for(int i = 0;i<list.size();i++){
            Describe describe = (Describe)list.get(i);
            System.out.println("   字段為："+describe.getName()+"  描述資訊為："+describe.getValue());
        }
    }
    
}
