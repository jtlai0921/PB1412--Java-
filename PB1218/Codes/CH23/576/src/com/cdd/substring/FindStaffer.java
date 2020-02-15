package com.cdd.substring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FindStaffer {

    private Connection conn;
    
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database23"; // �s����ƨ�ƮwURL
        String userName = "sa"; // �s����ƨ�Ʈw���ϥΪ̦W��
        String passWord = "1"; // �s����ƨ�Ʈw�K�X
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // ��o��ƨ�Ʈw�s��
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // �Ǧ^Connection�ﹳ
    }

public List getBirthday() {
    conn = getConn(); // ��o�P��ƨ�Ʈw���s��
    ResultSet rest;
    List list = new ArrayList<Staffer>();
    try {
        Statement statement = conn.createStatement(); // ��oStatement�ﹳ
        String sql = "select id,sName,substring(code,7,8) as birthday ,code,degree,job from tb_staffer"; // �w�q�d�߱ԭz
        rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
        while (rest.next()) { // �`���ˬd�d�ߵ��G��
            Staffer staffer = new Staffer();    //�w�q�P��ƨ�Ʈw������JavaBean��k
            staffer.setId(rest.getInt(1));      //�]�w�ﹳ�ݩ�
            staffer.setsName(rest.getString(2));
            staffer.setBirthday(rest.getString(3));
            staffer.setCode(rest.getString(4));
            staffer.setDegree(rest.getString(5));
            staffer.setJob(rest.getString(6));
            list.add(staffer);                  //�N�ﹳ�W�[�춰�X��
        }
        return list; // �Ǧ^�d�ߵ��G
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}
