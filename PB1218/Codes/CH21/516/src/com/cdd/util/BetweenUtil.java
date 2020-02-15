package com.cdd.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BetweenUtil {
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
    
public List getGrade() {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select name,english from tb_Grade  where english  between 80 and 90"; // �w�q�d�߭^�妨�Z�b80��9�������ǥ͸�TSQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            Grade grade = new Grade(); // �إߩ�ǲ����Z�������Grade�ﹳ            
            grade.setName(set.getString(1));
            grade.setEnglish(set.getFloat(2));
            list.add(grade); // �NGrade�ﹳ�W�[�춰�X��
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^�d�߶��X
}    
    
    public static void main(String[] args) {
       BetweenUtil util = new BetweenUtil();
       List list = util.getGrade();
       System.out.println("�d�߭^�y���Z�b80�P90�������ǥ͡G");
       for(int i = 0;i<list.size();i++){
           Grade grade = (Grade)list.get(i);
           System.out.println("�m�W�G"+grade.getName()+" �A�^�y���Z�G"+grade.getEnglish());
       }
    }
    
}
