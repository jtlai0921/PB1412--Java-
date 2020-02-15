import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DeleteEmp {
    private Connection conn;
    
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
    //查詢部門表中的所有資料
    public List getDept() {
        List list = new ArrayList<Dept>(); // 定義List集合對像
        conn = getConn(); // 獲得與資料函數庫的連接
        try {
            Statement statement = conn.createStatement(); // 獲得Statement對像
            String sql = "select * from tb_mrdept "; // 定義查詢敘述
            ResultSet rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
            while (rest.next()) { // 循環檢查查詢結果集
                Dept dept = new Dept();
                dept.setId(rest.getInt(1));
                dept.setDeptName(rest.getString(2));
                list.add(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 傳回查詢結果
    }

public void deleteEmp() {        
    conn = getConn(); // 獲得與資料函數庫的連接
    try {
        Statement statement = conn.createStatement(); // 獲得Statement對像
        String sql = "delete from tb_mrdept where person not in (select name from tb_mremp )"; //在刪除敘述中使用子查詢
        statement.executeUpdate(sql);            //執行刪除SQL敘述
    } catch (Exception e) {
        e.printStackTrace();
    }        
}
    public static void main(String[] args) {
        DeleteEmp deleteEmp = new DeleteEmp();
        List list = deleteEmp.getDept();
        System.out.println("刪除前的資料：");
        for(int i  = 0;i<list.size();i++){
            Dept dept = (Dept)list.get(i);
            System.out.println("編號為："+dept.getId()+"  部門名稱為："+dept.getDeptName());
        }
        System.out.println("\n 刪除員工表中不存在的部門資訊後，部門資訊表中的資料為：");
        deleteEmp.deleteEmp();
        List list2 = deleteEmp.getDept();
        for(int i  = 0;i<list2.size();i++){
            Dept dept = (Dept)list2.get(i);
            System.out.println("編號為："+dept.getId()+"  部門名稱為："+dept.getDeptName());
        }
    }
    
}
