package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetTables {
    Connection conn = null;
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // ���JMySQL��ƨ�Ʈw�X��
            String url = "jdbc:mysql://localhost:3306/db_database21"; // �w�q�P�s����ƨ�Ʈw��url
            String user = "root"; // �w�q�s����ƨ�Ʈw���ϥΪ̦W��
            String passWord = "111"; // �w�q�s����ƨ�Ʈw���K�X
            conn = DriverManager.getConnection(url, user, passWord); // �s���s��
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    // ��ܸ�ƨ�Ʈw
public ResultSet listDB() {
    String sql = "show tables;"; // �w�q�d�߸��SQL�ԭz
    try {
        conn = getConnection(); // ��o��ƨ�Ʈw�s��
        Statement stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY); // ��Ҥ�Statement�ﹳ
        ResultSet rs = stmt.executeQuery(sql); // ����d��SQL�ԭz
        return rs;              //�Ǧ^�d�ߵ��G
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return null;
    }
}
    
    public static void main(String[] args) {
        GetTables tables = new GetTables();
        ResultSet rest = tables.listDB();
        System.out.println("��ƨ�Ʈwdb_database21�U����ƪ��G");
        try {
            while (rest.next()) {
                System.out.println(rest.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
