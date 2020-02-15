import java.sql.*;
import java.util.*;


public class BatchInsert {
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
    public List executeTeacher() {
        conn = getConn();                                // ��o��ƨ�Ʈw�s��
        Statement cs = null;                                 // �w�qCallableStatement�ﹳ
        String sql = "select * from tb_teacher";         // �w�q�I�s�w�x�{�Ǫ�SQL�ԭz
        List list = new ArrayList();
        try {
            cs = conn.createStatement();                     // ��Ҥ�Statement�ﹳ
            ResultSet rest = cs.executeQuery(sql);       // ����SQL�ԭz
            while (rest.next()) {                        // �`���ˬd�d�ߵ��G��
                Teacher teacher = new Teacher();         //�w�q�P��ƨ�Ʈw�������JavaBean�ﹳ
                teacher.setId(rest.getInt(1));           //�]�w��H���Ѽƭ�
                teacher.settName(rest.getString(2));
                teacher.setCourse(rest.getString(3));
                list.add(teacher);                       //�V���X���W�[�ﹳ
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void insertBatch() {
        conn = getConn();                                // ��o��ƨ�Ʈw�s��
        Statement cs = null;                                 // �w�qStatement�ﹳ
        try {
            cs = conn.createStatement();                     // ��Ҥ�Statement�ﹳ
            List list = executeTeacher();
            for (int i = 0; i < list.size(); i++) {
                Teacher teacher = (Teacher) list.get(i);
                cs.addBatch("insert into tb_elective values ('"
                        + teacher.getCourse() + "','" + teacher.gettName()
                        + "','�ݩw')");                //�W�[SQL�ԭz
            }
            System.out.println("��ƼW�[���\�I");
            cs.executeBatch();                       // �妸����SQL�ԭz
            cs.close();                              // �NStatement�ﹳ����
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BatchInsert bi = new BatchInsert();
        bi.insertBatch();
    }

}
