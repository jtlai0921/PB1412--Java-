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
    
    // �w�q�˵���ƨ�Ʈw���Ҧ���ƪ��k
    public List GetRs() {
        try {
            List list = new ArrayList();
            String[] tableType = { "TABLE" }; // ���w�n�i��d�ߪ����A
            Connection conn = Con(); // �I�s�P��ƨ�Ʈw�إ߳s����k
            DatabaseMetaData databaseMetaData = conn.getMetaData(); // ��oDatabaseMetaData���
            ResultSet resultSet = databaseMetaData.getTables(null, null, "%",
                    tableType);// ��o��ƨ�Ʈw���Ҧ���ƪ��X
            while (resultSet.next()) { // �ˬd���X
                String tableName = resultSet.getString("TABLE_NAME");
                list.add(tableName);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("�O���ƶq��o���ѡI");
            return null;
        }
    }
    
    public ResultSet GetRs(final String SQL) {
        try {
            Connection Con = Con(); // ��o��ƨ�Ʈw�s��
            Statement Smt = Con
                    .createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE); // ��oStatement�ﹳ
            ResultSet Rs = Smt.executeQuery(SQL); // ����d�߱ԭz�A��o�d�ߵ��G��
            return Rs;
        } catch (SQLException e) {
            System.out.println("�O���ƶq��o���ѡI");
            return null;
        }
    }
    
public List getMessage(String tableName) {
    List list = new ArrayList(); // �w�q�x�s�Ǧ^�Ȫ�List���X
    String SQL = " Select case when c.colid=1 then  o.name end ��W,"
            + " c.ColId �r�q�s��,c.name �r�q�W,c.length �r�q����,t.name �r�q���O�O,"
            + " p.value �y�z,case when c.isnullable=0 then '1' end �O�_����,"
            + " c.scale �p�Ʀ��,REPLACE (REPLACE (REPLACE (m.text,'(',''),')',''),'''','') �w�]��,"
            + " case when ("
            + " Select Count(*) From SysObjects where name in ("
            + " Select name From Sysindexes Where id=c.id and indid in ("
            + " Select indid From Sysindexkeys  where id=c.id and colid in ("
            + " Select colid From Syscolumns where id=c.id and colid=c.colid))) and xtype='pk')>0"
            + " then '1' end �O�_���D��"
            + " From Sysobjects o"
            + " left join Syscolumns c on o.id=c.id"
            + " left join Sysproperties p on o.id=p.id and c.colid=p.smallid"
            + " left join Systypes t on t.xtype=c.xtype"
            + " left join Syscomments m on m.id=c.cdefault"
            + " where (o.xtype='u' or o.xtype='v') and o.status>0 and o.name='"
            + tableName + "'" + " order by o.name,c.colid"; // �w�q�d��SQL�ԭz
    ResultSet res = GetRs(SQL);                 //�I�s����SQL�ԭz��k
    ResultSetMetaData Rsmd;                     //��oResultSetMetaData��k
    try {
        Rsmd = res.getMetaData();               //��Ҥ� ResultSetMetaData�ﹳ
        while (res.next()) {                    //�`���ˬd�d�ߵ��G��
            Student student = new Student();    //�إ߹���ƨ�Ʈw��H��JavaBean�ﹳ
            student.setId(res.getString("�r�q�s��"));       //�]�w�ﹳ�ݩ�
            student.setName(res.getString("�r�q�W"));
            student.setType(res.getString("�r�q���O�O"));
            student.setAcquiescence(res.getString("�w�]��"));
            student.setDepict(res.getString("�y�z"));
            student.setDigit(res.getString("�p�Ʀ��"));
            student.setLength(res.getString("�r�q����"));
            student.setIfNull(res.getString("�O�_����"));
            list.add(student);                  //�N�ﹳ�W�[��List���X��
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;            //�Ǧ^List���X
}
    
}
