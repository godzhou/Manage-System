package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��װ�����ݿ�ĸ��ֲ���
 */
public class ADUS {
	
	//���ݿ�Ĳ�ѯ����
	public static ResultSet selectData(String sql) throws SQLException,ClassNotFoundException{
		Connection conn = DBUtil.getConn();
		System.out.println(sql);
		ResultSet resultset = null;
		Statement stmt = conn.createStatement();
		resultset = stmt.executeQuery(sql);
		conn.close();
		return resultset;
	}
	
	//���ݿ�Ĳ������
	public static int insertData(String sql) throws SQLException,ClassNotFoundException{
		Connection conn = DBUtil.getConn();
		Statement stmt = conn.createStatement();
		int count = stmt.executeUpdate(sql);
		conn.close();
		return count;
	}
	
	//���ݿ���޸Ĳ���
	public static int updateData(String sql) throws SQLException,ClassNotFoundException{
		Connection conn = DBUtil.getConn();
		Statement stmt = conn.createStatement();
		int count = stmt.executeUpdate(sql);
		conn.close();
		return count;
	}
	
	//���ݿ��ɾ������
	public static int deleteData(String sql) throws SQLException,ClassNotFoundException{
		Connection conn = DBUtil.getConn();
		Statement stmt = conn.createStatement();
		int count = stmt.executeUpdate(sql);
		conn.close();
		return count;
	}
}
