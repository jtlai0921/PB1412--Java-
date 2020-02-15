
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
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
    
    public void insertEmp(Emp emp) {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into tb_emp values(?,?,?,?,?,?)"); // �w�q���J��ƨ�Ʈw���w���B�z�ԭz
            statement.setString(1, emp.getName()); // �]�w�w���B�z�ԭz���Ѽƭ�
            statement.setString(2, emp.getSex());
            statement.setInt(3, emp.getAge());
            statement.setString(4, emp.getDept());
            statement.setString(5, emp.getPhone());
            statement.setString(6, emp.getRemark());
            statement.executeUpdate(); // ����w���B�z�ԭz
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int selectEmpUseName(String name) {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        Statement statment;
        int id = 0; // �w�q�x�s�Ǧ^�Ȫ�int�ﹳ
        try {
            statment = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select id from tb_emp where name = '" + name + "'"; // �w�q�d��SQL�ԭz
            ResultSet rest = statment.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                id = rest.getInt(1); // ��o�d�ߵ��G
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id; // �Ǧ^�d�ߵ��G
    }
    
}
