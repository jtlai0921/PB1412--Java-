package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

public class AbroadUtil {
    Connection conn = null;
    
    // ��o��ƨ�Ʈw�s��
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database21"; // �s����ƨ�ƮwURL
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
    
    public List getAbroad() {
        List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        try {
            Statement staement = conn.createStatement();
            String sql = "select top 3 * from tb_abroads  order by newid()"; // �w�q�d�߸�ƪ�SQL�ԭz
            ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
            while (set.next()) { // �`���ˬd�d�ߵ��G��
                Abroad abord = new Abroad(); // �w�q�P��ƪ������JavaBean�ﹳ
                abord.setId(set.getInt(1));
                abord.setFristName(set.getString(2)); // �]�w�ﹳ�ݩ�
                abord.setLastName(set.getString(3));
                abord.setNationality(set.getString(4));
                abord.setSpeciality(set.getString(5));
                list.add(abord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^List���X
    }
    
}
