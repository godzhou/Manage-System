package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.*;

public class studentAct {

	//����û��Ƿ����
	public boolean isExists(String studentID) throws SQLException{
		String sql = "select* from table student where studentID=" + studentID;
		ResultSet rs = ADUS.selectData(sql);
		if(rs.next()){
			return true;
		}
		return false;
	}
	
	//��֤�û����������Ƿ���ȷ
	public boolean studentLogin(String id,String password) throws SQLException{
		if(isExists(id)){
			String sql = "select* from table student where studentID="+id+" and studentPW="+password;
			ResultSet rs = ADUS.selectData(sql);
			if(rs.next()){
				return true;
			}
		}
		return false;
	}
	
	//��ѯѧ���ɼ���Ϣ����ʾ
/*	select courseName,courseTrem,teacherName,scoreNum 
	from score,course,teacher 
	where score.studentID="2015220204003" and course.courseID=score.courseID and course.teacherID=teacher.teacherID;*/
	public Map<Integer,List<String>> selectStuInfo(String id) throws SQLException{
		int count = 0;
		Map<Integer, List<String>> map = new HashMap<Integer,List<String>>();
		String sql = "select courseName,courseTrem,teacherName,scoreNum"+
					 "from score,course,teacher"+
	                 "where score.studentID=\""+id+"\" and course.courseID=score.courseID and course.teacherID=teacher.teacherID;";
		ResultSet rs = ADUS.selectData(sql);
		while(rs.next()){
			count++;
			List<String> als = new ArrayList<String>();
			als.add(rs.getString(1));
			als.add(rs.getString(2));
			als.add(rs.getString(3));
			als.add(rs.getString(4));
			
			map.put(count, als);
		}
		return map;
		
	}
}