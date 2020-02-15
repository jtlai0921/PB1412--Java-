package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookSellUtil {
    
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
    
    public int getMAXOrder() {
        List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        int count = 0;
        try {
            Statement staement = conn.createStatement();
            String sql = "select count(bookName) as bookType from tb_bookSell where total >400"; // �d�ߤ�P���B�b400�H�W���ϮѺ����O
            ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
            while (set.next()) { // �`���ˬd�d�ߵ��G��
                count = set.getInt("bookType");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count; // �Ǧ^List���X
    }
    
    public static void main(String[] args) {
        BookSellUtil util = new BookSellUtil();
        int count = util.getMAXOrder();
        System.out.println("��P���B�W�L400���ϮѺ����O���G" + count + "��");
    }
}
