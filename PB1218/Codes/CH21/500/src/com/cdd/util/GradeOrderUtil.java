package com.cdd.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeOrderUtil {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // �Ǧ^Connection�ﹳ
    }
    
    // �w�q�����w�����w���󭰧Ǭd�߸�Ƥ�k
    
    /**
     * @return
     */
    
public List getGradeOrder() {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select * from tb_Grade order by name  collate chinese_prc_cs_as"; // �w�q�����ǱƧǪ�SQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            Grade grade = new Grade();  //��Ҥƾǲ����Z�ﹳ
            grade.setId(set.getInt(1)); //�]�w��H���s��
            grade.setName(set.getString(2));
            grade.setChinses(set.getFloat("chinese"));
            grade.setEnglish(set.getFloat("english"));
            grade.setHistory(set.getFloat("history"));
            grade.setMath(set.getFloat("math"));
            grade.setPhysics(set.getFloat("physics"));
            list.add(grade);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^�d�߶��X
}

    public static void main(String[] args) {
        GradeOrderUtil util = new GradeOrderUtil();
        List list = util.getGradeOrder();
        System.out.println("����r�����ǱƧǡG");
        for (int i = 0; i < list.size(); i++) {
            Grade grade = (Grade)list.get(i);
            System.out.println("�s�����G"+grade.getId()+"  �m�W�G"+grade.getName()+
                    "  �y��G"+grade.getChinses()+"  �^�y�G"+grade.getEnglish()+
                    "  ���v�G"+grade.getHistory()+"  �ƾǡG"+grade.getMath()+
                    "  ����G"+grade.getPhysics());            
        }
    }
}
