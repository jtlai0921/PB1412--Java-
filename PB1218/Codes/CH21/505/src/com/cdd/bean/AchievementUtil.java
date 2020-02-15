package com.cdd.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AchievementUtil {
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
    
    // �w�q�����w�����w���󭰧Ǭd�߸�Ƥ�k

public float getBooKDesc() {
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    float sum = 0;
    try {
        Statement staement = conn.createStatement();
        String sql = "select sum(achievement)as sum from tb_achievement where monthCount <= 3"; // �w�q�M��Ĥ@�u�שw�q�`�M��SQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            sum = set.getFloat(1);         //��o�d�ߵ��G       
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return sum;
}
    
    public static void main(String[] args) {
        AchievementUtil util = new AchievementUtil();
        float ft = util.getBooKDesc();
        System.out.println("�q�����Ĥ@�u�ת��`�q����B���G "+ft);
    }
}
