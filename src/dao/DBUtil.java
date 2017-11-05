package dao;

import java.beans.Statement;
import java.sql.*;
import java.sql.DriverManager;

public class DBUtil {
	
	private static final String url = "jdbc:mysql://localhost:3306/managesystem?useUnicode=true&characterEncoding=utf8";
	private static final String user = "root";
	private static final String password = "961203";
	
	private static Connection conn = null;
	
	
	public static Connection getConn(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static boolean closeConn(){
		try{
			conn.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
}
