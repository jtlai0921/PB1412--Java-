import java.sql.Connection;
import java.sql.DriverManager;


public class GetConnection {
    
private Connection conn;        //�w�qConnection�ﹳ
public String con(){       
    try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //���JODBC��ƨ�Ʈw�X��
        conn = DriverManager.getConnection("jdbc:odbc:db_database22","sa","1");  //��o��ƨ�Ʈw�s��
        return "��ƨ�Ʈw�s�����\�I";  //�Ǧ^�s���ﹳ
    } catch (Exception e) {          
        e.printStackTrace();
        return "��ƨ�Ʈw�s�����ѡI";
    }
}
    public static void main(String[] args) {
       GetConnection getConn = new GetConnection();
       System.out.println(getConn.con());
        
    }    
}
