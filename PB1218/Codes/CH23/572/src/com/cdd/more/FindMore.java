package com.cdd.more;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class FindMore {
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

public ResultSet getMore() {
    conn = getConn(); // ��o�P��ƨ�Ʈw���s��
    ResultSet rest;       
    try {
        Statement statement = conn.createStatement(); // ��oStatement�ﹳ
        String sql = "select p.id,p.sName,w.wId,w.wage,l.pID,l.monthL,l.lDate,l.lMoney from (tb_personnel p left join tb_wage w on p.id = w.perId)" +
        		" left join tb_leave l on l.pID = p.id"; // �w�q�d�߱ԭz
        rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��           
        return rest; // �Ǧ^�d�ߵ��G
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    public static void main(String[] args) {
        FindMore findMore = new FindMore();
        ResultSet rest = findMore.getMore();
        try {
            System.out.println("�ϥΥ~�s���i��h��d��");
            while(rest.next()){
                int id = rest.getInt(1);
                String sName = rest.getString(2);
                String wId = rest.getString(3);
                float wage = rest.getFloat("wage");
                String pID = rest.getString("pID");
                int mothl = rest.getInt("monthL");
                float dateL = rest.getFloat("lDate");
                float lMoney = rest.getFloat("lMoney");
                System.out.println("�s���G"+id+" �m�W�G"+sName+" �~���s���G"+wId+" �~���G"+wage+" �а��s���G"+pID+" �а�����G"
                        +mothl+" �а��ѼơG"+dateL+" �����~���G"+lMoney);
                
            }
        } catch (SQLException e) {           
            e.printStackTrace();
        }
    }
}
