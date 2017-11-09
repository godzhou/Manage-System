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

	//����û��Ƿ����
	public boolean isExists(String studentID) throws SQLException, ClassNotFoundException{
		String sql = "select * from student where studentID=\"" + studentID+"\";";
		ResultSet rs = ADUS.selectData(sql);
		if(rs.next()){
			return true;
		}
		return false;
	}
	
	//��ѯѧ������--->��Ȼ���Ѿ�����ѧ�������ˣ��������ȷ����������
	public String getStuName(String studentID) throws SQLException,ClassNotFoundException{
		String sql = "select studentName from student where studentID=\"" + studentID + "\";";
		ResultSet rs = ADUS.selectData(sql);
		rs.next();
		return rs.getString("studentName");
	}
	
	//��֤�û����������Ƿ���ȷ
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
	
	//��ѯѧ���ɼ���Ϣ����ʾ
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
	 * ѧ���޸���Ϣ�Ĳ������ܹ������޸ĵ������գ����䣨�Ժ�ĳ��Զ����㣩������
	 */
	//������˶����ڽ��и�ʽ��
	public boolean modifyStuBirth(String studentID,String date) throws SQLException,ClassNotFoundException{
		String sql = "update student set birthday=\"" + date + "\" where studentID=\"" + studentID + "\";";
		if(ADUS.updateData(sql) == 0){
			return true;
		}
		return false;
	}
	
	/*
	 * �޸��������
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
