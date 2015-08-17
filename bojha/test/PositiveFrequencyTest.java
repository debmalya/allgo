

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class PositiveFrequencyTest {

	/**
	 * Test method for {@link PositiveFrequency#maximumPositiveFrequency(int[], int)}.
	 */
	@Test
	public final void testMaximumPositiveFrequency() {	
		int actual = PositiveFrequency.maximumPositiveFrequency(new int[]{2,30,15,10,8,25,80}, 7);
		Assert.assertEquals(100, actual);
		
		actual = PositiveFrequency.maximumPositiveFrequency(new int[]{2,30,10,15,8,25,80}, 7);
		Assert.assertEquals(105, actual);
		
		actual = PositiveFrequency.maximumPositiveFrequency(new int[]{2,30,10,15,8,25,80}, 6);
		Assert.assertEquals(50, actual);
		
		int[] random = new int[10];
		for (int i = 0; i < 10; i++) {
			random[i] = (int)(Math.random()*100);
		}
		System.out.println(Arrays.toString(random));
		actual = PositiveFrequency.maximumPositiveFrequency(random, 10);
		System.out.println(actual);
		int actual1 = PositiveFrequency.maximumPositiveFrequency(random, 9);
		System.out.println(actual1);
		if (actual > actual1) {
			Assert.assertEquals(random[9] - random[8], actual - actual1);
		}else {
			Assert.assertTrue(random[9] < random[8]);
		}
		
		
	}

}
