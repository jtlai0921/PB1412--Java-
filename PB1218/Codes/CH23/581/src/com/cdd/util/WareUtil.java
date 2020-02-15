package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WareUtil {
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
    public List getWare() {
        conn = getConn(); // ��o�P��ƨ�Ʈw���s��
        ResultSet rest;
        List list = new ArrayList();
        try {
            Statement statement = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select id,wName,price,convert(varchar(30),price/(select sum(price) from tb_ware) * 100)+'%' as percente from tb_ware"; // �w�q�d�߱ԭz
            rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                Ware ware = new Ware(); // �w�q�P��ƪ������JavaBean�ﹳ
                ware.setId(rest.getInt(1)); // �]�w�ﹳ�ݩ�
                ware.setwName(rest.getString(2));
                ware.setPrice(rest.getFloat(3));
                ware.setPercent(rest.getString(4));
                list.add(ware); // �����X���W�[�ﹳ
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^���X
    }
}
