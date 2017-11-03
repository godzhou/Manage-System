package JavaBean;

import java.io.Serializable;

public class Teacher implements Serializable{
	private String teacherID;
	private String academyID;
	private String teacherName;
	private int age;
	
	public Teacher(String teacherID, String academyID, String teacherName,
			int age) {
		super();
		this.teacherID = teacherID;
		this.academyID = academyID;
		this.teacherName = teacherName;
		this.age = age;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getAcademyID() {
		return academyID;
	}

	public void setAcademyID(String academyID) {
		this.academyID = academyID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
