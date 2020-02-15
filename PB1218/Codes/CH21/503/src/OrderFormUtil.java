import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderFormUtil {
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
    
    // �w�q�����w�����w���󭰧Ǭd�߸�Ƥ�k
    
public List getOrderDesc() {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select visePerson,sum(clientMoney) as money from tb_orderForm  group by visePerson order by money desc"; // �w�q�N�q���i����ղέp��SQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            OrderForm orderForm = new OrderForm();             
            orderForm.setClientMoney(set.getFloat("money"));
            orderForm.setVisePerson(set.getString("visePerson"));
            list.add(orderForm);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
    public static void main(String[] args) {
        OrderFormUtil util = new OrderFormUtil();
        List list = util.getOrderDesc();
        System.out.println("���uñ���Ʀ�]�G");
        for(int i = 0;i<list.size();i++){
            OrderForm orderForm = (OrderForm)list.get(i);
            System.out.println("ñ���H�G "+orderForm.getVisePerson()+"�A  �q����B�G "+orderForm.getClientMoney());
        }
    }
}
