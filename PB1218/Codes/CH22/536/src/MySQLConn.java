import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConn {
    Connection conn = null;
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 載入MySQL資料函數庫驅動
            String url = "jdbc:mysql://localhost:3306/information_schema"; // 定義與連接資料函數庫的url
            String user = "root"; // 定義連接資料函數庫的使用者名稱
            String passWord = "111"; // 定義連接資料函數庫的密碼
            conn = DriverManager.getConnection(url, user, passWord); // 連接連接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    // 獲得MySQL所有資料函數庫方法
    public List getDatabase() {
        List list = new ArrayList(); // 定義List集合對像
        Connection con = getConnection(); // 獲得資料函數庫連接
        Statement st; // 定義Statement對像
        try {
            st = con.createStatement(); // 實例化Statement對像
            ResultSet rs = st.executeQuery("select schema_name from SCHEMATA"); // 指定查詢所有資料函數庫方法
            while (rs.next()) { // 循環檢查查詢結果集
                list.add(rs.getString(1)); // 將查詢資料增加到List集合中
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 傳回查詢結果
    }
    
    // 備份資料函數庫方法

public boolean mysqldump(String database, String path) { // 備份資料函數庫
    try {
        Process p = Runtime.getRuntime().exec(
                "cmd.exe /c mysqldump -uroot -p111 " + database + " >"
                        + path + "");           //定義進行資料備份的敘述
        StringBuffer out1 = new StringBuffer(); //定義字串緩衝對像
        byte[] b = new byte[1024];              //定義字節陣列
        for (int i; ((i = p.getInputStream().read(b)) != -1);) { // 將資料寫入到指定檔案中
            out1.append(new String(b, 0, i));   //向流中追加資料
        }
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
    return true;
}
    
    
}
