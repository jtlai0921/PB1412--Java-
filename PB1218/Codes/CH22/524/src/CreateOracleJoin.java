import java.sql.Connection;
import java.sql.DriverManager;


public class CreateOracleJoin {

public boolean Connection(){
    try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //載入資料函數庫驅動
        System.out.println("資料函數庫驅動載入成功！！");
        Connection con = DriverManager.getConnection("jdbc:odbc:data","system","aaa");   //獲得資料函數庫連接
        if(con != null){        //判斷Connection對象是否為空
            System.out.println("成功的與oracle資料函數庫建立連接！！");  //舉出提示資訊
        }
        return true;
    } catch (Exception e) {       
        e.printStackTrace();
        return false;
    }
}
    public static void main(String[] args) {
        CreateOracleJoin createJoin = new CreateOracleJoin();
        createJoin.Connection();
    }
    
}
