package com.cdd.triiger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
    public int insertGrade(Grade grade) {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        PreparedStatement cs = null; // �w�qPreparedStatement�ﹳ
        int count = 0;
        try {
            String sql = "insert into tb_grade values(?,?,?,?)"; // �w�q���JSQL�ԭz
            cs = conn.prepareStatement(sql);
            cs.setString(1, grade.getName()); // �]�w�w���B�z�ԭz�Ѽ�
            cs.setFloat(2, grade.getMath());
            cs.setFloat(3, grade.getEnglist());
            cs.setFloat(4, grade.getChinese());
            count = cs.executeUpdate(); // ����w���B�z�ԭz�A��{���J�ާ@
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
}
