import java.sql.*;
import java.util.*;


public class BatchInsert {
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
    public List executeTeacher() {
        conn = getConn();                                // 獲得資料函數庫連接
        Statement cs = null;                                 // 定義CallableStatement對像
        String sql = "select * from tb_teacher";         // 定義呼叫預儲程序的SQL敘述
        List list = new ArrayList();
        try {
            cs = conn.createStatement();                     // 實例化Statement對像
            ResultSet rest = cs.executeQuery(sql);       // 執行SQL敘述
            while (rest.next()) {                        // 循環檢查查詢結果集
                Teacher teacher = new Teacher();         //定義與資料函數庫表對應的JavaBean對像
                teacher.setId(rest.getInt(1));           //設定對象的參數值
                teacher.settName(rest.getString(2));
                teacher.setCourse(rest.getString(3));
                list.add(teacher);                       //向集合中增加對像
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void insertBatch() {
        conn = getConn();                                // 獲得資料函數庫連接
        Statement cs = null;                                 // 定義Statement對像
        try {
            cs = conn.createStatement();                     // 實例化Statement對像
            List list = executeTeacher();
            for (int i = 0; i < list.size(); i++) {
                Teacher teacher = (Teacher) list.get(i);
                cs.addBatch("insert into tb_elective values ('"
                        + teacher.getCourse() + "','" + teacher.gettName()
                        + "','待定')");                //增加SQL敘述
            }
            System.out.println("資料增加成功！");
            cs.executeBatch();                       // 批次執行SQL敘述
            cs.close();                              // 將Statement對像關閉
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BatchInsert bi = new BatchInsert();
        bi.insertBatch();
    }

}
