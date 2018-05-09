package Events;

import java.util.ArrayList;

/**
 * This is a list of Subjects
 * @author Helen
 *
 */
public class SubjectList {

	private ArrayList<Subject> subjects;

	public SubjectList()
	{
		subjects = new ArrayList<Subject>();
	}
	
	public void addSubject(Subject s) {
		subjects.add(s);
	}
		
	public void addSubject(Subject s, int index) {
		subjects.add(index, s);
	}
	
	public void deleteSubject(String subjectName) {
		for(Subject sub: subjects) {
			if(sub.getName().equals(subjectName))
			{
				subjects.remove(sub);
			}
		}
	}
	
	public ArrayList<Subject> getList() {
		return subjects;
	}
	
}
