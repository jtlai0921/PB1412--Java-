import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreateCompare {
    private Connection conn; // 定義Connection對像
    
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
    
    /**
     * @param args
     */
    
    public List getCompare(String name1, String name2) {
        List list = new ArrayList<Grade>(); // 定義List集合對像
        conn = getConn(); // 獲得與資料函數庫的連接
        try {
            Statement statement = conn.createStatement(); // 獲得Statement對像
            String sql = "select name,chinese from tb_grade where chinese > (select chinese from tb_grade where name = '"
                    + name1
                    + "') "
                    + "and chinese < (select chinese from tb_grade where name = '"
                    + name2 + "')"; // 定義查詢敘述
            ResultSet rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
            while (rest.next()) { // 循環檢查查詢結果集
                Grade grade = new Grade(); // 定義與資料表對應的JavaBean對像
                grade.setName(rest.getString(1));
                grade.setChinese(rest.getFloat(2));
                list.add(grade); // 向集合中增加元素
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 傳回查詢結果
    }
    
}
