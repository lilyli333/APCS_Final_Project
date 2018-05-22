package functions;

public class Assignment {
	 private  String  subject;
     private  String assignment;
     private String duedate;
     private boolean isCompleted;
     private int time;
     private int priority;
     
     public Assignment(boolean isCompleted,String subject, String assignment, String duedate,int time,int priority) {
 		super();
 		this.subject = subject;
 		this.assignment = assignment;
 		this.duedate = duedate;
 		this.isCompleted = isCompleted;
 		this.time = time;
 		this.priority = priority;
 	}

     
	public boolean isCompleted() {
		return isCompleted;
	}


	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public String getSubject() {
		
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	


}
