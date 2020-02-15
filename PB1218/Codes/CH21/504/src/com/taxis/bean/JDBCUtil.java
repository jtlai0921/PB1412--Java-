package com.taxis.bean;

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
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // �Ǧ^Connection�ﹳ
    }
    
    // �w�q�����w�����w���󭰧Ǭd�߸�Ƥ�k
    
public ResultSet getBooKDesc() {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    ResultSet set = null;
    try {
        Statement staement = conn.createStatement();
        String sql = "select cargoId,cargoName,cargoCount,sum(sellCount)as count "
                + " from tb_cargo,tb_sell where cargoId = sellId group by sellId,cargoName,cargoId,cargoCount"; // �w�q�d�߸�ƨ�Ʈw��SQL�ԭz
        set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��            
    } catch (Exception e) {
        e.printStackTrace();
    }
    return set;
}
    public static void main(String[] args) {
        JDBCUtil util = new JDBCUtil();
        ResultSet set = util.getBooKDesc();
        try {
            System.out.println("���P��O�����ӫ~�i�f�ƻP�P�q�G");
            while(set.next()){
                String cargoId = set.getString("cargoId");
                String cargoName = set.getString("cargoName");
                int cargoCont = set.getInt("cargoCount");
                int count = set.getInt("count");
                System.out.println("�s���G"+cargoId+"   �W�١G"+cargoName+"   �i�f�ơG"+cargoCont+"   �P�q�G"+count);
            }
        } catch (SQLException e) {         
            e.printStackTrace();
        }
    }
}
