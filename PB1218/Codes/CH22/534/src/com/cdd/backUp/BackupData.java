package com.cdd.backUp;

import java.sql.*;
import java.util.*;

public class BackupData {
    public Connection Con() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection Con = DriverManager.getConnection(
                    "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=master",
                    "sa", "1");
            return Con;
        } catch (Exception e) {
            return null;
        }
    }
    
    // ��o�Ҧ���ƨ�Ʈw�W��
    
public List getDatabase() {
    List list = new ArrayList(); // �w�qList���X�ﹳ
    Connection con = Con(); // ��o��ƨ�Ʈw�s��
    Statement st; // �w�qStatement�ﹳ
    try {
        st = con.createStatement(); // ��Ҥ�Statement�ﹳ
        ResultSet rs = st.executeQuery("select name from dbo.sysdatabases"); // ���w�d�ߩҦ���ƨ�Ʈw��k
        while (rs.next()) { // �`���ˬd�d�ߵ��G��
            list.add(rs.getString(1)); // �N�d�߸�ƼW�[��List���X��
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^�d�ߵ��G
}
    
    // �w�q�d�߳ƥ���ƨ�Ʈw��k

public void getBak(String databaseName, String databasePath) {
    Connection con = Con();           //��o��ƨ�Ʈw�s��
    Statement st;
    try {
        st = con.createStatement();     //��Ҥ�Statement�ﹳ
        st.executeUpdate("backup database " + databaseName + " to disk='"
                + databasePath + "'");      //���w��ƨ�Ʈw�ƥ�SQL�ԭz
        con.close();                //�����s��
    } catch (SQLException e) {          
        e.printStackTrace();
    }        
}
    
}
