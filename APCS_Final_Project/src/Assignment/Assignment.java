package Assignment;

public class Assignment {

	private int timeLimit;
	private boolean isCompleted;
	private int pointsPossible;
	private String title;
	private int priority;
	
	public Assignment(int time, boolean isDone, int points, String name, int stars)
	{
		timeLimit = time;
		isCompleted = isDone;
		pointsPossible = points;
		title = name;
		priority = stars;
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
