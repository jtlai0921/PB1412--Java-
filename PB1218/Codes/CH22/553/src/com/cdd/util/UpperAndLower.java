package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpperAndLower {
    Connection conn = null;    
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
    
    public List getUpperAndLower() {
        List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        try {
            Statement staement = conn.createStatement();
            String sql = "select upper(FristName),lower(LastName),nationality,speciality from tb_abroad"; // �w�q�d�߸�ƪ�SQL�ԭz
            ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
            while (set.next()) { // �`���ˬd�d�ߵ��G��
                Abord abord = new Abord(); // �w�q�P��ƪ������JavaBean�ﹳ
                abord.setFristName(set.getString(1)); // �]�w�ﹳ�ݩ�
                abord.setLastName(set.getString(2));
                abord.setNationality(set.getString(3));
                abord.setSpeciality(set.getString(4));
                list.add(abord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^List���X
    }
}
