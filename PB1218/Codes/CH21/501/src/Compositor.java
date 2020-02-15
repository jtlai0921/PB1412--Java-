import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Compositor {
    Connection conn = null;
    
    // ��o��ƨ�Ʈw�s��
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database21"; // �s����ƨ�ƮwURL
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

public List getBccdSell() {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select bccdName,bccdCount from tb_bccdSell order by 2 desc"; // �w�q�d�߸�ƪ�SQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            Bccd bccd = new Bccd(); // �w�q�P��ƹ�����JavaBean�ﹳ
            bccd.setBccdName(set.getString(1));
            bccd.setBccdCount(set.getInt(2));
            list.add(bccd); // �V���X���W�[�ﹳ
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^List���X
}
   
}
