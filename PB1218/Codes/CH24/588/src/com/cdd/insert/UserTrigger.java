package com.cdd.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTrigger {
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

public void insertInfo(User user){
    conn = getConn();       //��o��ƨ�Ʈw�s��
    try {
        PreparedStatement statement = conn.prepareStatement("insert into tb_user values(?,?,?,?,?)");   //�w�q�W�[��ƪ�SQL�ԭz
        statement.setString(1, user.getUserName());     //�]�w�w���B�z�ԭz���Ѽƭ�
        statement.setString(2, user.getPassword());
        statement.setInt(3, user.getAge());
        statement.setString(4,user.getSex());
        statement.setString(5, user.getJob());
        statement.executeUpdate();      //����w���B�z�ԭz
    } catch (Exception e) {           
        e.printStackTrace();
    }        
}
}
