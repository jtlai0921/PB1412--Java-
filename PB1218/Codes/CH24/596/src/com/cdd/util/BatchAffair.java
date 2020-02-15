package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class BatchAffair {
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
    //��o�����ϥΪ̽s����k
    public List selectIds() {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        Statement cs = null; // �w�qCallableStatement�ﹳ
        String sql = "Select accoutNumber from tb_transition"; // �w�q�d���˵���SQL�ԭz
        List list = new ArrayList(); // �w�q�x�s�d�ߵ��G��List���X
        try {
            cs = conn.createStatement(); // ��Ҥ�Statement�ﹳ
            ResultSet rest = cs.executeQuery(sql); // ����SQL�ԭz
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                String accoutNumber = rest.getString(1);                
                list.add(accoutNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //�]�w����k

public void Batch(String incomeId, String goId, float money) throws SQLException {
    try {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        boolean autoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
       
        Statement cs = null; // �w�qStatement�ﹳ            
        cs = conn.createStatement(); // ��Ҥ�Statement�ﹳ
        cs.addBatch("update tb_transition set deposit = deposit-" + money
                + " ,transition = transition-" + money
                + " where accoutNumber = " + goId);             //�w�q�ק�������Ƥ�k
        cs.addBatch("update tb_transition set deposit = deposit+" + money
                + " ,shift = shift+" + money + " where accoutNumber = "
                + incomeId);
        cs.executeBatch(); // �妸����SQL�ԭz
        cs.close(); // �NStatement�ﹳ����
        conn.commit();
        conn.setAutoCommit(autoCommit);
        conn.close();
    } catch (Exception e) {
        conn.rollback();
        e.printStackTrace();        
    }
}
    
}
