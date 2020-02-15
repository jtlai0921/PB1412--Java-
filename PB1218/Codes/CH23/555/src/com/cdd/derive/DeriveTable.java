package com.cdd.derive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DeriveTable {
    private Connection conn ;   //�w�qConnection�ﹳ
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
    //�w�q�Τl�d�ߧ@���l�ͪ����k
    
    public List getSubTable() {
        List list = new ArrayList<Emp>(); // �w�qList���X�ﹳ
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select * from (select id,eName,headship,laborage from tb_emp)tb"; // �w�q�d�߱ԭz
            ResultSet rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                Emp emp = new Emp(); // �w�q���ƪ������JavaBean�ﹳ
                emp.setId(rest.getInt(1)); // �]�w�ﹳ�ݩ�
                emp.setName(rest.getString(2));
                emp.setHeadship(rest.getString(3));
                emp.setLaborage(rest.getFloat(4));
                list.add(emp); // �N�ﹳ�W�[�춰�X��
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^�d�ߵ��G
    }
    
    //�w�q�d�߭��u���Ҧ���T��k
    public List getFullMessage() {
        List list = new ArrayList<Emp>(); // �w�qList���X�ﹳ
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select * from tb_emp"; // �w�q�d�߱ԭz
            ResultSet rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
               Emp emp = new Emp();
               emp.setId(rest.getInt(1));
               emp.setName(rest.getString(2));
               emp.setHeadship(rest.getString(3));
               emp.setDept(rest.getString(4));
               emp.setJoinDate(rest.getString(5));
               emp.setLaborage(rest.getFloat(6));
               list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^�d�ߵ��G
    }       
}
