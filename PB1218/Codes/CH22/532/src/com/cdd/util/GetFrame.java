package com.cdd.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetFrame {
    public Connection Con() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection Con = DriverManager
                    .getConnection(
                            "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database21",
                            "sa", "1");
            return Con;
        } catch (Exception e) {
            return null;
        }
    }
    
    // 定義檢視資料函數庫中所有資料表方法
    public List GetRs() {
        try {
            List list = new ArrayList();
            String[] tableType = { "TABLE" }; // 指定要進行查詢的表型態
            Connection conn = Con(); // 呼叫與資料函數庫建立連接方法
            DatabaseMetaData databaseMetaData = conn.getMetaData(); // 獲得DatabaseMetaData實例
            ResultSet resultSet = databaseMetaData.getTables(null, null, "%",
                    tableType);// 獲得資料函數庫中所有資料表集合
            while (resultSet.next()) { // 檢查集合
                String tableName = resultSet.getString("TABLE_NAME");
                list.add(tableName);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("記錄數量獲得失敗！");
            return null;
        }
    }
    
    public ResultSet GetRs(final String SQL) {
        try {
            Connection Con = Con(); // 獲得資料函數庫連接
            Statement Smt = Con
                    .createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE); // 獲得Statement對像
            ResultSet Rs = Smt.executeQuery(SQL); // 執行查詢敘述，獲得查詢結果集
            return Rs;
        } catch (SQLException e) {
            System.out.println("記錄數量獲得失敗！");
            return null;
        }
    }
    
public List getMessage(String tableName) {
    List list = new ArrayList(); // 定義儲存傳回值的List集合
    String SQL = " Select case when c.colid=1 then  o.name end 表名,"
            + " c.ColId 字段編號,c.name 字段名,c.length 字段長度,t.name 字段類別別,"
            + " p.value 描述,case when c.isnullable=0 then '1' end 是否為空,"
            + " c.scale 小數位數,REPLACE (REPLACE (REPLACE (m.text,'(',''),')',''),'''','') 預設值,"
            + " case when ("
            + " Select Count(*) From SysObjects where name in ("
            + " Select name From Sysindexes Where id=c.id and indid in ("
            + " Select indid From Sysindexkeys  where id=c.id and colid in ("
            + " Select colid From Syscolumns where id=c.id and colid=c.colid))) and xtype='pk')>0"
            + " then '1' end 是否為主鍵"
            + " From Sysobjects o"
            + " left join Syscolumns c on o.id=c.id"
            + " left join Sysproperties p on o.id=p.id and c.colid=p.smallid"
            + " left join Systypes t on t.xtype=c.xtype"
            + " left join Syscomments m on m.id=c.cdefault"
            + " where (o.xtype='u' or o.xtype='v') and o.status>0 and o.name='"
            + tableName + "'" + " order by o.name,c.colid"; // 定義查詢SQL敘述
    ResultSet res = GetRs(SQL);                 //呼叫執行SQL敘述方法
    ResultSetMetaData Rsmd;                     //獲得ResultSetMetaData方法
    try {
        Rsmd = res.getMetaData();               //實例化 ResultSetMetaData對像
        while (res.next()) {                    //循環檢查查詢結果集
            Student student = new Student();    //建立對於資料函數庫對象的JavaBean對像
            student.setId(res.getString("字段編號"));       //設定對像屬性
            student.setName(res.getString("字段名"));
            student.setType(res.getString("字段類別別"));
            student.setAcquiescence(res.getString("預設值"));
            student.setDepict(res.getString("描述"));
            student.setDigit(res.getString("小數位數"));
            student.setLength(res.getString("字段長度"));
            student.setIfNull(res.getString("是否為空"));
            list.add(student);                  //將對像增加到List集合中
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;            //傳回List集合
}
    
}
