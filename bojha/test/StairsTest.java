import static org.junit.Assert.*;

import org.junit.Test;


public class StairsTest {

	@Test
	public void testGetSteps() {
		Stairs stairs = new Stairs();
		String[] result = stairs.getSteps(3);
		printResult(result);
		
		result = stairs.getSteps(4);
		printResult(result);
	}

	public void printResult(String[] result) {
		for (String each:result) {
			System.out.println(each);
		}
		System.out.println("=================");
	}
}
