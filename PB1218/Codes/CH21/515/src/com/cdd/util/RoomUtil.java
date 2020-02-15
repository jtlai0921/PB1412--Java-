package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomUtil {
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
    
public List getRoom() {
    List list = new ArrayList(); // �w�q�Ω��x�s�Ǧ^�Ȫ�List���X
    conn = getConn(); // ��o��ƨ�Ʈw�s��
    try {
        Statement staement = conn.createStatement();
        String sql = "select * from tb_room  where (not roomState = '�J��') and ( not roomType = '����')"; // �w�q�d�߸�ƪ�SQL�ԭz
        ResultSet set = staement.executeQuery(sql); // ����d�߱ԭz�Ǧ^�d�ߵ��G��
        while (set.next()) { // �`���ˬd�d�ߵ��G��
            Room room = new Room();
            room.setRoomDate(set.getString("roomDate"));
            room.setRoomFacility(set.getString("roomFacility"));
            room.setRoomid(set.getInt(1));
            room.setRoomPrice(set.getInt("roomPrice"));
            room.setRoomState(set.getString("roomState"));
            room.setRoomType(set.getString("roomType"));
            list.add(room);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // �Ǧ^List���X
}
    
    public static void main(String[] args) {
        RoomUtil util = new RoomUtil();
        List list = util.getRoom();
        System.out.println("�d�ߨS���J��������ȩСG");
        for(int i = 0;i<list.size();i++){
            Room room = (Room)list.get(i);
            System.out.println("�ж��� �G"+room.getRoomid()+" , ���A�G"+room.getRoomType()+" , ����G"+room.getRoomPrice()+
                    " , �˸m�G"+room.getRoomFacility()+" , ���A�G"+room.getRoomState());
        }
    }
}
