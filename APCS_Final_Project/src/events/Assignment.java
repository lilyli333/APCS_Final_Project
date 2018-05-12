package events;

/**
 * This represents assignments/tasks to be completed
 * It has times, whether it is done, names, points, and priority level
 * @author Anushka, Helen
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
		double diff = timeTaken-timeLimit;
		double percentage = diff/timeLimit; 
		double timePoints = pointsPossible/2; 
		
		if(percentage <= -0.5) 
			return pointsPossible;
		else if(percentage <= -0.25)
			return (int) (pointsPossible/2 + 7/8*timePoints);
		else if(percentage <= 0)
			return (int) (pointsPossible/2 + 6/8*timePoints);
		else if(percentage <= 0.25)
			return (int) (pointsPossible/2 + 5/8*timePoints);
		else if(percentage <= 0.5)
			return (int) (pointsPossible/2 + 4/8*timePoints);
		else if(percentage <= 0.75)
			return (int) (pointsPossible/2 + 3/8*timePoints);
		else if(percentage <= 0.875)
			return (int) (pointsPossible/2 + 2/8*timePoints);
		else if(percentage <= 0.9375)
			return (int) (pointsPossible/2 + 1/8*timePoints);
		else
			return (int) (pointsPossible/2);
	}

	public String getTitle() {
		return title;
	}

	public void rename(String title) {
		this.title = title;
	}
}
