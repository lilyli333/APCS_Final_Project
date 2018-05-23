package college;
/**
 * represents a set of ACT scores, which includes writing/English/math/cumulative scores
 * only the cumulative score is currently used to calculate admission chances because some colleges does not have stats for all aspects
 * @author Lily 
 *
 */
public class ACTScores {
	private double writing, english, math, culmulative;
	
	public ACTScores(double writing, double english, double math, double culmulative) {
		this.writing = writing;
		this.english = english;
		this.math = math;
		this.culmulative = culmulative;
	}
	
	public ACTScores(double total) {
		culmulative = total;
		writing = -1;
		english = -1;
		math = -1;
	}
	
	public double getTotalScore() {
		return culmulative;
	}

}
