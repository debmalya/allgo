/**
 * 
 */
package deb.codefights;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class SummerTest {

	/**
	 * Test method for {@link deb.codefights.Summer#summer(int)}.
	 */
	@Test
	public final void testSummer() {
		long startTime = System.currentTimeMillis();
		int actual = Summer.summer(2);
		long endTime  = System.currentTimeMillis();
		Assert.assertEquals(1, actual);
		System.out.println("Time taken :" + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		actual = Summer.summer0(2);
	    endTime  = System.currentTimeMillis();
		Assert.assertEquals(1, actual);
		System.out.println("Time taken :" + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		actual = Summer.summer0(-2);
	    endTime  = System.currentTimeMillis();
		Assert.assertEquals(1, actual);
		System.out.println("Time taken :" + (endTime - startTime));
		
		
		startTime = System.currentTimeMillis();
		actual = Summer.summer0(Integer.MAX_VALUE);
	    endTime  = System.currentTimeMillis();
		Assert.assertEquals(31, actual);
		System.out.println("Time taken Library :" + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		actual = Summer.summer(Integer.MAX_VALUE);
	    endTime  = System.currentTimeMillis();
		Assert.assertEquals(31, actual);
		System.out.println("Time taken  :" + (endTime - startTime));
		
	}

}
