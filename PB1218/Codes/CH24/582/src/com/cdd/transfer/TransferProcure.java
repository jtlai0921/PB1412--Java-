package com.cdd.transfer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferProcure {
    
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

public String executeQuery(String userName,String passWord){
    String message = "���ҥ���";            //�w�q�x�s�Ǧ^�Ȫ��r��ﹳ
    conn = getConn();                      //��o��ƨ�Ʈw�s��
    CallableStatement cs = null;            //�w�qCallableStatement�ﹳ
    String sql = "{call validateSelect('"+userName+"','"+passWord+"')}";    //�w�q�I�s�x�s�L�{�ԭz
    try {
        cs = conn.prepareCall(sql);         //�I�s�x�s�L�{
        ResultSet rest = cs.executeQuery(); //��o���G��
        while(rest.next()){                 //�`���ˬd���G���ﹳ
            message = "���Ҧ��\";            //�]�w�ﹳ��T   
        }            
    } catch (SQLException e) {          
        e.printStackTrace();
    }
    return message;                          //�Ǧ^String�ﹳ
}

}
