package com.cdd.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class BccdSell {
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
    
public List getBccdSell() {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
   
    try {
        Statement staement = conn.createStatement();
        String sql = "select * from tb_bccdSell where bccdDate > '2010/6/1' and bccdDate < '2010/6/30'"; // �d�ߺ�������SQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
          Bccd bccd = new Bccd();
          bccd.setId(set.getInt(1));
          bccd.setBccdName(set.getString("bccdName"));
          bccd.setBccdCount(set.getInt("bccdCount"));
          bccd.setBccdPrice(set.getFloat("bccdPrice"));
          bccd.setBccdDate(set.getString("bccdDate"));
          list.add(bccd);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^List���X
}
    
    public static void main(String[] args) {
        BccdSell sell = new BccdSell();
        List list = sell.getBccdSell();
        System.out.println("6������P��O���������T�G");
        for(int i = 0;i<list.size();i++){
            Bccd bccd = (Bccd)list.get(i);
            System.out.println("����G"+bccd.getBccdName()+" �A�P�q�G"+bccd.getBccdCount()+" ,����G"+bccd.getBccdPrice()+" ,����G"+bccd.getBccdDate());
        }
    }
}
