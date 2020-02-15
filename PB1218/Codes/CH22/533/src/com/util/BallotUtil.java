package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BallotUtil {
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
    
    // �w�q�W�[�ﲼ���r�q��k
    
    public void addField(String fieldName, String type) {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        try {
            Statement statement = conn.createStatement(); // ��oStatement��k
            String sql = "alter table tb_ballot add " + fieldName + " " + type; // �V��ƪ��W�[�r�q
            statement.executeUpdate(sql); // �����s��ƪ�SQL�ԭz
            conn.close(); // ������ƨ�Ʈw�s��
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // �w�q�R���ﲼ���r�q��k
    
    public void deleteField(String fieldName) {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        try {
            Statement statement = conn.createStatement();
            String sql = "alter table tb_ballot drop column " + fieldName; // �w�q�q��ƨ�Ʈw���R���r�qSLQ�ԭz
            statement.executeUpdate(sql); // ����R���ާ@
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // �w�q��o��ƪ��Ҧ��r�q��k
    public List getField() {
        List list = new ArrayList();
        conn = getConn();
        try {
            Statement ps = conn.createStatement();
            ResultSet rest = ps.executeQuery("select * from tb_ballot");
            ResultSetMetaData rsme = rest.getMetaData();
            int columnCount = rsme.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String cName = rsme.getColumnName(i);
                list.add(cName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
}
