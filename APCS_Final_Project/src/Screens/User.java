package Screens;

import java.util.ArrayList;

public class User {
	
	/*
	 * - name
	 * - gpa
	 * test score
	 * - points 
	 * subjects
	 * colleges ? 
	 * majors ?
	 * assignments
	 * 
	 * add points method
	 */
	
	public static void changeName(String name) {
		ArrayList<String> data = Database.getDatabase();
		
		for(String line : data) {
			if(line.indexOf("name") == 0) {
				data.remove(line);
				data.add(0, name);
				Database.name = name;
				break;
			}
		}
		
		Database.writeToDatabase((String[])data.toArray());
	}
	
	
	public static void changeGPA(double GPA) {
		ArrayList<String> data = Database.getDatabase();
		
		for(String line : data) {
			if(line.indexOf("GPA") == 0) {
				data.remove(line);
				data.add(1, GPA + "");
				Database.GPA = GPA;
				break;
			}
		}
		
		Database.writeToDatabase((String[])data.toArray());
	}
	
	public static void addPoint() {
ArrayList<String> data = Database.getDatabase();
		
		for(String line : data) {
			if(line.indexOf("point") == 0) {
				data.remove(line);
				data.add(3, (Database.point + 1) + "");
				Database.point++;
				break;
			}
		}
		
		Database.writeToDatabase((String[])data.toArray());
	}
}
