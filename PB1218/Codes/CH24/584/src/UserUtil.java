
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserUtil {
    
    private Connection conn;
    
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database24"; // �s����ƨ�ƮwURL
        String userName = "sa"; // �s����ƨ�Ʈw���ϥΪ̦W��
        String passWord = "1"; // �s����ƨ�Ʈw�K�X
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // ��o��ƨ�Ʈw�s��
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // �Ǧ^Connection�ﹳ
    }    

public List executeUpdate() {
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    CallableStatement cs = null; // �w�qCallableStatement�ﹳ
    String sql = "{call selectUser}"; // �w�q�I�s�w�x�{�Ǫ�SQL�ԭz
    List list = new ArrayList();
    try {
        cs = conn.prepareCall(sql); // ��Ҥ�CallableStatement�ﹳ
        ResultSet rest = cs.executeQuery(); // ����SQL�ԭz
        while(rest.next()){             //�`���ˬd�d�ߵ��G��
            User user = new User();     //�w�q�P��ƪ������JavaBean�ﹳ
            user.setId(rest.getInt(1));     //�]�w�ﹳ�ݩ�
            user.setUserName(rest.getString(2));
            user.setPassword(rest.getString(3));
            user.setAge(rest.getInt(4));
            user.setSex(rest.getString(5));
            user.setJob(rest.getString(6));
            list.add(user);             //�V���X���W�[�ﹳ
        }            
    } catch (SQLException e) {
        e.printStackTrace();
       
    }
    return list;
}      
}
