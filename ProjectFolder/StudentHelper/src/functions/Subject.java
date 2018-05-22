package functions;

public class Subject {
	
	private String classes;
	private String subjects;
	private String grades;
	public Subject(String classes, String subjects, String grades) {
		super();
		this.classes = classes;
		this.subjects = subjects;
		this.grades = grades;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getSubjects() {
		return subjects;
	}
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	public String getGrades() {
		return grades;
	}
	public void setGrades(String grades) {
		this.grades = grades;
	}
	

}
