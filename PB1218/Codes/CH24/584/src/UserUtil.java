
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserUtil {
    
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

public List executeUpdate() {
    conn = getConn(); // 獲得資料函數庫連接
    CallableStatement cs = null; // 定義CallableStatement對像
    String sql = "{call selectUser}"; // 定義呼叫預儲程序的SQL敘述
    List list = new ArrayList();
    try {
        cs = conn.prepareCall(sql); // 實例化CallableStatement對像
        ResultSet rest = cs.executeQuery(); // 執行SQL敘述
        while(rest.next()){             //循環檢查查詢結果集
            User user = new User();     //定義與資料表對應的JavaBean對像
            user.setId(rest.getInt(1));     //設定對像屬性
            user.setUserName(rest.getString(2));
            user.setPassword(rest.getString(3));
            user.setAge(rest.getInt(4));
            user.setSex(rest.getString(5));
            user.setJob(rest.getString(6));
            list.add(user);             //向集合中增加對像
        }            
    } catch (SQLException e) {
        e.printStackTrace();
       
    }
    return list;
}      
}
