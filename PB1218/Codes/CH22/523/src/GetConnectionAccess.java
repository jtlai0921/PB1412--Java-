import java.sql.*;
public class GetConnectionAccess {

public boolean Connection(){
    try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //���J��ƨ�Ʈw�X��
        Connection con = DriverManager.getConnection("jdbc:odbc:access");   //��o��ƨ�Ʈw�s��
        if(con != null){
            System.out.println("�z�LJDBC-ODBC���s��Access��ƨ�Ʈw");
        }
        return true;
    } catch (Exception e) {       
        e.printStackTrace();
        return false;
    }
}

    public static void main(String[] args) {
        GetConnectionAccess access = new GetConnectionAccess();
        access.Connection();
    }
}
