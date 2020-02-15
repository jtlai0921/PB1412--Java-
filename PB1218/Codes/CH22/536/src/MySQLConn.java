import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConn {
    Connection conn = null;
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // ���JMySQL��ƨ�Ʈw�X��
            String url = "jdbc:mysql://localhost:3306/information_schema"; // �w�q�P�s����ƨ�Ʈw��url
            String user = "root"; // �w�q�s����ƨ�Ʈw���ϥΪ̦W��
            String passWord = "111"; // �w�q�s����ƨ�Ʈw���K�X
            conn = DriverManager.getConnection(url, user, passWord); // �s���s��
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    // ��oMySQL�Ҧ���ƨ�Ʈw��k
    public List getDatabase() {
        List list = new ArrayList(); // �w�qList���X�ﹳ
        Connection con = getConnection(); // ��o��ƨ�Ʈw�s��
        Statement st; // �w�qStatement�ﹳ
        try {
            st = con.createStatement(); // ��Ҥ�Statement�ﹳ
            ResultSet rs = st.executeQuery("select schema_name from SCHEMATA"); // ���w�d�ߩҦ���ƨ�Ʈw��k
            while (rs.next()) { // �`���ˬd�d�ߵ��G��
                list.add(rs.getString(1)); // �N�d�߸�ƼW�[��List���X��
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^�d�ߵ��G
    }
    
    // �ƥ���ƨ�Ʈw��k

public boolean mysqldump(String database, String path) { // �ƥ���ƨ�Ʈw
    try {
        Process p = Runtime.getRuntime().exec(
                "cmd.exe /c mysqldump -uroot -p111 " + database + " >"
                        + path + "");           //�w�q�i���Ƴƥ����ԭz
        StringBuffer out1 = new StringBuffer(); //�w�q�r��w�Ĺﹳ
        byte[] b = new byte[1024];              //�w�q�r�`�}�C
        for (int i; ((i = p.getInputStream().read(b)) != -1);) { // �N��Ƽg�J����w�ɮפ�
            out1.append(new String(b, 0, i));   //�V�y���l�[���
        }
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
    return true;
}
    
    
}
