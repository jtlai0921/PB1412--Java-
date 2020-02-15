package com.cdd.useAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FinMaxEmpLaborage {
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
    
    public List getLaborage() {
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        ResultSet rest;
        List list = new ArrayList<Emp>();
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select eName,headship,laborage from tb_emp  where laborage > all(select laborage from tb_emp where dept = '��q��')"; // �w�q�d�߱ԭz
            rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                Emp emp = new Emp(); // �w�q���ƪ������JavaBean�ﹳ
                emp.seteName(rest.getString(1)); // �]�w�ﹳ�ݩ�
                emp.setHeadship(rest.getString(2));
                emp.setLaborage(rest.getFloat(3));
                list.add(emp); // �V���X���W�[�ﹳ
            }
            return list; // �Ǧ^�d�ߵ��G
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        FinMaxEmpLaborage maxLaborage = new FinMaxEmpLaborage();
        List list = maxLaborage.getLaborage();
        System.out.println("�d�ߤ��q�����Ҧ����u�~�����������u�~�����p�G");
        for (int i = 0; i < list.size(); i++) {
            Emp emp = (Emp) list.get(i);
            System.out.println("�m�W�G" + emp.geteName() + "  �����G"
                    + emp.getHeadship() + "  �~���G" + emp.getLaborage());
        }
    }
}
