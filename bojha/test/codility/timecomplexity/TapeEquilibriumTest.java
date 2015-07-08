/**
 * 
 */
package codility.timecomplexity;



import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class TapeEquilibriumTest {

	/**
	 * Test method for {@link codility.timecomplexity.TapeEquilibrium#solution(int[])}.
	 */
	@Test
	public final void testSolution() {
		TapeEquilibrium t = new TapeEquilibrium();
		int actual = t.solution(new int[]{3,1,2,4,3});
		Assert.assertEquals(1, actual);
		
		actual = t.solution(new int[]{20});
		Assert.assertEquals(20, actual);
		
		actual = t.solution(new int[]{20,0});
		Assert.assertEquals(20, actual);
		
		actual = t.solution(new int[]{20,0,0});
		Assert.assertEquals(20, actual);
	}

}
