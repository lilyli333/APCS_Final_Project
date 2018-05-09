package Events;

/**
 * This represents assignments/tasks to be completed
 * It has times, whether it is done, names, points, and priority level
 * @author Anushka
 *
 */
public class Assignment {

	private int timeLimit;
	private boolean isCompleted;
	private String title;
	private int priority;
	private int pointsPossible;
	
	public Assignment(int time, boolean isDone, String name, int stars)
	{
		timeLimit = time;
		isCompleted = isDone;
		title = name;
		priority = stars;
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

	public int getPointsPossible() {
		return pointsPossible;
	}

	public void setPointsPossible(int pointsPossible) {
		this.pointsPossible = pointsPossible;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
