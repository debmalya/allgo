import org.junit.Assert;
import org.junit.Test;


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
	}

}
