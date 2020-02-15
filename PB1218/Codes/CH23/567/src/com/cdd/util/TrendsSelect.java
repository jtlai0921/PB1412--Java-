package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrendsSelect {
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
    
    public List getGrade(String operator, String denotation, int mark) {
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        ResultSet rest;
        List list = new ArrayList();
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select * from tb_grade where " + operator
                    + denotation + mark; // �w�q�d�߱ԭz
            rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                Grade grade = new Grade(); // �w�q�P��ƪ������JavaBean�ﹳ
                grade.setId(rest.getInt(1)); // �]�w�ﹳ�ݩʭ�
                grade.setName(rest.getString(2));
                grade.setSex(rest.getString(3));
                grade.setEnglish(rest.getInt(4));
                grade.setChinese(rest.getInt(5));
                grade.setMath(rest.getInt(6));
                list.add(grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^���X
    }
    
}
