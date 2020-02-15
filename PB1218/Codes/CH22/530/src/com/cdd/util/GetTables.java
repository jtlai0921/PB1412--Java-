package com.cdd.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTables {
    static Connection conn = null;
    
    // ��o��ƨ�Ʈw�s��
    public static Connection getConn() {
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
    
    public static ResultSet GetRs() {
        try {
            String[] tableType = { "TABLE" }; // ���w�n�i��d�ߪ����A
            Connection conn = getConn(); // �I�s�P��ƨ�Ʈw�إ߳s����k
            DatabaseMetaData databaseMetaData = conn.getMetaData(); // ��oDatabaseMetaData���
            ResultSet resultSet = databaseMetaData.getTables(null, null, "%",
                    tableType);// ��o��ƨ�Ʈw���Ҧ���ƪ��X
            return resultSet;
        } catch (SQLException e) {
            System.out.println("�O���ƶq��o���ѡI");
            return null;
        }
    }
    
    public static void main(String[] args) {
        ResultSet rst = GetRs();
        System.out.println("��ƨ�Ʈw�������G");
        try {
            while (rst.next()) { // �ˬd���X
                String tableName = rst.getString("TABLE_NAME");
                System.out.println(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
