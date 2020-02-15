package com.cdd.createJoin;

import java.sql.*;

public class CreateOracle {

public Connection getConnection() {
    Connection conn = null;
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");   //載入資料函數庫驅動
        System.out.println("資料函數庫驅動載入成功！");           //輸出的資訊
        String url = "jdbc:oracle:thin:@localhost:1521:orcl3";  //獲得連接URL
        String user = "system";                     //連接使用者名稱
        String password = "aaa";                    //連接密碼
        Connection con = DriverManager.getConnection(url, user, password);  //獲得資料函數庫連接
        if (con != null) {
            System.out.println("成功的與Oracle資料函數庫建立連接！！");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }        
    return conn;        //傳回Connection實例        
}

    public static void main(String[] args) {
        CreateOracle oracle = new CreateOracle();
        oracle.getConnection();
    }
}
