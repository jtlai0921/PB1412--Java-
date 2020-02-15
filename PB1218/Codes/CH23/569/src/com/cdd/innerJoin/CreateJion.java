package com.cdd.innerJoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateJion {
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

public ResultSet getJoin() {
    conn = getConn(); // ��o�P��ƨ�Ʈw���s��
    ResultSet rest;
    try {
        Statement statement = conn.createStatement(); // ��oStatement�ﹳ
        String sql = "select cName,tName from tb_course c inner join tb_teacher  t on c.id = t.cId "; // �w�q�d�߱ԭz
        rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
        return rest; // �Ǧ^�d�ߵ��G
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        CreateJion createJion = new CreateJion();
        ResultSet rest = createJion.getJoin();
        System.out.println("���s���d�߬Y�ҵ{���Юv��T");
        try {
            while (rest.next()) {
                String cName = rest.getString(1);
                String tName = rest.getString(2);
                System.out.println(cName + "�Ҫ��Юv�O�G" + tName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
