import java.sql.*;

public class JDBCUtil {
    
    Connection conn = null;
    
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database21"; // 連接資料函數庫URL
        String userName = "sa"; // 連接資料函數庫的使用者名稱
        String passWord = ""; // 連接資料函數庫密碼
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // 獲得資料函數庫連接
            if (conn != null) {
                System.out.println("資料函數庫連接成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 傳回Connection對像
    }
    
public void insertEmp(String[] str) {
    JDBCUtil iteacher = new JDBCUtil(); // 建立本類別對像
    Connection conn = iteacher.getConn(); // 呼叫獲得資料函數庫連接方法
    String sql = "insert into tb_empTable  values('" + str[0] + "','"
            + str[1] + "','" + str[2] + "','" + str[3] + "')"; // 定義向資料函數庫插入資料的SQL敘述
    try {
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql); // 執行插入的sql敘述
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
}
