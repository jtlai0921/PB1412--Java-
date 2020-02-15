package com.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WareUtil {
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
    
public void insertWare(Ware ware) {
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        PreparedStatement statement = conn
                .prepareStatement("insert into tb_ware values(?,?,?,?,?,?,?)"); // �w�q���J��ƨ�Ʈw���w���B�z�ԭz
        statement.setString(1,ware.getSID() ); // �]�w�w���B�z�ԭz���Ѽƭ�
        statement.setString(2,ware.getsName());
        statement.setString(3, ware.getSpec());
        statement.setString(4,ware.getCasing());
        statement.setString(5,ware.getUnit() );
        statement.setString(6, ware.getsDate());
        statement.setInt(7, ware.getAmout());
        statement.executeUpdate(); // ����w���B�z�ԭz
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public List selectWare() {
        conn = getConn(); // ��o��ƨ�Ʈw�s��
        Statement statment;
        List list = new ArrayList<Ware>();
        try {
            statment = conn.createStatement(); // ��oStatement�ﹳ
            String sql = "select * from tb_ware"; // �w�q�d��SQL�ԭz
            ResultSet rest = statment.executeQuery(sql); // ����d�߱ԭz��o�d�ߵ��G��
            while (rest.next()) { // �`���ˬd�d�ߵ��G��
               Ware ware = new Ware();              //
               ware.setSID(rest.getString(1));
               ware.setsName(rest.getString(2));
               ware.setSpec(rest.getString(3));
               ware.setCasing(rest.getString(4));
               ware.setUnit(rest.getString(5));
               ware.setsDate(rest.getString(6));
               ware.setAmout(rest.getInt(7));
               list.add(ware);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // �Ǧ^�d�ߵ��G
    }
    public static String getDateTime(){     //�Ӥ�k�Ǧ^�Ȭ�String���A
        SimpleDateFormat format;
                            //simpleDateFormat���O�i�H��ܥ���ϥΪ̩w�q�����-�ɶ��榡���Ҧ�
        Date date = null; 
        Calendar myDate = Calendar.getInstance();
                            //Calendar����kgetInstance()�A�H��o�����A���@�ӳq�Ϊ���H
        myDate.setTime(new java.util.Date());
                            //�ϥΫ��w��Date�]�w��Calendar���ɶ�
        date = myDate.getTime();
                            //�Ǧ^�@�Ӫ�ܦ�Calendar�ɶ��ȡ]�q�����ܲ{�b���@�����q�^��Date�ﹳ
        format = new SimpleDateFormat("yyyy-MM-dd");
                            //���g�榡�Ʈɶ����u�~-��-�� �ɡG���G��v
        String strRtn = format.format(date);
                            //�N���w��Date�榡�Ƭ����/�ɶ��r��A�ñN���G�����ȵ����w��String
        return strRtn;          //�Ǧ^�x�s�Ǧ^���ܼ�
    }

   
}
