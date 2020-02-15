package com.mingrisoft.exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExceptionTest {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/db_database";// MySQL��ƨ�Ʈw��URL
        String DRIVER = "com.mysql.jdbc.Driver";// MySQL��ƨ�Ʈw���X��
        String USERNAME = "mr";// ��ƨ�Ʈw���ϥΪ̦W��
        Connection connection = null;
        try {
            Class.forName(DRIVER);// ���J�X��
            connection = DriverManager.getConnection(URL, USERNAME, "");// �إ߳s��
        } catch (SQLException e) {// ����SQLException
            e.printStackTrace();
        } catch (ClassNotFoundException e) {// ����ClassNotFoundException
            e.printStackTrace();
        } finally {
            try {
                connection.close();// ����귽
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
