import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AlterProce {
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
    
    public boolean executeUpdate(String sql) {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        try {
            Statement stmt = conn.createStatement(); // ��Ҥ�Statement�ﹳ
            int iCount = stmt.executeUpdate(sql); // ����ק�ԭz
            System.out.println("�ާ@���\�A�Ҽv�T���O���Ƭ�" + String.valueOf(iCount)); // �|�X���ܸ�T
            conn.close(); // �����s��
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
