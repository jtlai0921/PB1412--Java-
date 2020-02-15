import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreateCompare {
    private Connection conn; // �w�qConnection�ﹳ
    
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
    
    /**
     * @param args
     */
    
    public List getCompare(String name1, String name2) {
        List list = new ArrayList<Grade>(); // �w�qList���X�ﹳ
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select name,chinese from tb_grade where chinese > (select chinese from tb_grade where name = '"
                    + name1
                    + "') "
                    + "and chinese < (select chinese from tb_grade where name = '"
                    + name2 + "')"; // �w�q�d�߱ԭz
            ResultSet rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                Grade grade = new Grade(); // �w�q�P��ƪ������JavaBean�ﹳ
                grade.setName(rest.getString(1));
                grade.setChinese(rest.getFloat(2));
                list.add(grade); // �V���X���W�[����
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^�d�ߵ��G
    }
    
}
