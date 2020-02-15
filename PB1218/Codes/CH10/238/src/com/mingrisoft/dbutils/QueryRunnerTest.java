package com.mingrisoft.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

public class QueryRunnerTest {
    // �w�qJDBC�����Ѽ�
    private static String URL = "jdbc:mysql://localhost:3306/db_database18";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USERNAME = "root";
    private static String PASSWORD = "111";
    private static Connection conn;
    
    public static Connection getConnection() {// �Ω���o��ƨ�Ʈw�s�����u���k
        try {
            DbUtils.loadDriver(DRIVER);// ���J�X��
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);// �إ߳s��
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static int operate(String sql, Object... params) {// �Ω���榳�Ѽƪ�SQL�ԭz
        int result = 0;
        QueryRunner runner = new QueryRunner();
        try {
            result = runner.update(getConnection(), sql, params);// ����SQL�ԭz
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);// �����s��
        }
        return result;
    }
    
    public static void main(String[] args) {
        String sql = "insert into users(username, password) values (?, ?)";
        Object[] params = { "mrsoft", "Java" };
        operate(sql, params);// �V��ƨ�Ʈw�����J�@�����
    }
}
