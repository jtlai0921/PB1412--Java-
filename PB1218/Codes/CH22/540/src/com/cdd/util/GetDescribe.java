package com.cdd.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetDescribe {
    Connection conn = null;
    
    // ��o��ƨ�Ʈw�s��
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
    //�w�q��o�r�q���y�z��T��k

public List getDescribe(String tableName) {
    conn = getConn();           //��o��ƨ�Ʈw�s��
    List list = new ArrayList();    //�w�qList���X�ﹳ
    try {
        Statement stmt = conn.createStatement();    //��oStatement�ﹳ
        ResultSet rest = stmt
                .executeQuery("select c.name,b.value FROM sysobjects a,sysproperties b,syscolumns " +
                		"c where a.name='"+tableName+"' and a.id=b.id and b.id=c.id and b.smallid=c.colorder");   //����d�߱ԭz
        while(rest.next()){ //�`���ˬd�d�ߵ��G��
            Describe describe = new Describe(); //�w�q�w�q��JavaBean�ﹳ
            describe.setName(rest.getString(1));    //�]�w�ﹳ�ݩ�
            describe.setValue(rest.getString(2));   
            list.add(describe);             //�V���X���W�[�ﹳ
        }
    } catch (Exception e) {
        e.printStackTrace();
    } 
    return list;
}    
    
    //�D��k
    public static void main(String[] args) {
        GetDescribe getDescribe = new GetDescribe();
        List list = getDescribe.getDescribe("tb_book");
        System.out.println("��ƪ�tb_book���r�q�P�y�z��T���G");
        for(int i = 0;i<list.size();i++){
            Describe describe = (Describe)list.get(i);
            System.out.println("   �r�q���G"+describe.getName()+"  �y�z��T���G"+describe.getValue());
        }
    }
    
}
