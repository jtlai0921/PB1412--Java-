package com.cdd.Descartes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class GetDescartes {
    
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
    
    // ��o�åd�����n��k

public List getDescsrtes() {
    List list = new ArrayList<MrEmp>();
    conn = getConn(); // ��o�P��ƨ�Ʈw���s��
    try {
        Statement statement = conn.createStatement(); // ��oStatement�ﹳ
        String sql = "select tb_mrdept.*,tb_mremp.name,tb_mremp.sex,tb_mremp.schoolAge from tb_mrdept cross join tb_mremp"; // �w�q�d�߱ԭz
        ResultSet rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
        while (rest.next()) { // �`���ˬd�d�ߵ��G��
            MrEmp mrEmp = new MrEmp();      //�w�q�P�d�ߵ��G��������JavaBean�ﹳ
            mrEmp.setId(rest.getInt(1));    //�]�w�ﹳ�ݩ�
            mrEmp.setdName(rest.getString(2));
            mrEmp.setName(rest.getString(4));
            mrEmp.setPerson(rest.getString(3));
            mrEmp.setSex(rest.getString(5));
            mrEmp.setSchoolAge(rest.getString(6));
            list.add(mrEmp);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^�d�ߵ��G
}
    
    public static void main(String[] args) {
        GetDescartes descartes = new GetDescartes();
        List list = descartes.getDescsrtes();
        System.out.println("�åd�����n�d�ߡG");
        for (int i = 0; i < list.size(); i++) {
            MrEmp mrEmp = (MrEmp) list.get(i);
            System.out.println("�s���G"+mrEmp.getId()+" �����W�١G"+mrEmp.getdName()+"�@�t�d�H�G"+mrEmp.getPerson()+" ���u�m�W�G"+mrEmp.getName()+
                    " ���u�ʧO�G"+mrEmp.getSex()+" �Ǿ��G"+mrEmp.getSchoolAge());
        }
    }
    
}
