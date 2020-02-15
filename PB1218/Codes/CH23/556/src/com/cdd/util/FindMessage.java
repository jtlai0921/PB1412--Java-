package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class FindMessage {
  private Connection conn; // �w�qConnection�ﹳ
    
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
    /**
     * @param args
     */
    
public ResultSet getMessage() {
    ResultSet rest = null;
    conn = getConn(); // ��o�P��ƨ�Ʈw���s��
    try {
        Statement statement = conn.createStatement(); // ��oStatement�ﹳ
        String sql = "select name,college,address from tb_student I where exists " +
        		"(select name from tb_grade M where M.name=I.name and english >90)"; // �w�q�d�߱ԭz
        rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��           
    } catch (Exception e) {
        e.printStackTrace();
    }
    return rest; // �Ǧ^�d�ߵ��G
}    
    /**
     * @param args
     */
    public static void main(String[] args) {
       FindMessage findMessage = new FindMessage();
       ResultSet rest = findMessage.getMessage();
       System.out.println("�d�߭^�妨�Z�b90���H�W���ǥ͸�T�G");
       try {
        while(rest.next()){
               String name = rest.getString(1);
               String college = rest.getString(2);
               String address = rest.getString(3);
               System.out.println("�m�W���G"+name+" �ǰ|���G"+college+" �a�}���G"+address);
           }
    } catch (Exception e) {       
        e.printStackTrace();
    }
    }
    
}
