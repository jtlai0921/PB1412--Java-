package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CopyDate {
    private Connection conn;
    
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
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // �Ǧ^Connection�ﹳ
    }
    
    public List getExcellenceStu() {
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        ResultSet rest;
        List list = new ArrayList();
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select * from tb_stu"; // �w�q�d�߱ԭz
            rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                ExcellenceStu excellenceStu = new ExcellenceStu();
                excellenceStu.setId(rest.getInt(1));
                excellenceStu.setName(rest.getString(2));
                excellenceStu.setSex(rest.getString(3));
                excellenceStu.setSpecialty(rest.getString(4));
                excellenceStu.setGrade(rest.getString(5));
                list.add(excellenceStu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^���X
    }
    
    public void insertStu(int id) {
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "insert into tb_excellenceStu select name,sex,specialty,grade from tb_stu where id = "
                    + id; // �w�q���J��ƪ�SQL�ԭz
            statement.executeUpdate(sql); // ���洡�J�ԭz
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
