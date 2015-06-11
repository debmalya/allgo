import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class Task3Test {

	/**
	 * Test method for {@link Task3#solution(int[])}.
	 */
	@Test
	public final void testSolution() {
		Task3 task3 = new Task3();
		int result = task3.solution(new int[]{3,5,6,3,3,5});
		Assert.assertEquals(4, result);
		
		result = task3.solution(new int[]{3,5,6,3,3,5,6});
		Assert.assertEquals(5, result);
	}

}
