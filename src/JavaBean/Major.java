package JavaBean;

import java.io.Serializable;

public class Major implements Serializable{
	private String majorID;
	private String academyID;
	private String majorName;
	
	
	public Major(String majorID, String academyID, String majorName) {
		super();
		this.majorID = majorID;
		this.academyID = academyID;
		this.majorName = majorName;
	}
	
	public String getMajorID() {
		return majorID;
	}
	public void setMajorID(String majorID) {
		this.majorID = majorID;
	}
	public String getAcademyID() {
		return academyID;
	}
	public void setAcademyID(String academyID) {
		this.academyID = academyID;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	
}
