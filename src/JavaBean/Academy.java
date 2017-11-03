package JavaBean;

import java.io.Serializable;

public class Academy implements Serializable{

	private String academyID;
	private String academyName;
	
	public Academy() {
		super();
	}

	public Academy(String academyID, String academyName) {
		super();
		this.academyID = academyID;
		this.academyName = academyName;
	}

	public String getAcademyID() {
		return academyID;
	}

	public void setAcademyID(String academyID) {
		this.academyID = academyID;
	}

	public String getAcademyName() {
		return academyName;
	}

	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}
	
	
	
}
