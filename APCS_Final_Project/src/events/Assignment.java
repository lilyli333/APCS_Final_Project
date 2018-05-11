package events;

/**
 * This represents assignments/tasks to be completed
 * It has times, whether it is done, names, points, and priority level
 * @author Anushka, Helen for the getPoints method
 *
 */
public class Assignment {

	private int timeLimit;
	private boolean isCompleted;
	private String title;
	private int priority;
	private int timeTaken;
	private int pointsPossible;
	
	/**
	 * 
	 * @param the target time in seconds
	 * @param isDone whether the assignment has been completed
	 * @param name of task
	 * @param stars priority list, w/ 5 stars is the highest priority
	 */
	public Assignment(int time, boolean isDone, String name, int stars)
	{
		timeLimit = time;
		isCompleted = isDone;
		title = name;
		priority = stars;
		timeTaken = 0;
		pointsPossible = stars * 10;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	public void setTimeTaken(int t) {
		timeTaken = t;
	}
	
	public int getTimeTaken(int t) {
		return timeTaken;
	}

	public int getPointsPossible() {
		return pointsPossible;
	}

	/*public void setPointsPossible(int pointsPossible) {
		this.pointsPossible = pointsPossible;
	} */
	
	/**
	 * @return points based on the priority level and time taken to complete the assignment, max points = star*10
	 */
	public int getPoints() {
		//points for time
		int timePoints = timeTaken/timeLimit;
		//points for star (the number of stars)
		
		 return 0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
