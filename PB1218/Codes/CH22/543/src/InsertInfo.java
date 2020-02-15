import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class InsertInfo {
 static Connection conn = null;
    
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
    //將使用者登入資訊插入到資料函數庫方法

public void insertUser(User user) {
    conn = getConn(); // 獲得資料函數庫連接
    try {
        PreparedStatement statement = conn
                .prepareStatement("insert into tb_user values(?,?,?)"); // 定義插入資料函數庫的預先處理敘述          
        statement.setString(1, user.getUserName());     //設定預先處理敘述參數
        statement.setString(2, user.getPassWord());
        SimpleDateFormat date_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //根據指定格式定義SimpleDateFormat對像
        String datetime = date_time.format(new Date());     //對目前日期進行格式化
        statement.setString(3, datetime);
        statement.executeUpdate(); // 執行預先處理敘述
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  
    
}
