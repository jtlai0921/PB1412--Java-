package com.cdd.gain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GainProcedure {
    
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
    
    // �w�q��o��ƨ�Ʈw���Ҧ��x�s�L�{��k

public List executeGain() {
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    Statement cs = null; 
    String sql = "select name from sysobjects where xtype = 'p' and status > 0"; // �w�q�I�s�w�x�{�Ǫ�SQL�ԭz
    List list = new ArrayList(); // �w�q�Ω�Ǧ^�Ȫ����X�ﹳ
    try {
        cs = conn.createStatement();
        ResultSet rest = cs.executeQuery(sql); // ����SQL�ԭz
        while (rest.next()) { // �`���ˬd�d�ߵ��G��
            String name = rest.getString(1);    //��o�d�ߵ��G�������
            list.add(name);             //�N��ƼW�[�춰�X��
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;            //�Ǧ^�d�ߵ��G��
}
    
  
}
