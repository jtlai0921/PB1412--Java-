import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class InsertInfo {
 static Connection conn = null;
    
    // ��o��ƨ�Ʈw�s��
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database22"; // �s����ƨ�ƮwURL
        String userName = "sa"; // �s����ƨ�Ʈw���ϥΪ̦W��
        String passWord = "1"; // �s����ƨ�Ʈw�K�X
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // ��o��ƨ�Ʈw�s��
            if (conn != null) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // �Ǧ^Connection�ﹳ
    }
    //�N�ϥΪ̵n�J��T���J���ƨ�Ʈw��k

public void insertUser(User user) {
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        PreparedStatement statement = conn
                .prepareStatement("insert into tb_user values(?,?,?)"); // �w�q���J��ƨ�Ʈw���w���B�z�ԭz          
        statement.setString(1, user.getUserName());     //�]�w�w���B�z�ԭz�Ѽ�
        statement.setString(2, user.getPassWord());
        SimpleDateFormat date_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //�ھګ��w�榡�w�qSimpleDateFormat�ﹳ
        String datetime = date_time.format(new Date());     //��ثe����i��榡��
        statement.setString(3, datetime);
        statement.executeUpdate(); // ����w���B�z�ԭz
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  
    
}
