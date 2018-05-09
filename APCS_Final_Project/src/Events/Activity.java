package Events;

/**
 * This class represents non-assignment activites (ie. extracurriculars, sports, free time)
 * It has a name, type, and start/end times
 * @author Helen
 */
public class Activity {
	private String activityName;
	private String activityType;
	private int startSeconds, endSeconds;
	
	/**
	 * @param activityName String of the activity name
	 * @param start Array for the start time, w/ start hours, min, and seconds at positions 0, 1, 2, respectively
	 * @param end Array for the start time, w/ end hours, min, and seconds at positions 0, 1, 2, respectively
	 * @param activityType String for the type of activity (sports, club, rest, etc)
	 */
	public Activity(String activityName, String activityType, int[] start, int[] end) {
		this.activityName = activityName;
		this.activityType = activityType;
		startSeconds = start[0]*3600+start[1]*60*start[2];
		endSeconds = start[0]*3600+start[1]*60*start[2];
	}
	
	/**
	 * @return the time in seconds that the activity takes
	 */
	public int getLength() {
		return endSeconds - startSeconds;
	}
	
	public String getActivityName() {
		return activityName;
	}
	public String getActivityType() {
		return activityType;
	}
	
	public int getStart() {
		return startSeconds;
	}
	
	public int getEnd() {
		return endSeconds;
	}
	
	public String toString() {
		String output = activityName + " - " + activityType + " start: " + 
				startSeconds + " end: "+ endSeconds;
		
		return output;
	}
	
}
