import java.sql.*;

public class JDBCUtil {
    
    Connection conn = null;
    
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database21"; // �s����ƨ�ƮwURL
        String userName = "sa"; // �s����ƨ�Ʈw���ϥΪ̦W��
        String passWord = ""; // �s����ƨ�Ʈw�K�X
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // ��o��ƨ�Ʈw�s��
            if (conn != null) {
                System.out.println("��ƨ�Ʈw�s�����\�I");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // �Ǧ^Connection�ﹳ
    }
    
public void insertEmp(String[] str) {
    JDBCUtil iteacher = new JDBCUtil(); // �إߥ����O�ﹳ
    Connection conn = iteacher.getConn(); // �I�s��o��ƨ�Ʈw�s����k
    String sql = "insert into tb_empTable  values('" + str[0] + "','"
            + str[1] + "','" + str[2] + "','" + str[3] + "')"; // �w�q�V��ƨ�Ʈw���J��ƪ�SQL�ԭz
    try {
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql); // ���洡�J��sql�ԭz
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
}
