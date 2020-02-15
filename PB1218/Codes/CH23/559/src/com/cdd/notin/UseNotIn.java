package com.cdd.notin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UseNotIn {
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
    
    // �w�q�Τl�d�ߧ@���l�ͪ����k

public List getSubTable() {
    List list = new ArrayList<Student>(); // �w�qList���X�ﹳ
    conn = getConn(); // ��o�P��ƨ�Ʈw���s��
    try {
        Statement statement = conn.createStatement(); // ��oStatement�ﹳ
        String sql = "select * from tb_student where college not in (select college from tb_student where name ='��p' )"; // �w�q�d�߱ԭz
        ResultSet rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
        while (rest.next()) { // �`���ˬd�d�ߵ��G��
            Student student = new Student();        //�w�q���ƪ������JavaBean�ﹳ
            student.setId(rest.getInt(1));          //�]�w�ﹳ�ݩ�
            student.setName(rest.getString(2));
            student.setCollege(rest.getString(3));
            student.setSpeciality(rest.getString(4));
            student.setAddress(rest.getString(5));
            list.add(student);                      //�V���X���W�[����
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^�d�ߵ��G
}
    
    public static void main(String[] args) {
        UseNotIn useNot = new UseNotIn();
        List list = useNot.getSubTable();
        System.out.println("�P��p���b�P�@�Ӿǰ|���ǥ͸�T�G");
        for(int i = 0 ;i<list.size();i++){
            Student student = (Student)list.get(i);
            System.out.println("�ǥͽs���G"+student.getId()+" �m�W�G"+student.getName()+" �ǰ|�G"+student.getCollege()+"  �Ǭ�G"+student.getSpeciality()+
                    "   �a�}�G"+student.getAddress());
        }
    }
}
