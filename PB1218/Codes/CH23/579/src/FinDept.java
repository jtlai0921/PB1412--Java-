

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FinDept {
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

public ResultSet getDept() {
    conn = getConn(); // 獲得與資料函數庫的連接
    ResultSet rest;  
    try {
        Statement statement = conn.createStatement(); // 獲得Statement對像
        String sql = "select * from tb_dept union  select * from tb_dept2"; // 定義查詢敘述
        rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集     
        return rest; // 傳回查詢結果
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

    public static void main(String[] args) {
        FinDept dept = new FinDept();
        ResultSet rest = dept.getDept();
        System.out.println("使用UNION除去重複的行");
        try {
            while(rest.next()){
                int id = rest.getInt(1);
                String name = rest.getString(2);
                System.out.println("編號："+id+" 部門名稱："+name);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
