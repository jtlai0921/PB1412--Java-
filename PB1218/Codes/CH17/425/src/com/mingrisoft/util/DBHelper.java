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
            Class.forName(DRIVER);// 載入驅動
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 建立連接
            ps = conn.prepareStatement("insert into picture values (?, ?, ?);");
            ps.setString(1, name);// 儲存圖片名稱
            ps.setString(2, type);// 儲存圖片型態
            ps.setString(3, image.getAbsolutePath());// 儲存圖片的絕對路徑
            ps.executeUpdate();// 執行儲存
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