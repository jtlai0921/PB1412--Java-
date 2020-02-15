import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DeleteEmp {
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
    //�d�߳��������Ҧ����
    public List getDept() {
        List list = new ArrayList<Dept>(); // �w�qList���X�ﹳ
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select * from tb_mrdept "; // �w�q�d�߱ԭz
            ResultSet rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                Dept dept = new Dept();
                dept.setId(rest.getInt(1));
                dept.setDeptName(rest.getString(2));
                list.add(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^�d�ߵ��G
    }

public void deleteEmp() {        
    conn = getConn(); // ��o�P��ƨ�Ʈw���s��
    try {
        Statement statement = conn.createStatement(); // ��oStatement�ﹳ
        String sql = "delete from tb_mrdept where person not in (select name from tb_mremp )"; //�b�R���ԭz���ϥΤl�d��
        statement.executeUpdate(sql);            //����R��SQL�ԭz
    } catch (Exception e) {
        e.printStackTrace();
    }        
}
    public static void main(String[] args) {
        DeleteEmp deleteEmp = new DeleteEmp();
        List list = deleteEmp.getDept();
        System.out.println("�R���e����ơG");
        for(int i  = 0;i<list.size();i++){
            Dept dept = (Dept)list.get(i);
            System.out.println("�s�����G"+dept.getId()+"  �����W�٬��G"+dept.getDeptName());
        }
        System.out.println("\n �R�����u�����s�b��������T��A������T������Ƭ��G");
        deleteEmp.deleteEmp();
        List list2 = deleteEmp.getDept();
        for(int i  = 0;i<list2.size();i++){
            Dept dept = (Dept)list2.get(i);
            System.out.println("�s�����G"+dept.getId()+"  �����W�٬��G"+dept.getDeptName());
        }
    }
    
}
