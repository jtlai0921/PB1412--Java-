package com.mingrisoft.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
    
    public static List<User> query(String sql) {// �ΨӱN�d�ߵ��G�ഫ��bean�C���u���k
        QueryRunner qr = new QueryRunner();
        List<User> list = null;
        try {
            list = qr.query(getConnection(), sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);// �����s��
        }
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println("��users����������Ʀp�U�G");
        List<User> list = query("select * from users");// �d��users���������
        for (User user : list) {
            System.out.println(user);
        }
    }
}
