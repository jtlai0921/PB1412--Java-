package com.mingrisoft.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper implements DBConfig {
    
    public static void saveImage(String name, String type, File image) {
        FileInputStream in = null;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            in = new FileInputStream(image);// 利用image參數建立FileInputStream對像
            Class.forName(DRIVER);// 載入驅動程式
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 建立連接
            ps = conn.prepareStatement("insert into images values (?, ?, ?);");
            ps.setString(1, name);// 儲存圖片名稱
            ps.setString(2, type);// 儲存圖片型態
            ps.setBinaryStream(3, in, (int) image.length());// 儲存圖片
            ps.executeUpdate();// 執行儲存
        } catch (Exception e) {// 捕捉例外
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
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
