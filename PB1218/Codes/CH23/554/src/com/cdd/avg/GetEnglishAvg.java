package com.cdd.avg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetEnglishAvg {
    private Connection conn; // �w�qConnection�ﹳ
    
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
    /**
     * @param args
     */
    
    public List getAvg() {
        List list = new ArrayList<Grade>(); // �w�qList���X�ﹳ
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select id,name,english,( select avg(english) from tb_grade ) as avgEnglish,"
                    + "(english-( select avg(english) from tb_grade )) as diffAvgEnglish from tb_grade"; // �w�q�d�߱ԭz
            ResultSet rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                Grade grade = new Grade(); // �w�q�P��ƪ������JavaBean�ﹳ
                grade.setId(rest.getInt(1)); // �]�w�ﹳ�ݩ�
                grade.setName(rest.getString(2));
                grade.setEnglish(rest.getFloat(3));
                grade.setAvgEng(rest.getFloat(4));
                grade.setBalance(rest.getFloat(5));
                list.add(grade); // �V���X���W�[����
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^�d�ߵ��G
    }    
    public static void main(String[] args) {
        GetEnglishAvg getEnglishAvg = new GetEnglishAvg();
        List list = getEnglishAvg.getAvg();
        System.out.println("�d�߾ǥͭ^�y���Z�B�^�y�������Z�B���Z�t�B�G");
        for (int i = 0; i < list.size(); i++) {
            Grade grade = (Grade) list.get(i);
            System.out.println("�s���G" + grade.getId() + " �m�W�G" + grade.getName()
                    + "  �^�y���Z�G" + grade.getEnglish() + " �������Z�G"
                    + grade.getAvgEng() + " ���Z�t�B�G" + grade.getBalance());
        }
        
    }
    
}
