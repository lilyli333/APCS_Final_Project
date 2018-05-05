package Assignment;

import java.util.ArrayList;

public class AssignmentList {
	
	private ArrayList<Assignment> assignments;
	
	public AssignmentList(ArrayList<Assignment> a)
	{
		assignments = a;
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
	

}
