import java.util.ArrayList;
import java.util.List;

/**
Implement stairs(N) that (collect the solutions in a list) prints all the ways to climb up a N-step-stairs 
where one can either take a single step or double step. 
We'll use 1 to represent a single step, and 2 to represent a double step. 


stairs(3) 
111 
12 
21
 * @author debmalyajash
 *
 */
public class Stairs {
	
	public String[] getSteps(int numerOfSteps) {
		List<String> result = new ArrayList<String>();
		
		StringBuilder eachResult = new StringBuilder();
		while (numerOfSteps > 1) {
			numerOfSteps /= 2;
			eachResult.append("2");
		}
		
		int twoCount = eachResult.length();
		if (numerOfSteps == 1) {
			eachResult.append("1");			
		}
		result.add(eachResult.toString());
		
		
		
		return result.toArray(new String[0]);
	}

}
