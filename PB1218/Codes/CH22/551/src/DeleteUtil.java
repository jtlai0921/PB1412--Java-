import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeleteUtil {
    static Connection conn = null;
    
    // ��o��ƨ�Ʈw�s��
    public static Connection getConn() {
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
    

    // �w�q�d�ߩҦ��P�Ǹ�T��k
    public List selectStu() {
        conn = getConn();
        Statement statement;
        List list = new ArrayList<Stu>();
        try {
            statement = conn.createStatement();
            ResultSet rest = statement.executeQuery("select * from tb_stu");
            while (rest.next()) {
                Stu stu = new Stu();
                stu.setId(rest.getInt(1));
                stu.setName(rest.getString(2));
                stu.setGrade(rest.getString("grade"));
                stu.setSex(rest.getString(3));
                stu.setSpecialty(rest.getString(4));
                list.add(stu);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    // �w�q�R�����w�O������k
    public void deleteStu(int id) {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        try {
            Statement statement = conn.createStatement();// �w�q��sSQL�ԭz
            statement.executeUpdate("delete from tb_stu where id= " + id); // ����w���B�z�ԭz
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
