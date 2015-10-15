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
public class CodeFights50Test {

	/**
	 * Test method for {@link CodeFights50#nroot(int, int)}.
	 */
	@Test
	  public void test_Root() {
		int actual = CodeFights50.nroot (8, 3);
		Assert.assertEquals(2,actual);
	    
		actual = CodeFights50.nroot (1, 3);
		Assert.assertEquals(1,actual);
	    
		actual = CodeFights50.nroot (7, 3);
		Assert.assertEquals(2,actual);
	    
		actual = CodeFights50.nroot (9, 3);
		Assert.assertEquals(3,actual);
	    
		actual = CodeFights50.nroot (27, 3);
		Assert.assertEquals(3,actual);
	  }

	@Test
	public void test_HappyNumber(){
		int[] actuals = CodeFights50.HappyNumbers(1);
		int[] expecteds = new int[]{1};
		Assert.assertArrayEquals(expecteds, actuals);
		
		actuals = CodeFights50.HappyNumbers(2);
		expecteds = new int[]{1};
		Assert.assertArrayEquals(expecteds, actuals);
		
		actuals = CodeFights50.HappyNumbers(7);
		expecteds = new int[]{1,7};
		System.out.println(Arrays.toString(actuals));
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
