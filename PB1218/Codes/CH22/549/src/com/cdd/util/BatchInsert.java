package com.cdd.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BatchInsert {
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
    
public void insertStu(String sql){
    conn = getConn();                       //��o��ƨ�Ʈw�s��
    try {
        Statement statement = conn.createStatement();   //�إ�Statement�ﹳ
        statement.executeUpdate(sql);       //���洡�JSQL�ԭz
    } catch (Exception e) {           
        e.printStackTrace();
    }        
}

public static void main(String[] args) {
    BatchInsert insert = new BatchInsert();     //�إߥ����O�ﹳ
    String sql = "insert tb_stu select '����','�k','�ͪ����','08d02' " +
    		"union all select '���n','�k','�p�������','08d02' " +
    		"union all select '����','�k','�^�y','07d02'";     //�w�q���J��SQL�ԭz
    insert.insertStu(sql);          //�I�s���J��Ƥ�k
}
}
