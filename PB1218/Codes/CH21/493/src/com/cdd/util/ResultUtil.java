package com.cdd.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultUtil {
    // ��o��ƨ�Ʈw�s��
    private Connection conn;
    
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
    
    public List getGrade() {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        List list = new ArrayList(); // �w�q�x�s�Ǧ^�Ȫ�List�ﹳ
        try {
            Statement staement = conn.createStatement(); // �w�qStatement�ﹳ
            String sql = "select * from tb_Grade"; // �w�q�d�ߪ�SQL�ԭz
            ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�A�Ǧ^�d�ߵ��G��
            while (set.next()) { // �`���ˬd�d�ߵ��G��
                Grade grade = new Grade();
                grade.setId(set.getInt(1));
                grade.setName(set.getString(2));
                grade.setChinses(set.getFloat(3));
                grade.setEnglish(set.getFloat("english"));
                grade.setHistory(set.getFloat("history"));
                grade.setMath(set.getFloat("math"));
                grade.setPhysics(set.getFloat("physics"));
                list.add(grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^�d�ߵ��G
    }
    
    // �w�q�����w�����w���󭰧Ǭd�߸�Ƥ�k
    
    public List getGradeDesc(String taxis) {
        List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        try {
            Statement staement = conn.createStatement();
            String sql = "select id,name,(chinese+math+english+physics+history) as sum from tb_grade order by sum "
                    + taxis; // �w�q�N�ϮѪ����T�i��ƧǪ�SQL�ԭz
            ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
            while (set.next()) { // �`���ˬd�d�ߵ��G��
                Grade grade = new Grade(); // �إߩ�ǲ����Z�������Grade�ﹳ
                grade.setId(set.getInt(1)); // �]�w�ﹳ�ݩ�
                grade.setName(set.getString(2));
                grade.setSum(set.getFloat("sum"));
                list.add(grade); // �NGrade�ﹳ�W�[�춰�X��
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^�d�߶��X
    }
    
}
