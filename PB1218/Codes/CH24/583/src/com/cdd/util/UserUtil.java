package com.cdd.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserUtil {
    
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

public boolean executeUpdate(User user) {
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    CallableStatement cs = null; // �w�qCallableStatement�ﹳ
    String sql = "{call insertUser('" + user.getUserName() + "','"
            + user.getPassword() + "','" + user.getAge() + "','"
            + user.getSex() + "','" + user.getJob() + "')}";    //�w�q�I�s�w�x�{�Ǫ�SQL�ԭz
    try {
        cs = conn.prepareCall(sql);     //��Ҥ�CallableStatement�ﹳ
        cs.executeUpdate();             //����SQL�ԭz
        return true;
    } catch (SQLException e) {   
        e.printStackTrace();
        return false;
    }        
}
}
