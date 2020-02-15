package com.cdd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindLaborage {
    
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
    
    public ResultSet getMessageEmp() {
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select distinct dName,laborage.name,laborage.laborage,lYear,lDate from tb_laborage laborage,tb_dept dept,tb_employee emp "
                    + "where laborage.name in(select name from tb_employee where job = '�����g�z' "
                    + "and schoolAge = '����' and dID =  dept.id )"; // �w�q�d�߱ԭz
            ResultSet rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            return rest; // �Ǧ^�d�ߵ��G
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        FindLaborage Dlaborage = new FindLaborage(); // �إߥ����O�ﹳ
        ResultSet rest = Dlaborage.getMessageEmp(); // �I�s�d�ߤ�k
        System.out.println("�d�ߥ��쪺�����g�z���리�J���p");
        try {
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                String dName = rest.getString(1); // ��o���G������T
                String name = rest.getString(2);
                float laborage = rest.getFloat(3);
                int lYear = rest.getInt(4);
                int lDate = rest.getInt(5);
                System.out.println("�m�W�G" + name + " �����G" + dName + " �~���G"
                        + laborage + " �~���G" + lYear + " ����G" + lDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
