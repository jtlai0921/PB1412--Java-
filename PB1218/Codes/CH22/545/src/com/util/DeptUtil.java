package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeptUtil {
    Connection conn = null;    
    // ��o��ƨ�Ʈw�s��
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
    
public void insertDept(Dept dept) {
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        PreparedStatement statement = conn
                .prepareStatement("insert into tb_dept values(?,?,?)"); // �w�q���J��ƨ�Ʈw���w���B�z�ԭz
        statement.setString(1,dept.getDid() ); // �]�w�w���B�z�ԭz���Ѽƭ�
        statement.setString(2,dept.getdName());
        statement.setString(3, dept.getPriName());      
        statement.executeUpdate(); // ����w���B�z�ԭz
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public List selectDept() {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        Statement statment;
        List list = new ArrayList<Dept>();
        try {
            statment = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select * from tb_dept"; // �w�q�d��SQL�ԭz
            ResultSet rest = statment.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
              Dept dept = new Dept();
              dept.setDid(rest.getString(1));
              dept.setdName(rest.getString(2));
              dept.setPriName(rest.getString(3));
              list.add(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^�d�ߵ��G
    }
}
