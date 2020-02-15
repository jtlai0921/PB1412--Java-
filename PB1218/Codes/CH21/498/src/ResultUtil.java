import java.sql.*;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

public class ResultUtil {
    // ��o��ƨ�Ʈw�s��
    private Connection conn;
    
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
    public List getGradeDesc() {
        List list = new ArrayList();    // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
        conn = getConn();               // ��o��ƨ�Ʈw�s��
        try {
            Statement staement = conn.createStatement();
               // �w�q�N�ϮѪ����T�i��ƧǪ�SQL�ԭz
            String sql = "select * from tb_abroad order by substring(name,1,1)"; 
            ResultSet set = staement.executeQuery(sql);     // ����d�߱ԭz�Ǧ^�d�ߵ��G��
            while (set.next()) {                        // �`���ˬd�d�ߵ��G��
                Abroad abrod = new Abroad();                // �إߩ�ǲ����Z�������Grade�ﹳ
                abrod.setId(set.getInt(1));                 // �]�w�ﹳ�ݩ�
                abrod.setName(set.getString(2));
                abrod.setSurname(set.getString(3));
                abrod.setNationality(set.getString(4));
                list.add(abrod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;                                    // �Ǧ^�d�߶��X
    }    
    public static void main(String[] args) {
        ResultUtil util = new ResultUtil();
        List list = util.getGradeDesc();
        System.out.println("�N�d�ǥͪ�����ǱƧǡG");
        for(int i = 0;i<list.size();i++){
            Abroad abrod = (Abroad)list.get(i);         // �إߩ�ǲ����Z�������Grade�ﹳ
            System.out.println("�s�����G"+abrod.getId()+"  �W�r���G"+abrod.getName()+"  �m���G"+abrod.getSurname()+
                    "  ���y���G"+abrod.getNationality());
        }
        
    }
}
