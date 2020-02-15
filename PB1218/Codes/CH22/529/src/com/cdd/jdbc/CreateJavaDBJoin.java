package com.cdd.jdbc;

import java.sql.*;
import java.io.*;

public class CreateJavaDBJoin {
    
    private static final String DRIVERCLASS = "org.apache.derby.jdbc.EmbeddedDriver"; // ��ƨ�Ʈw�X��
    private static final String URL = "jdbc:derby:db_database22";// ��ƨ�ƮwURL
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>(); // �إߥΨ��x�s��ƨ�Ʈw�s�����u�{
    private static Connection conn = null;// ��ƨ�Ʈw�s��
    
    static { // �z�L�R�A��k���J��ƨ�Ʈw�X�ʡA�åB�b��ƨ�Ʈw���s�b�����p�U�إ߸�ƨ�Ʈw
        try {
            Class.forName(DRIVERCLASS); // ���J��ƨ�Ʈw�X��
            System.out.println("��ƨ�Ʈw�X�ʸ��J���\�I�I");
            File albumF = new File("db_database22");// �إ߸�ƨ�Ʈw�ɮ׹ﹳ
            if (!albumF.exists()) {// �P�_��ƨ�Ʈw�ɮ׬O�_�s�b
                String[] sqls = new String[1];// �w�q�إ߸�ƨ�Ʈw��SQL�ԭz
                sqls[0] = "create table tb_album (name varchar(200) not null)";
            } else {
                conn = DriverManager.getConnection(URL + ";create=true");// �إ߸�ƨ�Ʈw�s��
                System.out.println("�w���\���PJavaDB��ƨ�Ʈw�إ߳s���I�I");
                threadLocal.set(conn);// �x�s��ƨ�Ʈw�s��
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected Connection getConnection() { // �إ߸�ƨ�Ʈw�s������k
        conn = (Connection) threadLocal.get(); // �q�u�{����o��ƨ�Ʈw�s��
        if (conn == null) { // �S���i�Ϊ���ƨ�Ʈw�s��
            try {
                conn = DriverManager.getConnection(URL);// �إ߷s����ƨ�Ʈw�s��
                threadLocal.set(conn); // �N��ƨ�Ʈw�s���x�s��u�{��
                
            } catch (Exception e) {
                String[] infos = { "���ন�\�s����ƨ�Ʈw�I", "�нT�{���n��O�_�w�g����I" };
                
                e.printStackTrace();
            }
        }
        
        return conn;
    }
    
    protected boolean closeConnection() { // ������ƨ�Ʈw�s������k
        boolean isClosed = true; // �w�]�������\
        conn = (Connection) threadLocal.get(); // �q�u�{����o��ƨ�Ʈw�s��
        threadLocal.set(null); // �M�Žu�{������ƨ�Ʈw�s��
        if (conn != null) { // ��ƨ�Ʈw�s���i��
            try {
                conn.close(); // ������ƨ�Ʈw�s��
            } catch (SQLException e) {
                isClosed = false; // ��������
                e.printStackTrace();
            }
        }
        return isClosed;
    }
    
    public static void main(String[] args) {
        CreateJavaDBJoin javaDBJoin = new CreateJavaDBJoin();
        javaDBJoin.getConnection();
    }
    
}
