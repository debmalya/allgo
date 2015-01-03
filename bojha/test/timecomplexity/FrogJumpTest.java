package timecomplexity;

import org.junit.Assert;
import org.junit.Test;

public class FrogJumpTest {

	@Test
	public void test() {
		timecomplexity.FrogJump jump = new FrogJump();
		int r = jump.solution(10, 85, 30);
		Assert.assertTrue(r == 3);
		
		r = jump.solution(1000000000, 1000000000, 1000000000);
		Assert.assertTrue(r + " KO",r == 0);
		
		r = jump.solution(100000000, 1000000000, 100000000);
		Assert.assertTrue(r + " KO",r == 9);
	}

}
