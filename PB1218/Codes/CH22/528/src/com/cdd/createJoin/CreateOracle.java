package com.cdd.createJoin;

import java.sql.*;

public class CreateOracle {

public Connection getConnection() {
    Connection conn = null;
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");   //���J��ƨ�Ʈw�X��
        System.out.println("��ƨ�Ʈw�X�ʸ��J���\�I");           //��X����T
        String url = "jdbc:oracle:thin:@localhost:1521:orcl3";  //��o�s��URL
        String user = "system";                     //�s���ϥΪ̦W��
        String password = "aaa";                    //�s���K�X
        Connection con = DriverManager.getConnection(url, user, password);  //��o��ƨ�Ʈw�s��
        if (con != null) {
            System.out.println("���\���POracle��ƨ�Ʈw�إ߳s���I�I");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }        
    return conn;        //�Ǧ^Connection���        
}

    public static void main(String[] args) {
        CreateOracle oracle = new CreateOracle();
        oracle.getConnection();
    }
}
