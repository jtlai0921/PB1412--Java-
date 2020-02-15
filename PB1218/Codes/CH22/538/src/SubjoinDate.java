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

	public SubjoinDate() { // 透過建構方法載入資料函數庫驅動
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("資料函數庫載入失敗");
		}
	}

    public boolean Connection() {        //建立資料函數庫連接
        try {
            con = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("creatConnectionError!");
        }
        return true;
    }

    //對資料函數庫的查詢操作
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
    //更新資料函數庫
    
    public boolean executeUpdate(String dataName, String mPath, String lPath) {
        if (con == null) {
            Connection(); // 資料函數庫連接
        }
        try {
            stmt = con.createStatement();
            int iCount = stmt.executeUpdate("EXEC sp_attach_db @dbname = '"
                    + dataName + "', @filename1='" + mPath
                    + "', @filename2 = '" + lPath + "'");// 執行資料函數庫附加
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        closeConnection(); // 呼叫關閉資料函數庫連接方法
        return true;
    }

    //關閉資料函數庫的操作
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