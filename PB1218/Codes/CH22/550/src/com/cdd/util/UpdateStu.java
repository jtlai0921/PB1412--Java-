package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpdateStu {
    // ��o��ƨ�Ʈw�s��
    private Connection conn;
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database22"; // �s����ƨ�ƮwURL
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
    //�w�q��stb_stu���k

public void updateStu(Stu stu){
    conn = getConn();   //��o��ƨ�Ʈw�s��
    try {
        PreparedStatement statement = conn.prepareStatement("update tb_stu set name = ?,sex = ?,grade = ?,specialty = ? where id = ?");//�w�q��sSQL�ԭz
        statement.setString(1, stu.getName());  //�]�w�w���B�z�ԭz�Ѽ�
        statement.setString(2, stu.getSex());
        statement.setString(3,stu.getGrade());
        statement.setString(4, stu.getSpecialty());
        statement.setInt(5, stu.getId());
        statement.execute();    //����w���B�z�ԭz
    } catch (Exception e) {            
        e.printStackTrace();
    }        
}
    
    //�w�q�d�ߩҦ��P�Ǹ�T��k
    public List selectStu(){
        conn = getConn();
        Statement statement;
        List list = new ArrayList<Stu>();
        try {
            statement = conn.createStatement();
            ResultSet rest = statement.executeQuery("select * from tb_stu");
            while(rest.next()){
                Stu stu = new Stu();
                stu.setId(rest.getInt(1));
                stu.setName(rest.getString(2));
                stu.setGrade(rest.getString("grade"));
                stu.setSex(rest.getString(3));
                stu.setSpecialty(rest.getString(4));
                list.add(stu);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return list;        
    }
    //�w�q���ӫ��w�s���d�߾ǥ͸�T��k
    public Stu selectStu(int id){
        conn = getConn();
        Statement statement;
        Stu stu = new Stu();
        try {         
            statement = conn.createStatement();
            ResultSet rest = statement.executeQuery("select * from tb_stu where id = "+id);
            while(rest.next()){              
                stu.setId(rest.getInt(1));
                stu.setName(rest.getString(2));
                stu.setGrade(rest.getString("grade"));
                stu.setSex(rest.getString(3));
                stu.setSpecialty(rest.getString(4));          
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return stu;        
    }
}
