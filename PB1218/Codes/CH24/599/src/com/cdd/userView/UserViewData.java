package com.cdd.userView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserViewData {
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
    
    // �q�˵����˯����
    
    public List selectView() {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        Statement cs = null; // �w�qCallableStatement�ﹳ
        String sql = "Select * from v_ware"; // �w�q�d���˵���SQL�ԭz
        List list = new ArrayList(); // �w�q�x�s�d�ߵ��G��List���X
        try {
            cs = conn.createStatement(); // ��Ҥ�Statement�ﹳ
            ResultSet rest = cs.executeQuery(sql); // ����SQL�ԭz
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
                Ware ware = new Ware();
                ware.setwName(rest.getString(1));
                ware.setProfit(rest.getString(2));
                list.add(ware);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
