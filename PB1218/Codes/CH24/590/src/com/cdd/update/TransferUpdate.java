package com.cdd.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TransferUpdate {
  private Connection conn;
    
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database24"; // �s����ƨ�ƮwURL
        String userName = "sa"; // �s����ƨ�Ʈw���ϥΪ̦W��
        String passWord = "1"; // �s����ƨ�Ʈw�K�X
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // ��o��ƨ�Ʈw�s��
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // �Ǧ^Connection�ﹳ
    }
    //�d�ߩҦ��ǲ����Z��T
    public List executeTeacher() {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        Statement cs = null; // �w�qCallableStatement�ﹳ
        String sql = "select * from tb_teacher"; // �w�q�I�s�w�x�{�Ǫ�SQL�ԭz
        List list = new ArrayList();
        try {
            cs = conn.createStatement(); // ��Ҥ�Statement�ﹳ
            ResultSet rest = cs.executeQuery(sql); // ����SQL�ԭz
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                Teacher teacher = new Teacher();
                teacher.setId(rest.getInt(1));
                teacher.settName(rest.getString(2));
                teacher.setCourse(rest.getString(3));
                list.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return list;
    }
    //�d�߫��w�s�����Юv��T
    public Teacher selectTeacher(int id) {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        Statement cs = null; // �w�qCallableStatement�ﹳ
        String sql = "select * from tb_teacher where id ="+id; // �w�q�I�s�w�x�{�Ǫ�SQL�ԭz
        Teacher teacher = new Teacher();
        try {
            cs = conn.createStatement(); // ��Ҥ�Statement�ﹳ
            ResultSet rest = cs.executeQuery(sql); // ����SQL�ԭz
            while (rest.next()) { // �`���ˬd�d�ߵ��G��               
                teacher.setId(rest.getInt(1));
                teacher.settName(rest.getString(2));
                teacher.setCourse(rest.getString(3));               
            }
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return teacher;
    }

public void updateTeacher(Teacher teacher){
    conn = getConn();       //��o��ƨ�Ʈw�s��
    try {
        PreparedStatement statement = conn.prepareStatement("update tb_teacher set tName=?,course = ? where id = ?") ;  //�w�qPreparedStatement�ﹳ
        statement.setString(1, teacher.gettName());     //�]�w�w���B�z�ԭz���Ѽ�
        statement.setString(2, teacher.getCourse());
        statement.setInt(3, teacher.getId());
        statement.executeUpdate();      //����R���ާ@      
    } catch (SQLException e) {          
        e.printStackTrace();
    }        
}
   
}
