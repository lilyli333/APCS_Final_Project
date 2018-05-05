package Screens;

import College.GPACalc;

/**
 * 
 * @author lilili
 *
 */
public class Main {
	
	public static void main(String[] args){
		Database.writeToDatabase(new String[] {"Lily", "4.0", "1600", "3"});
		double grade = GPACalc.weightedGPA(20, 1, 0, 0, 0, 6);
		System.out.println(grade);
		
		System.out.println(GPACalc.finalsGradesCalculator(95,93,0.1));
	}
}
