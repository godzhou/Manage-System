package JavaBean;

import java.io.Serializable;

public class Score implements Serializable{
	private String scoreID;
	private String studentID;
	private String courseID;
	private String score;
	
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Score(String scoreID, String studentID, String courseID, String score) {
		super();
		this.scoreID = scoreID;
		this.studentID = studentID;
		this.courseID = courseID;
		this.score = score;
	}

	public String getScoreID() {
		return scoreID;
	}

	public void setScoreID(String scoreID) {
		this.scoreID = scoreID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	
}
