package com.cdd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentUnion {
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

public List getMessageEmp() {
    conn = getConn(); // ��o�P��ƨ�Ʈw���s��
    List list = new ArrayList<Student>();
    try {
        Statement statement = conn.createStatement(); // ��oStatement�ﹳ
        String sql = "select * from tb_stu2006 union select * from tb_stu2007 union select * from tb_stu2008"; // �w�q�d�߱ԭz
        ResultSet rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
        while(rest.next()){              
            Student student = new Student();
            student.setId(rest.getString(1));
            student.setName(rest.getString(2));
            student.setSex(rest.getString(3));
            student.setSpciality(rest.getString(4));
            student.setAddress(rest.getString(5));
            list.add(student);
        }
        return list; // �Ǧ^�d�ߵ��G
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
   
    
}
