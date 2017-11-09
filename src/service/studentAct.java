package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import dao.*;

public class studentAct {

	//检查用户是否存在
	public boolean isExists(String studentID) throws SQLException, ClassNotFoundException{
		String sql = "select * from student where studentID=\"" + studentID+"\";";
		ResultSet rs = ADUS.selectData(sql);
		if(rs.next()){
			return true;
		}
		return false;
	}
	
	//查询学生姓名--->虽然这已经不算学生操作了，但还是先放在这里面吧
	public String getStuName(String studentID) throws SQLException,ClassNotFoundException{
		String sql = "select studentName from student where studentID=\"" + studentID + "\";";
		ResultSet rs = ADUS.selectData(sql);
		rs.next();
		return rs.getString("studentName");
	}
	
	//验证用户名与密码是否正确
	public boolean studentLogin(String id,String password) throws SQLException, ClassNotFoundException{
		if(isExists(id)){
			String sql = "select * from student where studentID="+id+" and studentPW=\""+password+"\";";
			ResultSet rs = ADUS.selectData(sql);
			if(rs.next()){
				return true;
			}
		}
		return false;
	}
	
	//查询学生成绩信息并显示
/*	select courseName,courseTrem,teacher.name,scoreNum 
	from score,course,teacher 
	where score.studentID="2015220204003" and course.courseID=score.courseID and course.teacherID=teacher.teacherID;*/
	public String selectStuInfo(String id) throws SQLException, ClassNotFoundException{
		int count = 0;
		Map<String, List<String>> map = new HashMap<String,List<String>>();
		String sql = "select courseName,courseTrem,teacher.name,scoreNum " +
				"from score,course,teacher " +
				"where score.studentID=\""+id+"\" and course.courseID=score.courseID and course.teacherID=teacher.teacherID;";
		ResultSet rs = ADUS.selectData(sql);
		while(rs.next()){
			count++;
			List<String> als = new ArrayList<String>();
			als.add(rs.getString(1));
			als.add(rs.getString(2));
			als.add(rs.getString(3));
			als.add(rs.getString(4));
			
			map.put(Integer.toString(count), als);
		}
		DBUtil.closeConn();
		
		JSONArray json = JSONArray.fromObject(map);
		System.out.println(json.toString());
		return json.toString();	
	}
	
	/**
	 * 学生修改信息的操作，能够进行修改的有生日，年龄（以后改成自动计算），密码
	 */
	//在输入端对日期进行格式化
	public boolean modifyStuBirth(String studentID,String date) throws SQLException,ClassNotFoundException{
		String sql = "update student set birthday=\"" + date + "\" where studentID=\"" + studentID + "\";";
		if(ADUS.updateData(sql) == 0){
			return true;
		}
		return false;
	}
	
	/*
	 * 修改密码操作
	 * 
	 */
	public boolean modifyStuPW(String studentID,String newpw) throws SQLException,ClassNotFoundException{
		String sql = "update student set studentPW=\"" + newpw + "\" where studentID=\"" + studentID + "\";";
		if(ADUS.updateData(sql) != 0){
			return true;
		}
		return false;
	}
	
}
