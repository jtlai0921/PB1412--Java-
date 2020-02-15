package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderFormUtil {
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
    
public List getMAXOrder() {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select clientName,clientArea,clientMoney,visePerson from tb_orderForm " +
        		"where clientMoney = (select max(clientMoney) from tb_orderForm)"; // �w�q�d��ñ�q���q����B�̤j����T
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            OrderForm orderForm = new OrderForm();
            orderForm.setClientArea(set.getString("clientArea"));
            orderForm.setVisePerson(set.getString("visePerson"));
            orderForm.setClientMoney(set.getFloat("clientMoney"));
            orderForm.setClientName(set.getString("clientName"));
            list.add(orderForm);        
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;        //�Ǧ^List���X
}
    public static void main(String[] args) {
        OrderFormUtil util = new OrderFormUtil();
        List list = util.getMAXOrder();
        System.out.println("�d��ñ�q�q��̦h���Ȥ��T�G");
        for(int i = 0;i<list.size();i++){
            OrderForm orderForm = (OrderForm)list.get(i);
            System.out.println("�Ȥ�Ҧb�a�ϡG"+orderForm.getClientArea()+" ,�Ȥ�G"+orderForm.getClientName()+" �A���B�G"+orderForm.getClientMoney()
                    +" �Añ���H�G"+orderForm.getVisePerson());
        }
    }
}
