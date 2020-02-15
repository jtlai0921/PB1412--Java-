package com.cdd.patindex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreatePatindex {
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

public List getPatindex(String address) {
    conn = getConn(); // ��o�P��ƨ�Ʈw���s��
    ResultSet rest;
    List list = new ArrayList<Order>();
    try {
        Statement statement = conn.createStatement(); // ��oStatement�ﹳ
        String sql = "select * from tb_order where patindex('" + address
                + "%',address)>0"; // �w�q�d�߱ԭz
        rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
        while (rest.next()) {           //�`���ˬd�d�ߵ��G��
            Order order = new Order();      //�w�q�P��ƪ������JavaBean�ﹳ
            order.setId(rest.getInt(1));        //�]�w�ﹳ�ݩ�
            order.setName(rest.getString(2));
            order.setAddress(rest.getString(3));
            order.setPhone(rest.getString(4));
            list.add(order);
        }
        return list; // �Ǧ^�d�ߵ��G
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    
}
