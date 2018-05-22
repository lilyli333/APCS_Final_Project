package functions;

public class Activity {
	
	private String activity;
	private String time;
	
	public Activity(String activity, String time) {
		super();
		this.activity = activity;
		this.time = time;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
