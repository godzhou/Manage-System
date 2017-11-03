package JavaBean;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	private String studentID;
	private String studentName;
	private int age;
	private String sex;
	private Date birthday;
	private String majorID;
	
	
	public Student(String studentID, String studentName, int age, String sex,
			Date birthday, String majorID) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.majorID = majorID;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMajorID() {
		return majorID;
	}
	public void setMajorID(String majorID) {
		this.majorID = majorID;
	}
	
	
}
