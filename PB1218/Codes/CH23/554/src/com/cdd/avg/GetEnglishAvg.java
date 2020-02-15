package com.cdd.avg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetEnglishAvg {
    private Connection conn; // 定義Connection對像
    
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
    /**
     * @param args
     */
    
    public List getAvg() {
        List list = new ArrayList<Grade>(); // 定義List集合對像
        conn = getConn(); // 獲得與資料函數庫的連接
        try {
            Statement statement = conn.createStatement(); // 獲得Statement對像
            String sql = "select id,name,english,( select avg(english) from tb_grade ) as avgEnglish,"
                    + "(english-( select avg(english) from tb_grade )) as diffAvgEnglish from tb_grade"; // 定義查詢敘述
            ResultSet rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
            while (rest.next()) { // 循環檢查查詢結果集
                Grade grade = new Grade(); // 定義與資料表對應的JavaBean對像
                grade.setId(rest.getInt(1)); // 設定對像屬性
                grade.setName(rest.getString(2));
                grade.setEnglish(rest.getFloat(3));
                grade.setAvgEng(rest.getFloat(4));
                grade.setBalance(rest.getFloat(5));
                list.add(grade); // 向集合中增加元素
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 傳回查詢結果
    }    
    public static void main(String[] args) {
        GetEnglishAvg getEnglishAvg = new GetEnglishAvg();
        List list = getEnglishAvg.getAvg();
        System.out.println("查詢學生英語成績、英語平均成績、成績差額：");
        for (int i = 0; i < list.size(); i++) {
            Grade grade = (Grade) list.get(i);
            System.out.println("編號：" + grade.getId() + " 姓名：" + grade.getName()
                    + "  英語成績：" + grade.getEnglish() + " 平均成績："
                    + grade.getAvgEng() + " 成績差額：" + grade.getBalance());
        }
        
    }
    
}
