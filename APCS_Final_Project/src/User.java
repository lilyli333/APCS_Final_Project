import java.util.ArrayList;

import events.AssignmentList;
import events.SubjectList;

public class User {
	private String username, password;

	private ArrayList<String> colleges, majors;
	private AssignmentList aList;
	private SubjectList sList;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		
		colleges = new ArrayList<String>();
		majors = new ArrayList<String>();
	}
	
	public void setAssignmentList(AssignmentList a) {
		aList = a;
	}
	
	public void setSubjectList(SubjectList s) {
		sList = s;
	}


}
