package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 封装对数据库的各种操作
 */
public class ADUS {
	
	//数据库的查询操作
	public static ResultSet selectData(String sql) throws SQLException,ClassNotFoundException{
		Connection conn = DBUtil.getConn();
		System.out.println(sql);
		ResultSet resultset = null;
		Statement stmt = conn.createStatement();
		resultset = stmt.executeQuery(sql);
		conn.close();
		return resultset;
	}
	
	//数据库的插入操作
	public static int insertData(String sql) throws SQLException,ClassNotFoundException{
		Connection conn = DBUtil.getConn();
		Statement stmt = conn.createStatement();
		int count = stmt.executeUpdate(sql);
		conn.close();
		return count;
	}
	
	//数据库的修改操作
	public static int updateData(String sql) throws SQLException,ClassNotFoundException{
		Connection conn = DBUtil.getConn();
		Statement stmt = conn.createStatement();
		int count = stmt.executeUpdate(sql);
		conn.close();
		return count;
	}
	
	//数据库的删除操作
	public static int deleteData(String sql) throws SQLException,ClassNotFoundException{
		Connection conn = DBUtil.getConn();
		Statement stmt = conn.createStatement();
		int count = stmt.executeUpdate(sql);
		conn.close();
		return count;
	}
}
