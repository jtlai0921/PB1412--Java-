package com.cdd.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClearUtil {
    // ��o��ƨ�Ʈw�s��
    private Connection conn;
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // ���J��ƨ�Ʈw�X��
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database22"; // �s����ƨ�ƮwURL
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

public void deleteDate(String dataName){
    conn = getConn();   //��o��ƨ�Ʈw�s��
    try {
        Statement statement = conn.createStatement();   //��oStatement�ﹳ
        statement.executeUpdate("TRUNCATE TABLE  "+dataName);               //���w�R���ԭz
    } catch (Exception e) {       
        e.printStackTrace();
    }
    
}
    //�w�q�d�߸�ƨ�Ʈw���Ҧ���ƪ��k
    public List GetRs() {
        List list = new ArrayList<String>();
        try {            
            String[] tableType = { "TABLE" }; // ���w�n�i��d�ߪ����A
            Connection conn = getConn(); // �I�s�P��ƨ�Ʈw�إ߳s����k
            DatabaseMetaData databaseMetaData = conn.getMetaData(); // ��oDatabaseMetaData���
            ResultSet resultSet = databaseMetaData.getTables(null, null, "%",
                    tableType);// ��o��ƨ�Ʈw���Ҧ���ƪ��X
            while(resultSet.next()){
                String tableName = resultSet.getString("TABLE_NAME");
                list.add(tableName);
            }          
        } catch (SQLException e) {
            System.out.println("�O���ƶq��o���ѡI");
          
        }
        return list;
    }
    
    public static void main(String[] args) {
        ClearUtil util = new ClearUtil();
        util.deleteDate("tb_empess");
    }
    
}
