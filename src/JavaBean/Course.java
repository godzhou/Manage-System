package JavaBean;

import java.io.Serializable;

public class Course implements Serializable{

	private String courseID;
	private String teacherID;
	private String courseName;
	private String courseTrem;//¿ª¿ÎÑ§ÆÚ
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseID, String teacherID, String courseName,
			String courseTrem) {
		super();
		this.courseID = courseID;
		this.teacherID = teacherID;
		this.courseName = courseName;
		this.courseTrem = courseTrem;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTrem() {
		return courseTrem;
	}

	public void setCourseTrem(String courseTrem) {
		this.courseTrem = courseTrem;
	}
	
	
}
