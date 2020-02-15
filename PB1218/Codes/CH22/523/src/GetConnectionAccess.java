import java.sql.*;
public class GetConnectionAccess {

public boolean Connection(){
    try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //載入資料函數庫驅動
        Connection con = DriverManager.getConnection("jdbc:odbc:access");   //獲得資料函數庫連接
        if(con != null){
            System.out.println("透過JDBC-ODBC橋連接Access資料函數庫");
        }
        return true;
    } catch (Exception e) {       
        e.printStackTrace();
        return false;
    }
}

    public static void main(String[] args) {
        GetConnectionAccess access = new GetConnectionAccess();
        access.Connection();
    }
}
