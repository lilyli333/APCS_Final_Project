package events;

/**
 * This class represents the subjects/courses of the student, w subject name and the grade the student has in it
 * @author Helen
 *
 */
public class Subject {
	
	private String subjectName;
	private double gradePercentage;
	
	public Subject(String subjectName, double gradePercentage) {
		this.subjectName = subjectName;
		this.gradePercentage = gradePercentage;
	}
	
	public String getName() {
		return subjectName;
	}
	
	public double getGradePercentage() {
		return gradePercentage;
	}
	
	public String getLetterGrade() {
		if(gradePercentage >= 90) 
			return "A";
		else if(gradePercentage >= 80)
			return "B";
		else if(gradePercentage >= 70)
			return "C";
		else if(gradePercentage >= 60)
			return "D";
		else
			return "F";
	}
	
	public String toString( ) {
		return "Subject: " + subjectName + " Grade: " + getLetterGrade();
	}

}