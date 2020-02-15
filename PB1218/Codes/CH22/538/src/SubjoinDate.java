import java.sql.*;
/**
 * @author Administrator
 */
public class SubjoinDate {

	String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=master";
	String username = "sa";
	String password = "1";
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public SubjoinDate() { // �z�L�غc��k���J��ƨ�Ʈw�X��
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("��ƨ�Ʈw���J����");
		}
	}

    public boolean Connection() {        //�إ߸�ƨ�Ʈw�s��
        try {
            con = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("creatConnectionError!");
        }
        return true;
    }

    //���ƨ�Ʈw���d�߾ާ@
    public ResultSet selectStatic(String sql) throws SQLException {
         ResultSet rs=null;
        if (con == null) {
            Connection();
        }
               try {
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery(sql);
         } catch (SQLException e) {
                     e.printStackTrace();
                    }
         closeConnection();
        return rs;
    }
    //��s��ƨ�Ʈw
    
    public boolean executeUpdate(String dataName, String mPath, String lPath) {
        if (con == null) {
            Connection(); // ��ƨ�Ʈw�s��
        }
        try {
            stmt = con.createStatement();
            int iCount = stmt.executeUpdate("EXEC sp_attach_db @dbname = '"
                    + dataName + "', @filename1='" + mPath
                    + "', @filename2 = '" + lPath + "'");// �����ƨ�Ʈw���[
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        closeConnection(); // �I�s������ƨ�Ʈw�s����k
        return true;
    }

    //������ƨ�Ʈw���ާ@
    public void closeConnection() {
       if (con != null && stmt != null && rs != null) {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to close connection!");
            } finally {
                con = null;
            }
        }
    }  
}
