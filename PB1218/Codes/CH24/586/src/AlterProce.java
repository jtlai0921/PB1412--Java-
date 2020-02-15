import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AlterProce {
    private Connection conn;
    
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // 載入資料函數庫驅動
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database24"; // 連接資料函數庫URL
        String userName = "sa"; // 連接資料函數庫的使用者名稱
        String passWord = "1"; // 連接資料函數庫密碼
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // 獲得資料函數庫連接
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 傳回Connection對像
    }
    
    public boolean executeUpdate(String sql) {
        conn = getConn(); // 獲得資料函數庫連接
        try {
            Statement stmt = conn.createStatement(); // 實例化Statement對像
            int iCount = stmt.executeUpdate(sql); // 執行修改敘述
            System.out.println("操作成功，所影響的記錄數為" + String.valueOf(iCount)); // 舉出提示資訊
            conn.close(); // 關閉連接
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
