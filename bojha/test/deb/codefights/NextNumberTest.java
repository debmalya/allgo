/**
 * 
 */
package deb.codefights;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class NextNumberTest {
	
	private NextNumber n = null;
	
	@Before
	public void initialize(){
		n = new NextNumber();
	}

	/**
	 * Test method for {@link deb.codefights.NextNumber#nextNumber(int)}.
	 */
	@Test
	public final void testNextNumber() {
		int actual = n.nextNumber(1);
		Assert.assertEquals(2, actual);
		
		actual = n.nextNumber(7);
		Assert.assertEquals(11, actual);
		
		actual = n.nextNumber(8);
		Assert.assertEquals(16, actual);
		
		actual = n.nextNumber(9);
		Assert.assertEquals(10, actual);
		
		actual = n.nextNumber(11);
		Assert.assertEquals(13, actual);
	}

}
