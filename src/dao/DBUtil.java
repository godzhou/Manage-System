package dao;

import java.beans.Statement;
import java.sql.*;
import java.sql.DriverManager;

public class DBUtil {
	
	private static final String url = "jdbc:mysql://loaclhost:3306/managesystem";
	private static final String user = "root";
	private static final String password = "961203";
	
	private static Connection conn = null;
	
	
	public static Connection getConn(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException | SQLException e){
			System.out.println(e.toString());
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
