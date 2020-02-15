package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConditionUtil {
    Connection conn = null;    
    // ��o��ƨ�Ʈw�s��
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database21"; // �s����ƨ�ƮwURL
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
    //�b�d�ߵ��G�����h���r�ꤤ���Ů�     

public List getBookSell() {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select * from tb_book"; // �w�q�d�߹ϮѾP�������������
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            BookSell sell = new BookSell();     //�w�q�P��ƪ������JavaBean�ﹳ
            sell.setId(set.getInt(1));          //�]�w�ﹳ�ݩ�
            sell.setBookName(set.getString(2).replace(" ", ""));
            sell.setStock(set.getString(3).replace(" ", ""));
            sell.setPrice(set.getFloat(4));
            sell.setBookConcern(set.getString(5).replace(" ", ""));
            list.add(sell);                     //�N�ﹳ�W�[�춰�X��
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;                    //�Ǧ^�d�ߵ��G
}
    
}
