import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectUseRight {
    private Connection conn;    
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database23"; // �s����ƨ�ƮwURL
        String userName = "sa"; // �s����ƨ�Ʈw���ϥΪ̦W��
        String passWord = "1"; // �s����ƨ�Ʈw�K�X
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // ��o��ƨ�Ʈw�s��
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // �Ǧ^Connection�ﹳ
    }    
    public List getRight() {
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        ResultSet rest;
        List list = new ArrayList<MrEmp>();
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select e.id,dName,person,name,sex,schoolAge  from tb_mrdept d right join tb_mremp e on d.id = e.dId"; // �w�q�d�߱ԭz
            rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) {
                MrEmp mrEmp = new MrEmp(); // �w�q�P��ƪ������JavaBean�ﹳ
                mrEmp.setId(rest.getInt(1)); // �]�w�ﹳ�ݩ�
                mrEmp.setdName(rest.getString(2));
                mrEmp.setPerson(rest.getString(3));
                mrEmp.setName(rest.getString(4));
                mrEmp.setSex(rest.getString(5));
                mrEmp.setSchoolAge(rest.getString(6));
                list.add(mrEmp);
            }
            return list; // �Ǧ^�d�ߵ��G
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
