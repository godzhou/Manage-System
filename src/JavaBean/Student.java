package JavaBean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;

import dao.ADUS;

public class Student extends ADUS{
	private String studentID;
	private String studentName;
	private int age;
	private String sex;
	private String birthday;
	private String majorID;
	private String password;
	
	public Student(){
		studentID = "";
		studentName = "";
		age = 0;
		sex = "";
		birthday = "1970-01-01";
		majorID = "";
		setPassword("");
	}
	
	public Student(String studentID, String studentName, int age, String sex,
			String birthday, String majorID,String password) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.majorID = majorID;
		this.setPassword(password);
	}
	
	/**
	 * 获取某个用户信息
	 */
	public boolean init(){
		String sql = "select * from student where studentID=";
		sql = sql + studentID;
		
		try{
			ResultSet rs = ADUS.selectData(sql);
			if(rs.next()){
				this.studentName = rs.getString("studentName");
				this.age = rs.getInt("age");
				this.sex = rs.getString("sex");
				this.birthday = rs.getString("birthday");
				this.majorID = rs.getString("majorID");
				this.setPassword(rs.getString("studentPW"));
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMajorID() {
		return majorID;
	}
	public void setMajorID(String majorID) {
		this.majorID = majorID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
