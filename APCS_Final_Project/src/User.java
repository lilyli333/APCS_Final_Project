import java.util.ArrayList;

import events.Activity;
import events.AssignmentList;
import events.SubjectList;

public class User {
	private String username, password;

	private ArrayList<String> colleges, majors;
	private AssignmentList aList;
	private SubjectList sList;
	private ArrayList<Activity> activities;

	public User(String username, String password) {
		this.username = username;
		this.password = password;

		colleges = new ArrayList<String>();
		majors = new ArrayList<String>();
		activities = new ArrayList<Activity>();
	}

	public void setAssignmentList(AssignmentList a) {
		aList = a;
	}

	public void addActivity(Activity act) {
		activities.add(act);
	}

	public void setSubjectList(SubjectList s) {
		sList = s;
	}

	public void addCollege(String college) {
		colleges.add(college);
	}

	public void addMajor(String major) {
		majors.add(major);
	}

	public void removeActivity(String m) {
		for(int i = 0; i<activities.size(); i++) {
			if(activities.get(i).equals(m)) {
				activities.remove(i);
			}
		} //end of for
	}

	public void removeCollege(String c) {
		for(int i = 0; i<colleges.size(); i++) {
			if(colleges.get(i).equals(c)) {
				colleges.remove(i);
			}
		} //end of for
	}

	public void removeMajor(String m) {
		for(int i = 0; i<majors.size(); i++) {
			if(majors.get(i).equals(m)) {
				majors.remove(i);
			}
		} //end of for
	}
	
}