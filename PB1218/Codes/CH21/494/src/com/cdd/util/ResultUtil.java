package com.cdd.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultUtil {
    // ��o��ƨ�Ʈw�s��
    private Connection conn;
    
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

public List getGradeDesc() {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select top 3 id ,name,english from tb_Grade order by english desc"; // �w�q�N�ϮѪ����T�i��ƧǪ�SQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            Grade grade = new Grade(); // �إߩ�ǲ����Z�������Grade�ﹳ
            grade.setId(set.getInt(1)); // �]�w�ﹳ�ݩ�
            grade.setName(set.getString(2));
            grade.setEnglish(set.getFloat(3));
            list.add(grade); // �NGrade�ﹳ�W�[�춰�X��
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^�d�߶��X
}
    
    public static void main(String[] args) {
        ResultUtil util = new ResultUtil();
        List list = util.getGradeDesc();
        System.out.println("�^�y���Z�Ʀb�e3���P�ǬO�G");
        for(int i = 0;i < list.size();i++){
            Grade grade = (Grade)list.get(i);
            System.out.println("�s���G"+grade.getId()+" �A�m�W�G"+grade.getName()+"  �A�^�y���Z�G"+grade.getEnglish());
        }
    }
    
}
