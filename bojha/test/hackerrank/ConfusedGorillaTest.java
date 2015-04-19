/**
 * 
 */
package hackerrank;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class ConfusedGorillaTest {

	/**
	 * Test method for {@link hackerrank.ConfusedGorilla#getPossibleSteps(int[])}.
	 */
	@Test
	public final void testGetPossibleSteps() {
		List<String> result = ConfusedGorilla.getPossibleSteps(new int[]{2});
		Assert.assertEquals("0 2", result.get(0));
		Assert.assertEquals("2 0", result.get(1));
		Assert.assertEquals("1 1", result.get(2));
		
		for (int i = 1; i < 10001; i++) {
			result = ConfusedGorilla.getPossibleSteps(new int[]{i});
			Assert.assertEquals((i+1), result.size());
		}
	}

}
