package com.order.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConn {
    
    Connection conn = null;    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // ���JMySQL��ƨ�Ʈw�X��
            String url = "jdbc:mysql://localhost:3306/db_database21"; // �w�q�P�s����ƨ�Ʈw��url
            String user = "root"; // �w�q�s����ƨ�Ʈw���ϥΪ̦W��
            String passWord = "111"; // �w�q�s����ƨ�Ʈw���K�X
            conn = DriverManager.getConnection(url, user, passWord); // �s���s��
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }    
    // �w�q�����w�����w���󭰧Ǭd�߸�Ƥ�k    
    public List getOrderDesc() {
        List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
        conn = getConnection(); // ��o��ƨ�Ʈw�s��
        try {
            Statement staement = conn.createStatement();
            String sql = "select id,name,sex,className,chinese from tb_student order by chinese limit 0,3"; // �w�q�d�߸�ƪ���3���O����SQL�ԭz
            ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
            while (set.next()) { // �`���ˬd�d�ߵ��G��
                Student student = new Student(); // �w�q�P��ƨ�Ʈw������JavaBean�ﹳ
                student.setId(set.getInt(1)); // �]�w�ﹳ�ݩʭ�
                student.setName(set.getString("name"));
                student.setSex(set.getString("sex"));
                student.setClassName(set.getString("className"));
                student.setChinese(set.getFloat("chinese"));
                list.add(student); // �NJavaBean�W�[�춰�X��
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        MySQLConn mySqlConn = new MySQLConn();
        List list = mySqlConn.getOrderDesc();
        System.out.println("�d�߻y�妨�Z�Ʀb��3�W���P�Ǹ�T�G");
        for (int i = 0; i < list.size(); i++) {
            Student student = (Student) list.get(i);
            System.out.println("�s�����G" + student.getId() + "�A�m�W�G"
                    + student.getName() + "�A�ʧO�G" + student.getSex() + "�A�y�妨�Z�G"
                    + student.getChinese());
        }
    }
}
