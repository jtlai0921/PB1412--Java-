package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectDateUtil {
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
    //���X�ͤ���M��ǥ͸�T��k

public List getStuUseDate(String sDate) {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select * from tb_StuInfo where sBrithday = '"+sDate+"'"; // �w�q�d�߸�ƪ�SQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
           StuInfo stuInfo = new StuInfo();     //�إߩ��ƪ������JavaBean�ﹳ
           stuInfo.setId(set.getInt(1));        //�]�w�ﹳ�ݩ�
           stuInfo.setsName(set.getString(2));
           stuInfo.setsSex(set.getString(3));
           stuInfo.setsBrithday(set.getString(4));
           stuInfo.setsSpeciality(set.getString(5));
           stuInfo.setsAddress(set.getString(6));
           list.add(stuInfo);                   //�V���X���W�[�ﹳ
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^List���X
}
    //�d�ߩҦ��ǥͥX�ͤ����k
    public List getStuDateList() {
        List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        try {
            Statement staement = conn.createStatement();
            String sql = "select sBrithday from tb_StuInfo "; // �w�q�d�߸�ƪ�SQL�ԭz
            ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
            while (set.next()) { // �`���ˬd�d�ߵ��G��
               String sDate = new String();
               sDate = set.getString(1);
               list.add(sDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^List���X
    }
}
