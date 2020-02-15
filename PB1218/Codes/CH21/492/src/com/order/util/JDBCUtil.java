package com.order.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {
    
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
                System.out.println("��ƨ�Ʈw�s�����\�I");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // �Ǧ^Connection�ﹳ
    }
    
    // �d�߹ϮѪ���Ҧ��O����k
    
    public List getBook() {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        List list = new ArrayList(); // �w�q�x�s�Ǧ^�Ȫ�List�ﹳ
        try {
            Statement staement = conn.createStatement(); // �w�qStatement�ﹳ
            String sql = "select * from tb_book"; // �w�q�d�ߪ�SQL�ԭz
            ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�A�Ǧ^�d�ߵ��G��
            while (set.next()) { // �`���ˬd�d�ߵ��G��
                Book book = new Book(); // �w�q�P��ƪ������JavaBean�ﹳ
                book.setId(set.getInt(1)); // �]�w��H��id��
                book.setBookName(set.getString(2));
                book.setAuthor(set.getString("author"));
                book.setPrice(set.getFloat("price"));
                book.setStock(set.getInt("stock"));
                list.add(book); // �V���X���W�[�ﹳ
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^�d�ߵ��G
    }
    
    // �w�q�����w�����w���󭰧Ǭd�߸�Ƥ�k
    
public List getBooKDesc(String term , String compositor) {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select * from tb_book order by price "+ term +", stock "+ compositor; // �w�q�N�ϮѪ����T�i��ƧǪ�SQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            Book book = new Book();
            book.setId(set.getInt(1));
            book.setBookName(set.getString(2));
            book.setAuthor(set.getString("author"));
            book.setPrice(set.getFloat("price"));
            book.setStock(set.getInt("stock"));
            list.add(book);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}   
   
}
