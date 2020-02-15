package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MerchandiseUtil {
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
                System.out.println("��ƨ�Ʈw�s�����\�I");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // �Ǧ^Connection�ﹳ
    }
    
    // �d�߹ϮѪ���Ҧ��O����k
    
public List getMerchandise() {
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    List list = new ArrayList(); // �w�q�x�s�Ǧ^�Ȫ�List�ﹳ
    try {
        Statement staement = conn.createStatement(); // �w�qStatement�ﹳ
        String sql = "select * from tb_merchandise"; // �w�q�d�ߪ�SQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�A�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            Merchandise merchandise = new Merchandise();
            merchandise.setId(set.getInt(1));
            merchandise.setWareName(set.getString(2));
            merchandise.setWareDate(set.getString(3));
            list.add(merchandise);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^�d�ߵ��G
}
    
    // �w�q�����w�����w���󭰧Ǭd�߸�Ƥ�k

public String getgetMerchandiseDate(String term) {
    String date = "";
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select  datediff(mm,(select wareDate from tb_merchandise where wareName ='"
                + term + "'),getDate())"; // �w�q�N�ϮѪ����T�i��ƧǪ�SQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            date = set.getString(1);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return date;
}
    public static void main(String[] args) {
        MerchandiseUtil util = new MerchandiseUtil();
        String date = util.getgetMerchandiseDate("A�����");
        System.out.println(date);
    }
}
