
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
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
    
    public void insertEmp(Emp emp) {
        conn = getConn(); // 獲得資料函數庫連接
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into tb_emp values(?,?,?,?,?,?)"); // 定義插入資料函數庫的預先處理敘述
            statement.setString(1, emp.getName()); // 設定預先處理敘述的參數值
            statement.setString(2, emp.getSex());
            statement.setInt(3, emp.getAge());
            statement.setString(4, emp.getDept());
            statement.setString(5, emp.getPhone());
            statement.setString(6, emp.getRemark());
            statement.executeUpdate(); // 執行預先處理敘述
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int selectEmpUseName(String name) {
        conn = getConn(); // 獲得資料函數庫連接
        Statement statment;
        int id = 0; // 定義儲存傳回值的int對像
        try {
            statment = conn.createStatement(); // 獲得Statement對像
            String sql = "select id from tb_emp where name = '" + name + "'"; // 定義查詢SQL敘述
            ResultSet rest = statment.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
            while (rest.next()) { // 循環檢查查詢結果集
                id = rest.getInt(1); // 獲得查詢結果
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id; // 傳回查詢結果
    }
    
}
