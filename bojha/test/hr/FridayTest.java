/**
 * 
 */
package hr;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class FridayTest {
	/**
	 * Test method for {@link Friday#process(java.lang.String)}.
	 */
	@Test
	public void testProcess() {
		int actual = Friday.process("01 10 2000 20 10 2000");
		Assert.assertEquals(1,actual);
		actual = Friday.process("19 10 1995 11 07 2015");
		Assert.assertEquals(34,actual);
		
		actual = Friday.process("01 01 1900 11 07 2015");
//		System.out.println(actual);
		Assert.assertEquals(199,actual);
		Assert.assertTrue(actual > 34);
		
		actual = Friday.process("01 01 1900 31 12 9999");
		
		
//		System.out.println(actual);
		Assert.assertTrue(actual > 34);
		Assert.assertEquals(13932,actual);
	}

}
