/**
 * 
 */
package lambda.sample;

/**
 * @author debmalyajash
 *
 */
public class Student {
	private int graduationYear;
	private int score;
	/**
	 * @return the graduationYear
	 */
	public int getGraduationYear() {
		return graduationYear;
	}
	/**
	 * @param graduationYear the graduationYear to set
	 */
	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [graduationYear=" + graduationYear + ", score=" + score
				+ "]";
	}
	
	
}
