package com.mingrisoft.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class DBHelper implements DBConfig {
    
    private static Connection conn;
    private static Statement stat;
    private static ResultSet rs;
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Statement openStatement() {
        try {
            stat = getConnection().createStatement();
            return stat;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static int update(String sql) {
        int result = 0;
        try {
            result = openStatement().executeUpdate(sql);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result;
    }
    
    public static List<Object[]> query(String sql) {
        List<Object[]> result = new ArrayList<Object[]>();
        try {
            rs = openStatement().executeQuery(sql);
            String[] columnNames = getColumnNames(sql);
            Object[] columnContent;
            while (rs.next()) {
                columnContent = new Object[columnNames.length];
                for (int i = 0; i < columnNames.length; i++) {
                    columnContent[i] = rs.getObject(columnNames[i]);
                }
                result.add(columnContent);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result;
    }
    
    public static String[] getColumnNames(String sql) {
        String[] columnNames = null;
        try {
            rs = getConnection().createStatement().executeQuery(sql);
            ResultSetMetaData data = rs.getMetaData();
            int columnCount = data.getColumnCount();
            columnNames = new String[columnCount];
            for (int i = 0; i < columnNames.length; i++) {
                columnNames[i] = data.getColumnName(i + 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnNames;
    }
    
    public static Image getImage(String sql, String columnLabel) {
        Image image = null;
        try {
            rs = getConnection().createStatement().executeQuery(sql);// 獲得結果集
            rs.next();// 將結果集游標指向第一條記錄
            InputStream in = rs.getBinaryStream(columnLabel);
            BufferedImage bi = ImageIO.read(in);
            ImageProducer ip = bi.getSource();
            Toolkit tk = Toolkit.getDefaultToolkit();
            image = tk.createImage(ip);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    
    private static void close() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
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
