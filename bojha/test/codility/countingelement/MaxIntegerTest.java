/**
 * 
 */
package codility.countingelement;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class MaxIntegerTest {

	@Test
	public final void test() {
		MaxInteger mi = new MaxInteger();
		int[] actuals = mi.solution(5, new int[]{3,4,4,6,1,4,4});
		Assert.assertArrayEquals(new int[]{3,2,2,4,2}, actuals);
		
		actuals = mi.solution(5, new int[]{3,4,4,6,1,6});
		Assert.assertArrayEquals(new int[]{3,3,3,3,3}, actuals);
		
		actuals = mi.solution(5, new int[]{3,4,4,6,1,6,4});
		Assert.assertArrayEquals(new int[]{3,3,3,4,3}, actuals);
		
		actuals = mi.solution(2, new int[]{3,3});
		Assert.assertArrayEquals(new int[]{0,0}, actuals);
	}

}
