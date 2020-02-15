import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class FindEmp {
    private Connection conn ;   //�w�qConnection�ﹳ
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


public List getSubTable() {
    List list = new ArrayList<Emp>(); // �w�qList���X�ﹳ
    conn = getConn(); // ��o�P��ƨ�Ʈw���s��
    try {
        Statement statement = conn.createStatement(); // ��oStatement�ﹳ
        String sql = "select eName,headship,dept,laborage from tb_emp  where laborage >(select avg(laborage) from tb_emp)"; // �w�q�d�߱ԭz
        ResultSet rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
        while (rest.next()) { // �`���ˬd�d�ߵ��G��
            Emp emp = new Emp(); // �w�q���ƪ������JavaBean�ﹳ               
            emp.setName(rest.getString(1));
            emp.setHeadship(rest.getString(2));
            emp.setDept(rest.getString(3));
            emp.setLaborage(rest.getFloat(4));
            list.add(emp); // �N�ﹳ�W�[�춰�X��
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^�d�ߵ��G
}

    /**
     * @param args
     */
    public static void main(String[] args) {
       FindEmp findEmp = new FindEmp();
       List list = findEmp.getSubTable();
       System.out.println("�d���~��������u�������q�����u��T�G");
       for(int i = 0;i<list.size();i++){
          Emp emp = (Emp)list.get(i);
          System.out.println("�m�W�G"+emp.getName()+" ¾��G"+emp.getHeadship()+" �����G"+emp.getDept()+" �~���G"+emp.getLaborage());
       }
        
    }
    
}
