import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertString {
    private Connection conn;
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
    
    public void insertUsers(String name ,String loves) {
        conn = getConn(); // 獲得資料函數庫連接
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into tb_users values(?,?)"); // 定義插入資料函數庫的預先處理敘述         
            statement.setString(1,name);
            statement.setString(2,loves);           
            statement.executeUpdate(); // 執行預先處理敘述
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
