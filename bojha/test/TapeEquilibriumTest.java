import org.junit.Assert;
import org.junit.Test;

import codility.timecomplexity.TapeEquilibrium;


public class TapeEquilibriumTest {

	@Test
	public void testSolution() {
		TapeEquilibrium jump = new TapeEquilibrium();
		int result = jump.solution(new int[]{3, 1, 2, 4, 3});
		Assert.assertEquals(1,result);
	}
	
	@Test
	public void testDouble() {
		TapeEquilibrium jump = new TapeEquilibrium();
		int result = jump.solution(new int[]{3, 1});
		Assert.assertEquals(2,result);
		
		result = jump.solution(new int[]{0, 2000});
		Assert.assertEquals(2000,result);
		
		result = jump.solution(new int[]{0, 20});
		Assert.assertEquals(20,result);
		
		result = jump.solution(new int[]{-1000, 1000});
		Assert.assertEquals(2000,result);
		
		result = jump.solution(new int[]{-10, 10});
		Assert.assertEquals(20,result);
		
		
	}

}
