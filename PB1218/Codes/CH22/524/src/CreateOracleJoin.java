import java.sql.Connection;
import java.sql.DriverManager;


public class CreateOracleJoin {

public boolean Connection(){
    try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //���J��ƨ�Ʈw�X��
        System.out.println("��ƨ�Ʈw�X�ʸ��J���\�I�I");
        Connection con = DriverManager.getConnection("jdbc:odbc:data","system","aaa");   //��o��ƨ�Ʈw�s��
        if(con != null){        //�P�_Connection��H�O�_����
            System.out.println("���\���Poracle��ƨ�Ʈw�إ߳s���I�I");  //�|�X���ܸ�T
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