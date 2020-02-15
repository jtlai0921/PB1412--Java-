import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class FindEmp {
    private Connection conn ;   //定義Connection對像
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


public List getSubTable() {
    List list = new ArrayList<Emp>(); // 定義List集合對像
    conn = getConn(); // 獲得與資料函數庫的連接
    try {
        Statement statement = conn.createStatement(); // 獲得Statement對像
        String sql = "select eName,headship,dept,laborage from tb_emp  where laborage >(select avg(laborage) from tb_emp)"; // 定義查詢敘述
        ResultSet rest = statement.executeQuery(sql); // 執行查詢敘述獲得查詢結果集
        while (rest.next()) { // 循環檢查查詢結果集
            Emp emp = new Emp(); // 定義於資料表對應的JavaBean對像               
            emp.setName(rest.getString(1));
            emp.setHeadship(rest.getString(2));
            emp.setDept(rest.getString(3));
            emp.setLaborage(rest.getFloat(4));
            list.add(emp); // 將對像增加到集合中
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // 傳回查詢結果
}

    /**
     * @param args
     */
    public static void main(String[] args) {
       FindEmp findEmp = new FindEmp();
       List list = findEmp.getSubTable();
       System.out.println("查詢薪水高於員工平均公司的員工資訊：");
       for(int i = 0;i<list.size();i++){
          Emp emp = (Emp)list.get(i);
          System.out.println("姓名："+emp.getName()+" 職位："+emp.getHeadship()+" 部門："+emp.getDept()+" 薪水："+emp.getLaborage());
       }
        
    }
    
}
