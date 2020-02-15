package com.mingrisoft.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper implements DBConfig {
    
    public static void saveImage(String name, String type, File image) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(DRIVER);// ���J�X��
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// �إ߳s��
            ps = conn.prepareStatement("insert into picture values (?, ?, ?);");
            ps.setString(1, name);// �x�s�Ϥ��W��
            ps.setString(2, type);// �x�s�Ϥ����A
            ps.setString(3, image.getAbsolutePath());// �x�s�Ϥ���������|
            ps.executeUpdate();// �����x�s
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
