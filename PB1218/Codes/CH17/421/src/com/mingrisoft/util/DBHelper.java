package com.mingrisoft.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    
    public static int insertData(String tableName, String[] columns) {
        StringBuilder sql = new StringBuilder();
        String[] columnNames = getColumnNames("select * from " + tableName);
        int placeHolderCount = columnNames.length;
        sql.append("insert into " + tableName + " (");
        for (int i = 1; i < placeHolderCount; i++) {
            sql.append(" " + columnNames[i] + ", ");
        }
        sql.delete(sql.length() - 2, sql.length());
        sql.append(") values ( ");
        for (int i = 1; i < placeHolderCount; i++) {
            sql.append("'" + columns[i] + "', ");
        }
        sql.delete(sql.length() - 2, sql.length());
        sql.append(" )");
        
        return update(sql.toString());
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
    
    public static List<Object> getTableNames() {
        List<Object> list = new ArrayList<Object>();
        try {
            DatabaseMetaData dmd = getConnection().getMetaData();
            rs = dmd.getTables(null, null, null, new String[] { "TABLE" });
            while (rs.next()) {
                list.add(rs.getString(3));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
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