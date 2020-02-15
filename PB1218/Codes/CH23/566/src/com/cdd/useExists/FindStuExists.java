package com.cdd.useExists;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FindStuExists {

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

public List getMessageEmp() {
    conn = getConn(); // ��o�P��ƨ�Ʈw���s��
    List list = new ArrayList();
    try {
        Statement statement = conn.createStatement(); // ��oStatement�ﹳ
        String sql = "select * from tb_student s where exists (select name from tb_grade g where chinese >=90 and s.name = g.name)"; // �w�q�d�߱ԭz
        ResultSet rest = statement.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
        while(rest.next()){
            Student student = new Student();    //�w�q�P��ƪ������JavaBean�ﹳ
            student.setId(rest.getInt(1));      //�]�w�ﹳ�ݩ�
            student.setName(rest.getString(2));
            student.setCollege(rest.getString(3));
            student.setSpeciality(rest.getString(4));
            student.setAddress(rest.getString(5));
            list.add(student);              //�V���X���W�[�ﹳ
        }   
        return list; // �Ǧ^�d�ߵ��G
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        FindStuExists stuExists = new FindStuExists();
        List list = stuExists.getMessageEmp();
        System.out.println("�Q��EXISTS�d�߻y�妨�Z�j��90�����ǲ߸�T�G");
        for(int i = 0;i<list.size();i++){
            Student student  = (Student)list.get(i);
            System.out.println("�s���G"+student.getId()+" �m�W�G"+student.getName()+
                    "  �ǰ|���G"+student.getCollege()+"  �M�~�G"+student.getSpeciality()+
                    " �a�}�G"+student.getAddress());
        }
        
    }
    
}
