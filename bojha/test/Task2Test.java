import org.junit.Assert;
import org.junit.Test;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class Task2Test {

	/**
	 * Test method for {@link Task2#solution(java.lang.String)}.
	 */
	@Test
	public final void testSolution() {
		Task2 s = new Task2();
		String r = s.solution("ABBCC");

		r = s.solution("ABC");
		Assert.assertTrue("AC".equals(r));
	}

}
