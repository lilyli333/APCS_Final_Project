package events;

import java.util.ArrayList;

/**
 * This is a list of assignments
 * @author Anushka, Helen
 *
 */
public class AssignmentList {
	
	private ArrayList<Assignment> assignments;
	
	public AssignmentList() {
		assignments = new ArrayList<Assignment>();
	}
	
	public void deleteAssignment(String assignmentName)
	{
		for(Assignment a: assignments)
		{
			if(a.getTitle().equals(assignmentName))
			{
				assignments.remove(a);
			}
		}
	}
	
	public void addAssignment(Assignment a)
	{
		assignments.add(a);
	}
	
	public void addAssignment(Assignment a, int index)
	{
		assignments.add(index, a);
	}
	
	public void completeAssignment(String assignmentName) 
	{
		for(Assignment a: assignments)
		{
			if(a.getTitle().equals(assignmentName))
			{
				a.setCompleted(true);
				
			}
		}
		
	}
	
	public ArrayList<Assignment> getList() {
		return assignments;
	}
	
	public Assignment getAssignment(int index) {
		return assignments.get(index);
	}
	
	public int size() {
		return assignments.size();
	}

}
