package com.cdd.more;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class FindMore {
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

public ResultSet getMore() {
    conn = getConn(); // 獲得與資料函數庫的連接
    ResultSet rest;       
    try {
        Statement statement = conn.createStatement(); // 獲得Statement對像
        String sql = "select p.id,p.sName,w.wId,w.wage,l.pID,l.monthL,l.lDate,l.lMoney from (tb_personnel p left join tb_wage w on p.id = w.perId)" +
        		" left join tb_leave l on l.pID = p.id"; // 定義查詢敘述
        rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集           
        return rest; // 傳回查詢結果
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    public static void main(String[] args) {
        FindMore findMore = new FindMore();
        ResultSet rest = findMore.getMore();
        try {
            System.out.println("使用外連接進行多表查詢");
            while(rest.next()){
                int id = rest.getInt(1);
                String sName = rest.getString(2);
                String wId = rest.getString(3);
                float wage = rest.getFloat("wage");
                String pID = rest.getString("pID");
                int mothl = rest.getInt("monthL");
                float dateL = rest.getFloat("lDate");
                float lMoney = rest.getFloat("lMoney");
                System.out.println("編號："+id+" 姓名："+sName+" 薪水編號："+wId+" 薪水："+wage+" 請假編號："+pID+" 請假月份："
                        +mothl+" 請假天數："+dateL+" 扣除薪水："+lMoney);
                
            }
        } catch (SQLException e) {           
            e.printStackTrace();
        }
    }
}
