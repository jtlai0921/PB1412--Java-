

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class GradeUtil {
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
    
    // �w�q�����w�����w���󭰧Ǭd�߸�Ƥ�k

public ResultSet getResult() {
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    float sum = 0;
    ResultSet set = null;
    try {
        Statement staement = conn.createStatement();
        String sql = "select avg(chinese)as chinese,avg(math) as math,avg(english) as english" +
        		",avg(physics) as physics,avg(history)as history from tb_Grade"; // �w�q�M��U�즨�Z�������Ȫ�SQL�ԭz
       set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��        
    } catch (Exception e) {
        e.printStackTrace();
    }
    return set;
}
    
    public static void main(String[] args) {
        GradeUtil util = new GradeUtil();
        ResultSet set = util.getResult();
        System.out.println("�U�즨�Z���������Z���G");
        try {
            while(set.next()){
                float chinese = set.getFloat("chinese");
                float math = set.getFloat("math");
                float english = set.getFloat("english");
                float physics = set.getFloat("physics");
                float history = set.getFloat("history");
                System.out.println("�y��G"+chinese+" ,�ƾǡG"+math+" ,�^�y�G"+english+" ,����G"+physics+" �A���v�G"+history);
            }
        } catch (SQLException e) {          
            e.printStackTrace();
        }
    }
}
