package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class GoDanger {
    private Connection conn;
    // ��o��ƨ�Ʈw�s��
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database22"; // �s����ƨ�ƮwURL
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
    public void insertBookSell(BookSell bookSell) {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into tb_bookSell values(?,?,?,?)"); // �w�q���J��ƨ�Ʈw���w���B�z�ԭz
         
            statement.setString(1,bookSell.getBookName() );
            statement.setString(2, bookSell.getStock());
            statement.setFloat(3, bookSell.getPrice());
            statement.setString(4, bookSell.getBookConcern());
            statement.executeUpdate(); // ����w���B�z�ԭz
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
