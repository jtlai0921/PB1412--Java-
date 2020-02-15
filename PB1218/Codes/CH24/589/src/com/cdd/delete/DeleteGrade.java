package com.cdd.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeleteGrade {
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
    
    // �d�ߩҦ��ǥ͸�T
    public List executeGrade() {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        Statement cs = null; // �w�qCallableStatement�ﹳ
        String sql = "select * from tb_grade"; // �w�q�I�s�w�x�{�Ǫ�SQL�ԭz
        List list = new ArrayList();
        try {
            cs = conn.createStatement(); // ��Ҥ�Statement�ﹳ
            ResultSet rest = cs.executeQuery(sql); // ����SQL�ԭz
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                Grade grade = new Grade();
                grade.setId(rest.getInt(1));
                grade.setName(rest.getString(2));
                grade.setChinese(rest.getFloat("chinese"));
                grade.setEnglist(rest.getFloat("englist"));
                grade.setMath(rest.getFloat("math"));
                list.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // �d�ߩҦ��ǥ͸�T
    public List executeStu() {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        Statement cs = null; // �w�qCallableStatement�ﹳ
        String sql = "select * from tb_stu"; // �w�q�I�s�w�x�{�Ǫ�SQL�ԭz
        List list = new ArrayList();
        try {
            cs = conn.createStatement(); // ��Ҥ�Statement�ﹳ
            ResultSet rest = cs.executeQuery(sql); // ����SQL�ԭz
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                Stu stu = new Stu();
                stu.setId(rest.getInt(1));
                stu.setName(rest.getString(2));
                stu.setSex(rest.getString(3));
                stu.setSpecialty(rest.getString(4));
                list.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // �R���ǲ����Z��T
    
    public void deleteGrade(int id) {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        try {
            Statement statement = conn.createStatement(); // �w�qStatement��k
            statement.executeUpdate("delete from tb_grade where id=" + id); // ����R���ާ@
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
