package com.cdd.jdbc;

import java.sql.*;

public class CreateJoin {
    Connection conn = null;
static {
    try {
        Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        System.out.println("��ƨ�Ʈw�X�ʸ��J���\�I");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
    
public Connection getConn() {
    String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database22"; // �s����ƨ�ƮwURL
    String userName = "sa"; // �s����ƨ�Ʈw���ϥΪ̦W��
    String passWord = "1"; // �s����ƨ�Ʈw�K�X
    try {
        conn = DriverManager.getConnection(url, userName, passWord); // ��o��ƨ�Ʈw�s��
        if (conn != null) {
            System.out.println("�w���\���PSQLServer2000��ƨ�Ʈw�إ߳s���I");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return conn; // �Ǧ^Connection�ﹳ
}
    
    public static void main(String[] args) {
        CreateJoin join = new CreateJoin();
        Connection conn = join.getConn();
    }
    
}
