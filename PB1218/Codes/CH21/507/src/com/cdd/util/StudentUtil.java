package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentUtil {
    Connection conn = null;
    
    // ��o��ƨ�Ʈw�s��
    
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
public List getMINStudent() {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select name,sex,age,specialty from tb_student where age = (select min(age) from  tb_student)"; // �w�q�d�߾ǥͪ���~�ֳ̤p���ǥ͸�TSQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
          Student student = new Student();  //�w�q�ǥ͹ﹳ
          student.setName(set.getString("name"));   //�]�w�ǥ͹�H���m�W�ݩ�
          student.setSex(set.getString("sex"));
          student.setAge(set.getInt("age"));
          student.setSpecialty(set.getString("specialty"));
          list.add(student);                //�N�ǥ͹ﹳ�W�[�춰�X��
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;        //�Ǧ^List���X
}
    public static void main(String[] args) {
        StudentUtil util = new StudentUtil();
        List list = util.getMINStudent();
        System.out.println("�d�ߦ~���̤p���ǥ͸�T�G");
        for(int i = 0;i<list.size();i++){
            Student student = (Student)list.get(i);
            System.out.println("�ǥͩm�W�G"+student.getName()+
                    " �A�ǥͩʧO�G"+student.getSex()+" �A�ǥͦ~�֡G"+student.getAge()+" �A�ҾǱM�~�G"
                    +student.getSpecialty());
        }
    }
}
