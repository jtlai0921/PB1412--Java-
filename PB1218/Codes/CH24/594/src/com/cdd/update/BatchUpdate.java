package com.cdd.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BatchUpdate {
    private Connection conn;
    
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
    
    // �d�ߩҦ��ǲ����Z��T
    public List executeStu() {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        Statement cs = null; // �w�qCallableStatement�ﹳ
        String sql = "select distinct dept from tb_laborage"; // �w�q�I�s�w�x�{�Ǫ�SQL�ԭz
        List list = new ArrayList();
        try {
            cs = conn.createStatement(); // ��Ҥ�Statement�ﹳ
            ResultSet rest = cs.executeQuery(sql); // ����SQL�ԭz
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                String dept = rest.getString(1);
                list.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void updateBatch(Object[] dept, int laborage) {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        Statement cs = null; // �w�qStatement�ﹳ
        try {
            cs = conn.createStatement(); // ��Ҥ�Statement�ﹳ
            for (int i = 0; i < dept.length; i++) {
                cs.addBatch("update tb_laborage set laborage = laborage +"
                        + laborage + " where dept = '" + dept[i] + "'"); // �ק���
            }
            cs.executeBatch(); // �妸����SQL�ԭz
            cs.close(); // �NStatement�ﹳ����
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
