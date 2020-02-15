package com.cdd.laborage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FindLaborage {
    
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
    
    public List getPatindex() {
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        ResultSet rest;
        List list = new ArrayList<FindLaborage>();
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select id,name,Base,round(Subsidy,0) as subsidy, round(deduct,0) as deduct from tb_particularLaborage"; // �w�q�d�߱ԭz
            rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                ParticularLaborage laborage = new ParticularLaborage(); // �w�q���ƪ������JavaBean�ﹳ
                laborage.setId(rest.getInt(1)); // �]�w�ﹳ�ݩ�
                laborage.setName(rest.getString(2));
                laborage.setBase(rest.getFloat(3));
                laborage.setSubsidy(rest.getFloat(4));
                laborage.setDeduct(rest.getFloat(5));
                list.add(laborage); // �V���X���W�[�ﹳ
            }
            return list; // �Ǧ^�d�ߵ��G
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        FindLaborage findLaborage = new FindLaborage();
        List list = findLaborage.getPatindex();
        System.out.println("�N��ƶi��|�ˤ��J�G");
        for (int i = 0; i < list.size(); i++) {
            ParticularLaborage particularLaborage = (ParticularLaborage) list
                    .get(i);
            int id = particularLaborage.getId();
            String name = particularLaborage.getName();
            float base = particularLaborage.getBase();
            float subsidy = particularLaborage.getSubsidy();
            float deduct = particularLaborage.getDeduct();
            System.out.println("�s���G" + id + " �m�W�G" + name + "  ���~���G" + base
                    + " �z�K�G" + subsidy + " �����G" + deduct);
        }
    }
}
