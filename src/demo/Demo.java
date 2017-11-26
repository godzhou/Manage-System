package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.ADUS;
import dao.DBUtil;

public class Demo {
	public static void main(String args[]){
		String Coursesql = "insert into course values(?,?,?,?)";
		Connection conn = DBUtil.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(Coursesql);
			for(int i=100;i<700;i++){
				ps.setString(1, "00000"+i);
				ps.setInt(2, i);
				ps.setString(3, "2017-2018Çï");
				ps.setString(4,"0000000001");
				
				ps.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
