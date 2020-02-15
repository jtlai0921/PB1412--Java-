package com.cdd.Descartes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class GetDescartes {
    
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
    
    // 獲得笛卡爾乘積方法

public List getDescsrtes() {
    List list = new ArrayList<MrEmp>();
    conn = getConn(); // 獲得與資料函數庫的連接
    try {
        Statement statement = conn.createStatement(); // 獲得Statement對像
        String sql = "select tb_mrdept.*,tb_mremp.name,tb_mremp.sex,tb_mremp.schoolAge from tb_mrdept cross join tb_mremp"; // 定義查詢敘述
        ResultSet rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
        while (rest.next()) { // 循環檢查查詢結果集
            MrEmp mrEmp = new MrEmp();      //定義與查詢結果集對應的JavaBean對像
            mrEmp.setId(rest.getInt(1));    //設定對像屬性
            mrEmp.setdName(rest.getString(2));
            mrEmp.setName(rest.getString(4));
            mrEmp.setPerson(rest.getString(3));
            mrEmp.setSex(rest.getString(5));
            mrEmp.setSchoolAge(rest.getString(6));
            list.add(mrEmp);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // 傳回查詢結果
}
    
    public static void main(String[] args) {
        GetDescartes descartes = new GetDescartes();
        List list = descartes.getDescsrtes();
        System.out.println("笛卡爾乘積查詢：");
        for (int i = 0; i < list.size(); i++) {
            MrEmp mrEmp = (MrEmp) list.get(i);
            System.out.println("編號："+mrEmp.getId()+" 部門名稱："+mrEmp.getdName()+"　負責人："+mrEmp.getPerson()+" 員工姓名："+mrEmp.getName()+
                    " 員工性別："+mrEmp.getSex()+" 學歷："+mrEmp.getSchoolAge());
        }
    }
    
}
