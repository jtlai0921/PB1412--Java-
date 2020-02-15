import java.sql.Connection;
import java.sql.DriverManager;


public class GetConnection {
    
private Connection conn;        //定義Connection對像
public String con(){       
    try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //載入ODBC資料函數庫驅動
        conn = DriverManager.getConnection("jdbc:odbc:db_database22","sa","1");  //獲得資料函數庫連接
        return "資料函數庫連接成功！";  //傳回連接對像
    } catch (Exception e) {          
        e.printStackTrace();
        return "資料函數庫連接失敗！";
    }
}
    public static void main(String[] args) {
       GetConnection getConn = new GetConnection();
       System.out.println(getConn.con());
        
    }    
}
