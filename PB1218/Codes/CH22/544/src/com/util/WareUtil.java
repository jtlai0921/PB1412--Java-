package com.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WareUtil {
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
    
public void insertWare(Ware ware) {
    conn = getConn(); // 獲得資料函數庫連接
    try {
        PreparedStatement statement = conn
                .prepareStatement("insert into tb_ware values(?,?,?,?,?,?,?)"); // 定義插入資料函數庫的預先處理敘述
        statement.setString(1,ware.getSID() ); // 設定預先處理敘述的參數值
        statement.setString(2,ware.getsName());
        statement.setString(3, ware.getSpec());
        statement.setString(4,ware.getCasing());
        statement.setString(5,ware.getUnit() );
        statement.setString(6, ware.getsDate());
        statement.setInt(7, ware.getAmout());
        statement.executeUpdate(); // 執行預先處理敘述
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public List selectWare() {
        conn = getConn(); // 獲得資料函數庫連接
        Statement statment;
        List list = new ArrayList<Ware>();
        try {
            statment = conn.createStatement(); // 獲得Statement對像
            String sql = "select * from tb_ware"; // 定義查詢SQL敘述
            ResultSet rest = statment.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
            while (rest.next()) { // 循環檢查查詢結果集
               Ware ware = new Ware();              //
               ware.setSID(rest.getString(1));
               ware.setsName(rest.getString(2));
               ware.setSpec(rest.getString(3));
               ware.setCasing(rest.getString(4));
               ware.setUnit(rest.getString(5));
               ware.setsDate(rest.getString(6));
               ware.setAmout(rest.getInt(7));
               list.add(ware);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 傳回查詢結果
    }
    public static String getDateTime(){     //該方法傳回值為String型態
        SimpleDateFormat format;
                            //simpleDateFormat類別可以選擇任何使用者定義的日期-時間格式的模式
        Date date = null; 
        Calendar myDate = Calendar.getInstance();
                            //Calendar的方法getInstance()，以獲得此型態的一個通用的對象
        myDate.setTime(new java.util.Date());
                            //使用指定的Date設定此Calendar的時間
        date = myDate.getTime();
                            //傳回一個表示此Calendar時間值（從歷元至現在的毫秒偏移量）的Date對像
        format = new SimpleDateFormat("yyyy-MM-dd");
                            //撰寫格式化時間為「年-月-日 時：分：秒」
        String strRtn = format.format(date);
                            //將指定的Date格式化為日期/時間字串，並將結果給予值給指定的String
        return strRtn;          //傳回儲存傳回值變數
    }

   
}
