package com.cdd.createView;

import java.io.ObjectInputStream.GetField;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateView {
    private static Connection conn;
    
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
    
    // ��s��ƨ�Ʈw
    
    public boolean executeUpdate(String sql) {
        if (conn == null) {
            getConn(); // ��o��ƨ�Ʈw�s��
        }
        try {
            Statement stmt = conn.createStatement(); // �إ�Statement���
            int iCount = stmt.executeUpdate(sql); // ����SQL�ԭz
            System.out.println("�ާ@���\�A�Ҽv�T���O���Ƭ�" + String.valueOf(iCount));
            conn.close(); // �����s��
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
}
