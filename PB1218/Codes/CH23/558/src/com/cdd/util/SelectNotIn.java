package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectNotIn {
    Connection conn = null;
    
    // ��o��ƨ�Ʈw�s��
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
            if (conn != null) {
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // �Ǧ^Connection�ﹳ
    }

public List getNotIn() {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select * from tb_student where name not in (select name from tb_grade)"; // �w�q�d�߸�ƪ�SQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            Student student = new Student();        //�w�q�P��ƨ�Ʈw������JavaBean�ﹳ
            student.setId(set.getInt(1));           //�]�w�ﹳ�ݩ�
            student.setName(set.getString(2));
            student.setCollege(set.getString(3));
            student.setSpeciality(set.getString(4));
            student.setAddress(set.getString(5));
            list.add(student);                  //�N�ﹳ�W�[�춰�X��
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^List���X
}
    
    public static void main(String[] args) {
        SelectNotIn notin = new SelectNotIn();
        List list = notin.getNotIn();
        System.out.println("�d�ߨS�����Z���ǥ͸�T�G");
        for (int i = 0; i < list.size(); i++) {
            Student student = (Student) list.get(i);
            System.out.println("�s���G" + student.getId() +"  �m�W�G"+ student.getName()
                    +"  �ǰ|�G"+ student.getCollege() +"  �M�~�G"+ student.getSpeciality()
                    +"  �a�}�G"+ student.getAddress());
        }
    }
}
